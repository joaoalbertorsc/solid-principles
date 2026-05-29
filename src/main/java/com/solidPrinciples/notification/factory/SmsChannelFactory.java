package com.solidPrinciples.notification.factory;

import com.solidPrinciples.notification.channel.NotificationChannel;
import com.solidPrinciples.notification.channel.SmsChannel;

public class SmsChannelFactory extends NotificationChannelFactory {
    @Override
    public NotificationChannel create(String contact) {
        return new SmsChannel(contact);
    }
}