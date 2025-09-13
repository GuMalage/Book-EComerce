package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orderItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal unitPrice;

    private int quantity;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
