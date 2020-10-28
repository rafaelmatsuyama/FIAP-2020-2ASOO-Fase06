package com.fiap.pedido.service;

import java.time.LocalDateTime;

public class PaymentAuthorization {

    private long id;
    private LocalDateTime createdAt;

    public static PaymentAuthorization buildNotAuthorized() {
        return new PaymentAuthorization().setId(0).setCreatedAt(LocalDateTime.now());
    }

    public boolean isPaymentAuthorized() {
        return this.id > 0 && createdAt != null;
    }

    public long getId() {
        return id;
    }

    public PaymentAuthorization setId(final long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PaymentAuthorization setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
