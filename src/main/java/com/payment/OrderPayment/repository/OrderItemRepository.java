package com.payment.OrderPayment.repository;
import com.payment.OrderPayment.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}

