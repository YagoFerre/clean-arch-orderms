package yago.ferreira.orderms.core.cases.order;

import yago.ferreira.orderms.core.entities.Order;

public interface OrderSaveUseCase {
    void save(Order entityModel);
}
