package br.edu.utfpr.pb.pw44s.server.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
}
