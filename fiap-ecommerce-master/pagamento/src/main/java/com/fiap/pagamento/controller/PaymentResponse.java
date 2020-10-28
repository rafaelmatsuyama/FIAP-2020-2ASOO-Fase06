package com.fiap.pagamento.controller;

import com.fiap.pagamento.domain.Payment;

import java.time.LocalDateTime;

public class PaymentResponse {

    private final long id;
    private final LocalDateTime createdAt;

    public PaymentResponse(final Payment payment) {
        id = payment.getId();
        createdAt = payment.getCreatedAt();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }
}
