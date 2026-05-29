package com.solidPrinciples.payment.gateway;

import com.solidPrinciples.order.Order;

public interface PaymentGateway {
    void pay(Order order);
}
