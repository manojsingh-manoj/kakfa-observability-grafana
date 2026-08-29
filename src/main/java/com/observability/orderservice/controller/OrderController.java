package com.observability.orderservice.controller;

import com.observability.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/ping")
    public String ping() {
        return orderService.ping();
    }

    @PostMapping("/{orderId}")
    public String createOrder(@PathVariable String orderId) {
        return orderService.createOrder(orderId);
    }
}