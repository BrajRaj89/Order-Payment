package com.payment.OrderPayment.service;
import com.payment.OrderPayment.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.payment.OrderPayment.dto.request.*;
import com.payment.OrderPayment.dto.response.*;
import com.payment.OrderPayment.dto.*;
import com.payment.OrderPayment.entity.*;
import java.util.*;

@Service
public class OrderService
{
    private final UserRepository userRepo;
    private final OrderRepository orderRepo;
    private final PaymentRepository paymentRepo;
    OrderService(UserRepository userRepo,OrderRepository orderRepo,PaymentRepository paymentRepo)
    {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.paymentRepo = paymentRepo;
    }
    public Order createOrder(String username, Double totalAmount, List<OrderItem> items)
    {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Order order = new Order();
        order.setUser(user);
        order.setStatus("CREATED");
        order.setTotalAmount(totalAmount);
        for (OrderItem item : items)
        {
            item.setOrder(order);
        }
        order.setItems(items);
        return orderRepo.save(order);
    }
    public OrderResponseDTO getOrderById(Long id)
    {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setUserId(order.getUser().getId());
        dto.setUsername(order.getUser().getUsername());
        List<OrderItemDTO> items = order.getItems().stream().map(item ->
        {
            OrderItemDTO i = new OrderItemDTO();
            i.setName(item.getName());
            i.setPrice(item.getPrice());
            i.setQuantity(item.getQuantity());
            return i;
        }).toList();
        dto.setItems(items);
        return dto;
    }

}


