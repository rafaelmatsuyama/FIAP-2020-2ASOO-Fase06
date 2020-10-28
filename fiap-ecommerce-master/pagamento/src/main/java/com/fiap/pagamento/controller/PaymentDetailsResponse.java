package com.fiap.pagamento.controller;

import com.fiap.pagamento.domain.Payment;
import com.fiap.pagamento.domain.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDetailsResponse {

    private final long id;
    private final int installments;
    private final PaymentMethod paymentMethod;
    private final BigDecimal amount;
    private final LocalDateTime createdAt;

    PaymentDetailsResponse(final Payment payment) {
        id = payment.getId();
        installments = payment.getInstallments();
        paymentMethod = payment.getPaymentMethod();
        amount = payment.getAmount();
        createdAt = payment.getCreatedAt();
    }

    public long getId() {
        return id;
    }

    public int getInstallments() {
        return installments;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
