package yago.ferreira.orderms.core.cases.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import yago.ferreira.orderms.application.response.OrderResponse;
import yago.ferreira.orderms.gateway.OrderGateway;

public class OrderFindAllByCustomerIdImpl implements OrderFindAllByCustomerId {
    private final OrderGateway orderGateway;

    public OrderFindAllByCustomerIdImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        return orderGateway.executeFindAllByCustomerId(customerId, pageRequest);
    }
}
