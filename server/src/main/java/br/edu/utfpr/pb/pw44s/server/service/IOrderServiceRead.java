package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderServiceRead extends ICrudServiceRead<Order, Long>{
    ResponseEntity<List<OrderDTO>> getOrdersByAuthenticatedUser();
}
