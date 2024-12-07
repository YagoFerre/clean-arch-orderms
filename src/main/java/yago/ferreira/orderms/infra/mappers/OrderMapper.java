package yago.ferreira.orderms.infra.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import yago.ferreira.orderms.application.dto.OrderCreatedEvent;
import yago.ferreira.orderms.application.response.OrderResponse;
import yago.ferreira.orderms.core.entities.Order;
import yago.ferreira.orderms.core.entities.OrderItem;
import yago.ferreira.orderms.infra.entity.OrderEntity;
import yago.ferreira.orderms.infra.entity.OrderItemEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderId", target = "codigoPedido")
    @Mapping(source = "customerId", target = "codigoCliente")
    OrderCreatedEvent toOrderCreatedEvent(Order order);

    @Mapping(source = "codigoPedido", target = "orderId")
    @Mapping(source = "codigoCliente", target = "customerId")
    Order toOrder(OrderCreatedEvent orderCreatedEvent);

    Order entityToModel(OrderEntity entity);
    OrderEntity modelToEntity(Order entityModel);

    List<OrderItem> entityItemToModelItem(List<OrderItemEntity> entityItem);
    List<OrderItemEntity> modelItemToEntityItem(List<OrderItem> entityItemModel);

    @Mapping(source = "orderId", target = "codigoPedido")
    @Mapping(source = "customerId", target = "codigoCliente")
    OrderResponse toOrderResponse(OrderEntity orderEntityPage);
}
