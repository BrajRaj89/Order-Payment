package com.payment.OrderPayment.dto.request;



public class PaymentRequest
{
    private Long orderId;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
