package com.solidPrinciples.payment.service;

import com.solidPrinciples.order.Order;
import com.solidPrinciples.payment.exceptions.PaymentException;
import com.solidPrinciples.payment.gateway.PaymentGateway;

public class PaymentService {
    private PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void switchGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void process(Order order) {
        try {
            gateway.pay(order);
        } catch (PaymentException e) {
            System.err.println("[PAYMENT] ✗ " + e.getMessage());
            throw e;
        }
    }
}
