package com.payment.OrderPayment.service;

import com.payment.OrderPayment.entity.Order;
import com.payment.OrderPayment.entity.Payment;
import com.payment.OrderPayment.repository.OrderRepository;
import com.payment.OrderPayment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository paymentRepo;
    private OrderRepository orderRepo;
    PaymentService(PaymentRepository paymentRepo, OrderRepository orderRepo)
    {
        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }
    public Payment makePayment(Long orderId, Double amount) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (paymentRepo.existsByOrder(order))
            throw new RuntimeException("Payment already exists for this order");

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setStatus("SUCCESS");

        order.setStatus("PAID");
        orderRepo.save(order);

        return paymentRepo.save(payment);
    }
}
