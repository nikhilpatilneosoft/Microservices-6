package com.example.payment.Payment.services.ServiceImpl;

import com.example.payment.Payment.entities.Payment;
import com.example.payment.Payment.entities.PaymentStatus;
import com.example.payment.Payment.repositories.PaymentRespository;
import com.example.payment.Payment.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentRespository paymentRespository;

    @Override
    public Payment createPayment(double amount, Integer orderId) {

        return paymentRespository.save(Payment.builder().amount(amount).paymentStatus(PaymentStatus.SUCCESSFUL).orderId(orderId).build());
    }

    @Override
    public Payment updatePayment(double amount, Integer orderId) {
        Payment payment = paymentRespository.findByOrderId(orderId);
        payment.setAmount(amount);
        return paymentRespository.save(payment);
    }
}
