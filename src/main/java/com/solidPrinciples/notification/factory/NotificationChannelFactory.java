package com.solidPrinciples.notification.factory;

import com.solidPrinciples.notification.channel.NotificationChannel;

public abstract class NotificationChannelFactory {
    public abstract NotificationChannel create(String contact);
}