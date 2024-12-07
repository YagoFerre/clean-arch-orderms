package yago.ferreira.orderms.core.cases.order;

import yago.ferreira.orderms.core.entities.Order;
import yago.ferreira.orderms.gateway.OrderGateway;

public class OrderSaveUseCaseImpl implements OrderSaveUseCase {
    private final OrderGateway orderGateway;

    public OrderSaveUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public void save(Order order) {
        orderGateway.executeSave(order);
    }
}
