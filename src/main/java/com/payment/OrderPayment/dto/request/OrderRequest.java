package com.payment.OrderPayment.dto.request;

public class OrderRequest
{
    private Double amount;
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
    public Double getAmount()
    {
        return amount;
    }
}
