package yago.ferreira.orderms.core.cases.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import yago.ferreira.orderms.application.response.OrderResponse;

public interface OrderFindAllByCustomerId {
    Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
