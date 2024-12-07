package yago.ferreira.orderms.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemEvent {
    private String produto;
    private Integer quantidade;
    private BigDecimal preco;
}
