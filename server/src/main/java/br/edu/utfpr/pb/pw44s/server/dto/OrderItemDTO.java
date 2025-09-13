package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private BigDecimal unitPrice;
    private int quantity;
    private Order order;
    private Product product;
}
