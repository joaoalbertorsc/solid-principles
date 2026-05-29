package com.solidPrinciples.payment.gateway;

import com.solidPrinciples.order.Order;
import com.solidPrinciples.payment.exceptions.PaymentException;

public class CreditCardGateway implements PaymentGateway {
    private final String cardNumber;

    public CreditCardGateway(String cardNumber) {
        if (cardNumber == null || cardNumber.isBlank())
            throw new PaymentException("Card number is required");
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(Order order) {
        System.out.println("[PAYMENT] Processing via CREDIT CARD...");
        System.out.printf("[PAYMENT] ✓ R$%.2f paid successfully via Credit Card ending in %s%n",
                order.total(), cardNumber.substring(cardNumber.length() - 4));
    }
}