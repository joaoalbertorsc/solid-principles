package com.solidPrinciples.notification.channel;

import com.solidPrinciples.order.Order;

public interface NotificationChannel {
    void send(Order order);
}