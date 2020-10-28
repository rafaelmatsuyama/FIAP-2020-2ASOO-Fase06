package com.fiap.pedido.controller;

import com.fiap.pedido.domain.Order;
import com.fiap.pedido.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(
        path = "/orders"
)
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Page<Order> list() {
        return orderService.findAll();
    }

    @GetMapping(
            path = "{id}"
    )
    public ResponseEntity<Order> details(@PathVariable("id") long orderId) {
        final Optional<Order> order = orderService.find(orderId);

        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateOrderRequest createOrderRequest) throws URISyntaxException {

        final Order order = orderService.create(createOrderRequest.getUserId(), createOrderRequest.getProducts());
        orderService.authorizePayment(order);

        return ResponseEntity.created(
                new URI("/orders/" + order.getId())
        ).build();
    }
}
