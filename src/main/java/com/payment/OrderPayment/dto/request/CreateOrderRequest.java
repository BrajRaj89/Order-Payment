package com.payment.OrderPayment.dto.request;
import java.util.List;

public class CreateOrderRequest {

    private String username;
    private Double amount;
    private List<OrderItemRequest> items;

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }
}

