package com.payment.OrderPayment.repository;
import com.payment.OrderPayment.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    boolean existsByOrder(Order order);
}
