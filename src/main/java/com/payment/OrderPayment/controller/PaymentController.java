package com.payment.OrderPayment.controller;

import com.payment.OrderPayment.dto.request.PaymentRequest;
import com.payment.OrderPayment.dto.response.PaymentResponse;
import com.payment.OrderPayment.entity.Payment;
import com.payment.OrderPayment.service.OrderService;
import com.payment.OrderPayment.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }
    @PostMapping
    public Payment makePayment(@RequestBody Map<String, Object> body) {
        Long orderId = Long.valueOf(body.get("orderId").toString());
        Double amount = Double.valueOf(body.get("amount").toString());

        return paymentService.makePayment(orderId, amount);
    }
}


