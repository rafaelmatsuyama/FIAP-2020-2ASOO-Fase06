package com.fiap.pedido.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "orders")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private Long paymentId;
    private Long shippingId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdOn;
    @Version
    private Integer version;

    public Order() {
    }

    public Order(final long id, final long userId, final Long paymentId, final Long shippingId, final List<Product> products, final Status status, final LocalDateTime createdOn, final Integer version) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.shippingId = shippingId;
        this.products = products;
        this.status = status;
        this.createdOn = createdOn;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public Order setId(final long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Order setUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public Order setPaymentId(final Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public Order setShippingId(final Long shippingId) {
        this.shippingId = shippingId;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Order setProducts(final List<Product> products) {
        this.products = products;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Order setStatus(final Status status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Order setCreatedOn(final LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public Order setVersion(final Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                Objects.equals(paymentId, order.paymentId) &&
                Objects.equals(shippingId, order.shippingId) &&
                Objects.equals(products, order.products) &&
                status == order.status &&
                Objects.equals(createdOn, order.createdOn) &&
                Objects.equals(version, order.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, paymentId, shippingId, products, status, createdOn, version);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", paymentId=" + paymentId +
                ", shippingId=" + shippingId +
                ", products=" + products +
                ", status=" + status +
                ", createdOn=" + createdOn +
                ", version=" + version +
                '}';
    }

    public BigDecimal totalAmount() {
        return getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
