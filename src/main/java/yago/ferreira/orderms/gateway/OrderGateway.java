package yago.ferreira.orderms.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import yago.ferreira.orderms.application.response.OrderResponse;
import yago.ferreira.orderms.core.entities.Order;

public interface OrderGateway {
    void executeSave(Order entityModel);
    Page<OrderResponse> executeFindAllByCustomerId(Long customerId, PageRequest pageRequest);
}
