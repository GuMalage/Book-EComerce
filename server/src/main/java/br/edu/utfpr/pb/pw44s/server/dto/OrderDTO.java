package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private LocalDateTime dateOrder;
    private User user;
}
