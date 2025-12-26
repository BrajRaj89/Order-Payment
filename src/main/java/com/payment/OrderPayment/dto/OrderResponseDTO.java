package com.payment.OrderPayment.dto;

import java.util.List;

public class OrderResponseDTO
{

    private Long orderId;
    private Double totalAmount;
    private String status;
    private Long userId;
    private String username;
    private List<OrderItemDTO> items;
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
    public Long getUserId()
    {
        return userId;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return username;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }
    public Long getOrderId()
    {
        return orderId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getStatus()
    {
        return status;
    }
    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    public Double getTotalAmount()
    {
        return totalAmount;
    }
    public void setItems(List<OrderItemDTO> items)
    {
        this.items = items;
    }
    public List<OrderItemDTO> getItems()
    {
        return items;
    }
}
