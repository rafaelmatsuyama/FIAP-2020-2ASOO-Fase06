package com.fiap.estoque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long produtct;
    private BigDecimal price;
    private int quantity;

    public Item() {
    }

    public Item(final long produtct, final BigDecimal price, final int quantity) {
        this.produtct = produtct;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public Item setId(final long id) {
        this.id = id;
        return this;
    }

    public long getProdutct() {
        return produtct;
    }

    public Item setProdutct(final long produtct) {
        this.produtct = produtct;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(final BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item setQuantity(final int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Item item = (Item) o;
        return id == item.id &&
                produtct == item.produtct &&
                quantity == item.quantity &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produtct, price, quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", produtct=" + produtct +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
