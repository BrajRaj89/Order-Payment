package com.payment.OrderPayment.dto.response;

public class PaymentResponse
{
    private Long paymentId;
    private String status;

    public void setPaymentId(Long paymentId)
    {
        this.paymentId = paymentId;
    }

    public Long getPaymentId()
    {
        return paymentId;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
