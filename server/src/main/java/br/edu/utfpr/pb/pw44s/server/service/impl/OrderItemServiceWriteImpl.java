package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderItemServiceWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceWriteImpl extends CrudServiceWriteImpl<OrderItem, Long> implements IOrderItemServiceWrite {
    private final OrderItemRepository orderItemRepositoryRepository;

    public OrderItemServiceWriteImpl(OrderItemRepository orderItemRepositoryRepository) {
        this.orderItemRepositoryRepository = orderItemRepositoryRepository;
    }

    @Override
    protected JpaRepository<OrderItem, Long> getRepository() {
        return orderItemRepositoryRepository;
    }
}
