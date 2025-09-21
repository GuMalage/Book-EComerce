package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.*;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceRead;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceReadImpl extends CrudServiceReadImpl<Order, Long> implements IOrderServiceRead {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final AuthService authService;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceReadImpl(OrderRepository orderRepository, ModelMapper modelMapper, AuthService authService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.authService = authService;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrdersByAuthenticatedUser() {
        User currentUser = authService.getAuthenticatedUser();

        // Fetch all orders for the authenticated user
        List<Order> userOrders = orderRepository.findByUser(currentUser);

        // Map each Order to ResponseOrderDTO
        List<OrderDTO> responseOrders = userOrders.stream()
                .map(order -> {
                    // Convert Order to ResponseOrderDTO
                    OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

                    // Fetch associated OrderItems for this order
                    List<OrderItem> orderItems = orderItemRepository.findByOrder_Id(order.getId());

                    // Map OrderItems to ResponseOrderItemDTO and set in the orderDTO
                    List<OrderItemDTO> orderItemDTOs = orderItems.stream()
                            .map(item -> {

                                OrderItemDTO itemDTO = new OrderItemDTO();
                                itemDTO.setId(item.getId());
                                itemDTO.setQuantity(item.getQuantity());
                                itemDTO.setProductName(item.getProduct().getName());
                                itemDTO.setProductId(item.getProduct().getId());
                                itemDTO.setProductPrice(item.getUnitPrice());
                                return itemDTO;
                            })
                            .collect(Collectors.toList());

                    orderDTO.setItemsList(orderItemDTOs);
                    return orderDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseOrders);
    }
}
