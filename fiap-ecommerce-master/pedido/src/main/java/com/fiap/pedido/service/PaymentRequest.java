package com.fiap.pedido.service;

import java.math.BigDecimal;

public class PaymentRequest {
    private String paymentMethod;
    private long userId;
    private BigDecimal amount;

    public PaymentRequest() {
    }

    public PaymentRequest(final String paymentMethod, final long userId, final BigDecimal amount) {
        this.paymentMethod = paymentMethod;
        this.userId = userId;
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentRequest setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public PaymentRequest setUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentRequest setAmount(final BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
