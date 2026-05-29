package com.solidPrinciples.order;

import com.solidPrinciples.order.exceptions.OrderValidationException;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private String customer;
    private String deliveryAddress;
    private final List<Item> items = new ArrayList<>();

    public OrderBuilder customer(String customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder deliveryAddress(String address) {
        this.deliveryAddress = address;
        return this;
    }

    public OrderBuilder addItem(String name, double price, int quantity) {
        validateItem(name, price, quantity);
        items.add(new Item(name, price, quantity));
        return this;
    }

    private static void validateItem(String name, double price, int quantity) {
        if (price <= 0) throw new OrderValidationException("Price must be greater than zero: " + name);
        if (quantity <= 0) throw new OrderValidationException("Quantity must be greater than zero: " + name);
    }

    public Order build() {
        validateOrder();
        return new Order(customer, items, deliveryAddress);
    }

    private void validateOrder() {
        if (customer == null || customer.isBlank()) throw new OrderValidationException("Customer is required");
        if (deliveryAddress == null || deliveryAddress.isBlank()) throw new OrderValidationException("Delivery address is required");
        if (items.isEmpty()) throw new OrderValidationException("Order must have at least one item");
    }
}

