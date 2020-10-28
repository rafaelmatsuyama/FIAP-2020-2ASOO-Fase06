package com.fiap.pagamento.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private BigDecimal amount;
    private int installments;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDateTime createdAt;

    public Payment() {
    }

    public Payment(final long userId, final BigDecimal amount, final int installments, final PaymentMethod paymentMethod, final LocalDateTime createdAt) {
        this.userId = userId;
        this.amount = amount;
        this.installments = installments;
        this.paymentMethod = paymentMethod;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public Payment setId(final long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Payment setUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Payment setAmount(final BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public int getInstallments() {
        return installments;
    }

    public Payment setInstallments(final int installments) {
        this.installments = installments;
        return this;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Payment setPaymentMethod(final PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Payment setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Payment payment = (Payment) o;
        return id == payment.id &&
                userId == payment.userId &&
                installments == payment.installments &&
                Objects.equals(amount, payment.amount) &&
                paymentMethod == payment.paymentMethod &&
                Objects.equals(createdAt, payment.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, amount, installments, paymentMethod, createdAt);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", installments=" + installments +
                ", paymentMethod=" + paymentMethod +
                ", createdAt=" + createdAt +
                '}';
    }
}
