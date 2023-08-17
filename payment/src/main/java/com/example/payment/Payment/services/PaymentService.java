package com.example.payment.Payment.services;

import com.example.payment.Payment.entities.Payment;

public interface PaymentService {

    Payment createPayment(double amount, Integer orderId);

    Payment updatePayment(double amount, Integer orderId);
}
