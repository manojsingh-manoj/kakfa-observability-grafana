package com.observability.orderservice.controller;

import com.observability.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static net.logstash.logback.argument.StructuredArguments.kv;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

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

    @PostMapping("/{orderId}/fail")
    public String failOrder(@PathVariable String orderId) {
        return orderService.failOrder(orderId);
    }

    @PostMapping("/unsafe")
    public String unsafe(@RequestBody String body) {
        log.info(
                "Received request", kv("requestBody", body)
        );
        return "received";
    }
}