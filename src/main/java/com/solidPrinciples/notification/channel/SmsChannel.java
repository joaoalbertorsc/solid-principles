package com.solidPrinciples.notification.channel;

import com.solidPrinciples.notification.exceptions.NotificationException;
import com.solidPrinciples.order.Order;

import java.util.regex.Pattern;

public class SmsChannel implements NotificationChannel {
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+[1-9]\\d{6,14}$");

    private final String phone;

    public SmsChannel(String phone) {
        this.phone = validate(phone);
    }

    private String validate(String phone) {
        if (phone == null) throw new NotificationException("Phone number is required");

        String formattedPhone = phone.trim().replaceAll("[\\s-]", "");

        if (!formattedPhone.startsWith("+")) formattedPhone = "+" + formattedPhone;

        if (!PHONE_PATTERN.matcher(formattedPhone).matches())
            throw new NotificationException("Invalid phone number: " + phone);

        return formattedPhone;
    }

    @Override
    public void send(Order order) {
        System.out.println("[NOTIFICATION] Sending via SMS...");
        System.out.printf("[NOTIFICATION] ✓ Confirmation sent to %s%n", phone);
    }
}
