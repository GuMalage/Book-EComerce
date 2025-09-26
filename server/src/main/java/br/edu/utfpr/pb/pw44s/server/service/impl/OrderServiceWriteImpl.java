package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceWrite;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;
    private BigDecimal totalOrderPrice=BigDecimal.ZERO;

    public OrderServiceWriteImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, AuthService authService, ProductServiceReadImpl productServiceRead, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productServiceRead = productServiceRead;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }


    @Override
    public OrderDTO SaveCompleteOrder(OrderDTO entity) {
        Order order;
        if (entity.getId() != null) {
            // Atualiza pedido existente
            order = orderRepository.findById(entity.getId())
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado: " + entity.getId()));
        } else {
            // Cria novo pedido
            order = new Order();
            order.setDateOrder(LocalDateTime.now());
            order.setUser(authService.getAuthenticatedUser());
            order = orderRepository.save(order); // salva para gerar ID
        }

        BigDecimal totalOrderPrice = BigDecimal.ZERO;

        for (OrderItemDTO dtoItem : entity.getItemsList()) {
            Product product = productServiceRead.findOne(dtoItem.getProductId());

            // Verifica se item já existe no pedido
            OrderItem item = orderItemRepository.findByOrderIdAndProductId(order.getId(), product.getId())
                    .orElse(new OrderItem());

            item.setOrder(order);
            item.setProduct(product);
            item.setUnitPrice(product.getPrice());
            item.setQuantity(dtoItem.getQuantity());

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(dtoItem.getQuantity()));
            item.setTotalPriceItems(itemTotal);

            totalOrderPrice = totalOrderPrice.add(itemTotal);

            orderItemRepository.save(item); // salva ou atualiza o item
        }

        order.setTotalPrice(totalOrderPrice);
        orderRepository.save(order); // salva total atualizado

        entity.setId(order.getId());
        return entity;
    }


    @Override
    public void UpdateOrder(OrderDTO entity) {
        Order order = orderRepository.findById(entity.getId())
                .orElseThrow(() -> new RuntimeException("Order não encontrado: " + entity.getId()));

        // Busca os itens do pedido diretamente no banco
        List<OrderItem> items = orderItemRepository.findByOrder_Id(order.getId());

        BigDecimal totalOrderPrice = BigDecimal.ZERO;

        for (OrderItem item : items) {
            totalOrderPrice = totalOrderPrice.add(
                    item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
            );
        }

        order.setTotalPrice(totalOrderPrice);
        orderRepository.save(order);
    }





}
