package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderItem")
public class OrderItemController extends CrudController <OrderItem, OrderItemDTO, Long>{
    private final IOrderItemServiceWrite orderItemServiceWrite;
    private final IOrderItemServiceRead orderItemServiceRead;
    private final ModelMapper modelMapper;

    public OrderItemController(IOrderItemServiceWrite orderItemServiceWrite, IOrderItemServiceRead orderItemServiceRead, ModelMapper modelMapper){
        super(OrderItem.class, OrderItemDTO.class);
        this.orderItemServiceWrite = orderItemServiceWrite;
        this.orderItemServiceRead = orderItemServiceRead;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudServiceWrite<OrderItem, Long> getWriteService() {
        return this.orderItemServiceWrite;
    }

    @Override
    protected ICrudServiceRead<OrderItem, Long> getReadService() {
        return this.orderItemServiceRead;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
