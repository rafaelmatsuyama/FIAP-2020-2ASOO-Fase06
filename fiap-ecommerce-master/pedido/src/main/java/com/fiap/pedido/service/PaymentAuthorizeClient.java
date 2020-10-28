package com.fiap.pedido.service;

import com.fiap.pedido.domain.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentAuthorizeClient {

    @HystrixCommand(fallbackMethod = "authorizeFallback")
    public PaymentAuthorization authorize(final Order order) {
        final PaymentRequest request = new PaymentRequest("MASTER", order.getUserId(), order.totalAmount());

        final ResponseEntity<PaymentAuthorization> objectResponseEntity = new RestTemplate()
                .postForEntity("http://localhost:8081/payments", request, PaymentAuthorization.class);

        return objectResponseEntity.getBody();
    }

    private PaymentAuthorization authorizeFallback(final Order order) {
        return PaymentAuthorization.buildNotAuthorized();
    }

}
