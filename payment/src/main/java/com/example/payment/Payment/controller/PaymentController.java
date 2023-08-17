package com.example.payment.Payment.controller;

import com.example.payment.Payment.entities.Payment;
import com.example.payment.Payment.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestParam double amount, @RequestParam Integer orderId)
    {
        return ResponseEntity.ok(paymentService.createPayment(amount, orderId));
    }

    @PutMapping
    public ResponseEntity<Payment> updatePayment(@RequestParam double amount, @RequestParam Integer orderId)
    {
        return ResponseEntity.ok(paymentService.updatePayment(amount, orderId));
    }
}
