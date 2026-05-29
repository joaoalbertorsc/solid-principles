package com.solidPrinciples.order;

import java.util.Collections;
import java.util.List;

public class Order {
    private final String customer;
    private final List<Item> items;
    private final String deliveryAddress;

    Order(String customer, List<Item> items, String deliveryAddress) {
        this.customer = customer;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
    }

    public double total() {
        return items.stream().mapToDouble(Item::subtotal).sum();
    }

    public String getCustomer() { return customer; }
    public List<Item> getItems() { return Collections.unmodifiableList(items); }
    public String getDeliveryAddress() { return deliveryAddress; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========================================\n");
        sb.append("         ORDER SUMMARY\n");
        sb.append("========================================\n");
        sb.append(String.format("Customer : %s%n", customer));
        sb.append(String.format("Address  : %s%n", deliveryAddress));
        sb.append("Items    :\n");
        items.forEach(i -> sb.append(String.format("  - %-15s x%d  R$%.2f%n", i.getName(), i.getQuantity(), i.subtotal())));
        sb.append("----------------------------------------\n");
        sb.append(String.format("Total    : R$%.2f%n", total()));
        sb.append("========================================");
        return sb.toString();
    }
}
