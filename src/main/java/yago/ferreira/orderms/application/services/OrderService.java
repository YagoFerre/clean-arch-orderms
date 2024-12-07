package yago.ferreira.orderms.application.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import yago.ferreira.orderms.application.dto.OrderCreatedEvent;
import yago.ferreira.orderms.application.response.OrderResponse;
import yago.ferreira.orderms.core.entities.Order;
import yago.ferreira.orderms.gateway.OrderGateway;
import yago.ferreira.orderms.infra.mappers.OrderMapper;

@Service
public class OrderService {
    private final OrderGateway orderGateway;
    private final OrderMapper orderMapper;

    public OrderService(OrderGateway orderGateway, OrderMapper orderMapper) {
        this.orderGateway = orderGateway;
        this.orderMapper = orderMapper;
    }

    public void save(OrderCreatedEvent event) {
        Order orderEntity = orderMapper.toOrder(event);
        orderGateway.executeSave(orderEntity);
    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        return orderGateway.executeFindAllByCustomerId(customerId, pageRequest);
    }
}
