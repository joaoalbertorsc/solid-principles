package com.solidPrinciples;

import com.solidPrinciples.notification.channel.NotificationChannel;
import com.solidPrinciples.notification.factory.EmailChannelFactory;
import com.solidPrinciples.notification.factory.NotificationChannelFactory;
import com.solidPrinciples.notification.factory.SmsChannelFactory;
import com.solidPrinciples.order.Order;
import com.solidPrinciples.order.OrderBuilder;
import com.solidPrinciples.order.exceptions.OrderValidationException;
import com.solidPrinciples.payment.exceptions.PaymentException;
import com.solidPrinciples.payment.gateway.BoletoGateway;
import com.solidPrinciples.payment.gateway.CreditCardGateway;
import com.solidPrinciples.payment.gateway.PixGateway;
import com.solidPrinciples.payment.service.PaymentService;

public class Main {
    public static void main(String[] args) {

        Order order;
        try {
            order = new OrderBuilder()
                    .customer("João Alberto")
                    .deliveryAddress("Brasília - DF")
                    .addItem("Teclado", 250.0, 1)
                    .addItem("Mouse", 120.0, 1)
                    .addItem("Monitor", 1300.0, 2)
                    .addItem("Suporte para Monitor", 80.0, 2)
                    .build();
            System.out.println(order);
        } catch (OrderValidationException e) {
            System.err.println("Invalid order: " + e.getMessage());
            return;
        }

        try {
            PaymentService paymentService = new PaymentService(new PixGateway());
            paymentService.process(order);

            paymentService.switchGateway(new CreditCardGateway("4111111111111234"));
            paymentService.process(order);

            paymentService.switchGateway(new BoletoGateway());
            paymentService.process(order);
        } catch (PaymentException e) {
            System.err.println("[PAYMENT] ✗ " + e.getMessage());
        }

        try {
            NotificationChannelFactory emailFactory = new EmailChannelFactory();
            NotificationChannel email = emailFactory.create("joao@email.com");
            email.send(order);

            NotificationChannelFactory smsFactory = new SmsChannelFactory();
            NotificationChannel sms = smsFactory.create("+5561999990000");
            sms.send(order);
        } catch (Exception e) {
            System.err.println("[NOTIFICATION] ✗ " + e.getMessage());
        }
    }
}