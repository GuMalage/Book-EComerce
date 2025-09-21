package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceWrite;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceWriteImpl extends CrudServiceWriteImpl<Order, Long> implements IOrderServiceWrite {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductServiceReadImpl productServiceRead;
    private final AuthService authService;

    public OrderServiceWriteImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, AuthService authService, ProductServiceReadImpl productServiceRead) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productServiceRead = productServiceRead;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }


    public OrderDTO SaveCompleteOrder(OrderDTO entity) {
        Order order = new Order();
        order.setDateOrder(LocalDateTime.now());
        order.setUser(authService.getAuthenticatedUser());
        orderRepository.save(order);

        for(OrderItemDTO dtoItem : entity.getItemsList()) {
            OrderItem item = new OrderItem();
            Product product = productServiceRead.findOne(dtoItem.getProductId());
            item.setOrder(order);
            item.setUnitPrice(product.getPrice());
            item.setQuantity(dtoItem.getQuantity());
            item.setProduct(product);

            orderItemRepository.save(item);
        }

        entity.setId(order.getUser().getId());
        return entity;
    }
}
