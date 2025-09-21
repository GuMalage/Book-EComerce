package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderItemServiceRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceReadImpl extends CrudServiceReadImpl<OrderItem, Long> implements IOrderItemServiceRead {
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceReadImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    protected JpaRepository<OrderItem, Long> getRepository() {return orderItemRepository;}

}
