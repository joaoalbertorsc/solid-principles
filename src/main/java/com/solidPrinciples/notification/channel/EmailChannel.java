package com.solidPrinciples.notification.channel;

import com.solidPrinciples.notification.exceptions.NotificationException;
import com.solidPrinciples.order.Order;

import java.util.regex.Pattern;

public class EmailChannel implements NotificationChannel {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private final String email;

    public EmailChannel(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches())
            throw new NotificationException("Invalid email address: " + email);
        this.email = email;
    }

    @Override
    public void send(Order order) {
        System.out.println("[NOTIFICATION] Sending via EMAIL...");
        System.out.printf("[NOTIFICATION] ✓ Confirmation sent to %s%n", email);
    }
}
