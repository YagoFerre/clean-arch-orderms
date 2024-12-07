package yago.ferreira.orderms.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderCreatedEvent {
    private Long codigoPedido;
    private Long codigoCliente;
    private List<ItemEvent> itens = new ArrayList<>();
}
