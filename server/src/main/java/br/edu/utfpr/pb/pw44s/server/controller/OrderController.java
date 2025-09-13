package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.IOrderServiceWrite;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends CrudController<Order, OrderDTO, Long>{
    private final IOrderServiceWrite orderServiceWrite;
    private final IOrderServiceRead orderServiceRead;
    private final ModelMapper modelMapper;

    public OrderController(IOrderServiceWrite orderServiceWrite, IOrderServiceRead orderServiceRead, ModelMapper modelMapper) {
        super(Order.class, OrderDTO.class);
        this.orderServiceWrite = orderServiceWrite;
        this.orderServiceRead = orderServiceRead;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudServiceWrite<Order, Long> getWriteService() {
        return null;
    }

    @Override
    protected ICrudServiceRead<Order, Long> getReadService() {
        return null;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return null;
    }
}
