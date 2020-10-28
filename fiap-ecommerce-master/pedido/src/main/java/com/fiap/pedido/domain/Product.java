package com.fiap.pedido.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long productId;
    @Column(nullable = false)
    private BigDecimal price;

    public Product() {
    }

    public Product(final long productId, final BigDecimal price) {
        this.productId = productId;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public Product setProductId(final long productId) {
        this.productId = productId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(final BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                '}';
    }
}
