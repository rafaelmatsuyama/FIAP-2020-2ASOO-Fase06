package com.fiap.pedido.controller;

import com.fiap.pedido.domain.Product;

import java.util.List;

public class CreateOrderRequest {
    private long userId;
    private List<Product> products;

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
