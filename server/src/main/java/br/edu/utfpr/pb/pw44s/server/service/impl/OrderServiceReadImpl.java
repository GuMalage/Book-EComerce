package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceReadImpl extends CrudServiceReadImpl<Order, Long> implements IOrderServiceRead {
    private final OrderRepository orderRepository;

    public OrderServiceReadImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }
}
