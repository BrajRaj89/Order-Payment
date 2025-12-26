package com.payment.OrderPayment.controller;
import com.payment.OrderPayment.entity.*;
import com.payment.OrderPayment.repository.OrderRepository;
import com.payment.OrderPayment.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.payment.OrderPayment.dto.request.*;
import com.payment.OrderPayment.dto.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    private final OrderService orderService;
    private final OrderRepository orderRepo;
    OrderController(OrderService orderService, OrderRepository orderRepo)
    {
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }
    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request)
    {
        List<OrderItem> items = request.getItems().stream().map(req -> {
                    OrderItem item = new OrderItem();
                    item.setName(req.getName());
                    item.setPrice(req.getPrice());
                    item.setQuantity(req.getQuantity());
                    return item;
                })
                .toList();
        return orderService.createOrder(request.getUsername(), request.getAmount(), items);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

}


