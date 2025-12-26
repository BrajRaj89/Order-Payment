package com.payment.OrderPayment.repository;
import com.payment.OrderPayment.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {}
