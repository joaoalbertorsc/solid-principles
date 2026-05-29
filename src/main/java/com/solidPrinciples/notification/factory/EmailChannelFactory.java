package com.solidPrinciples.notification.factory;

import com.solidPrinciples.notification.channel.EmailChannel;
import com.solidPrinciples.notification.channel.NotificationChannel;

public class EmailChannelFactory extends NotificationChannelFactory {
    @Override
    public NotificationChannel create(String contact) {
        return new EmailChannel(contact);
    }
}