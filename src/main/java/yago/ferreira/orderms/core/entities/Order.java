package yago.ferreira.orderms.core.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long orderId;
    private Long customerId;
    private BigDecimal total;
    private List<OrderItem> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Long orderId, Long customerId, BigDecimal total, List<OrderItem> itens) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
        this.itens = itens;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public void setItens(List<OrderItem> itens) {
        this.itens = itens;
    }

}
