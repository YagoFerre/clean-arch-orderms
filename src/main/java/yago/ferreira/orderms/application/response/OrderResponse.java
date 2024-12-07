package yago.ferreira.orderms.application.response;

import java.math.BigDecimal;

public record OrderResponse(
        Long codigoPedido,
        Long codigoCliente,
        BigDecimal total
) {
}
