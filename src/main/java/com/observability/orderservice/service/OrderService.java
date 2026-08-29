package com.observability.orderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    public String ping() {
        log.atInfo()
                .addKeyValue("operation", "ping")
                .log("Processing order service ping");

        return "order-service is running";
    }

    public String createOrder(String orderId) {
        // This outputs directly to the JSON root via the <arguments/> provider
        log.info("Order created",
                kv("operation", "create_order"),
                kv("orderId", orderId)
        );

        return "Order " + orderId + " created";
    }
}