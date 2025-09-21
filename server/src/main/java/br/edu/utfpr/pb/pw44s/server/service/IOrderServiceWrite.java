package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderServiceWrite extends ICrudServiceWrite<Order, Long>{
    OrderDTO SaveCompleteOrder(OrderDTO orderDTO);
}
