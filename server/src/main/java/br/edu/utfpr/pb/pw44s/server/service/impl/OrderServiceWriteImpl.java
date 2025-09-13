package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceWriteImpl extends CrudServiceWriteImpl<Order, Long> implements IOrderServiceWrite {
    private final OrderRepository orderRepository;

    public OrderServiceWriteImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }
}
