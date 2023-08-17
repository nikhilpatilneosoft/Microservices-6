package com.example.payment.Payment.repositories;

import com.example.payment.Payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRespository extends JpaRepository<Payment, Integer> {

    public Payment findByOrderId(Integer orderId);
}
