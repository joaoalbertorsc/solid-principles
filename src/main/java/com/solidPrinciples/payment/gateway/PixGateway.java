package com.solidPrinciples.payment.gateway;

import com.solidPrinciples.order.Order;

public class PixGateway implements PaymentGateway {
    @Override
    public void pay(Order order) {
        System.out.println("[PAYMENT] Processing via PIX...");
        System.out.printf("[PAYMENT] ✓ R$%.2f paid successfully via Pix%n", order.total());
    }
}