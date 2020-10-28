package com.fiap.pedido.service;

import com.fiap.pedido.domain.Order;
import com.fiap.pedido.domain.Product;
import com.fiap.pedido.domain.Status;
import com.fiap.pedido.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentAuthorizeClient paymentAuthorizeClient;
    private final ShippingRequestClient shippingRequestClient;

    @Autowired
    public OrderService(final OrderRepository orderRepository,
                        final PaymentAuthorizeClient paymentAuthorizeClient,
                        final ShippingRequestClient shippingRequestClient) {
        this.orderRepository = orderRepository;
        this.paymentAuthorizeClient = paymentAuthorizeClient;
        this.shippingRequestClient = shippingRequestClient;
    }

    @Transactional
    public Order create(final long userId, final List<Product> products) {
        final Order order = new Order()
                .setStatus(Status.CREATED)
                .setUserId(userId)
                .setCreatedOn(LocalDateTime.now())
                .setProducts(products);

        orderRepository.save(order);

        return order;

    }

    public Optional<Order> find(final long id) {
        return orderRepository.findById(id);
    }

    public boolean authorizePayment(final Order order) {
        if (order.getStatus().equals(Status.CREATED)) {
            final PaymentAuthorization authorize = paymentAuthorizeClient.authorize(order);
            if (authorize.isPaymentAuthorized()) {
                order.setPaymentId(authorize.getId());
                order.setStatus(Status.PROCESSED);
                orderRepository.save(order);
                return true;
            }
        }

        return false;
    }

    public Order findProcessedOrder(final long id) {
        return orderRepository.findByIdAndStatus(id, Status.PROCESSED);
    }

    public boolean shippingProducts(final Order order) {
        if (order.getStatus().equals(Status.PROCESSED)) {
            shippingRequestClient.request(order.getId());
            order.setStatus(Status.COMPLETED);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    public Page<Order> findAll() {
        return orderRepository.findAll(PageRequest.of(0, 10));
    }

    public boolean cancel(final Order orderToCancel) {
        if (!orderToCancel.getStatus().equals(Status.COMPLETED)) {
            orderToCancel.setStatus(Status.CANCELED);
            orderRepository.save(orderToCancel);
            return true;
        }

        return false;
    }
}
