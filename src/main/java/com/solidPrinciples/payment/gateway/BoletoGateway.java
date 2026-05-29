package com.solidPrinciples.payment.gateway;

import com.solidPrinciples.order.Order;

public class BoletoGateway implements PaymentGateway {
    @Override
    public void pay(Order order) {
        System.out.println("[PAYMENT] Processing via BOLETO...");
        System.out.printf("[PAYMENT] ✓ Boleto generated for R$%.2f — due in 3 business days%n", order.total());
    }
}