package yago.ferreira.orderms.infra.gatewayImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import yago.ferreira.orderms.application.dto.OrderCreatedEvent;
import yago.ferreira.orderms.application.response.OrderResponse;
import yago.ferreira.orderms.core.entities.Order;
import yago.ferreira.orderms.core.entities.OrderItem;
import yago.ferreira.orderms.gateway.OrderGateway;
import yago.ferreira.orderms.infra.entity.OrderEntity;
import yago.ferreira.orderms.infra.entity.OrderItemEntity;
import yago.ferreira.orderms.infra.mappers.OrderMapper;
import yago.ferreira.orderms.infra.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderGatewayImpl implements OrderGateway {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    public OrderGatewayImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void executeSave(Order entityModel) {
        OrderEntity orderEntity = new OrderEntity();
        OrderCreatedEvent event = orderMapper.toOrderCreatedEvent(entityModel);

        orderEntity.setOrderId(event.getCodigoPedido());
        orderEntity.setCustomerId(event.getCodigoCliente());
        orderEntity.setItems(orderMapper.modelItemToEntityItem(executeGetOrderItems(event)));
        orderEntity.setTotal(executeGetTotal(event));

        orderRepository.save(orderEntity);
    }

    @Override
    public Page<OrderResponse> executeFindAllByCustomerId(Long customerId, PageRequest pageRequest) {
        Page<OrderEntity> orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(orderMapper::toOrderResponse);
    }

    private List<OrderItem> executeGetOrderItems(OrderCreatedEvent event) {
        List<OrderItemEntity> orderItemEntities = event.getItens().stream().map(item ->
                new OrderItemEntity(item.getProduto(), item.getQuantidade(), item.getPreco())
        ).toList();

        return orderMapper.entityItemToModelItem(orderItemEntities);
    }

    private BigDecimal executeGetTotal(OrderCreatedEvent event) {
        return event.getItens()
                .stream()
                .map(item -> item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
