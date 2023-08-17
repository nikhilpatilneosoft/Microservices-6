package com.example.order.order.config;

import com.example.order.order.entities.Payment;
import com.example.order.order.util.paymentServiceUrl;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "thisIsFeign", //value = "payment_service",
                url = paymentServiceUrl.URL)
public interface MyFeignClient {

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestParam double amount, @RequestParam int orderId);

    @PutMapping
    @Headers("Content-Type: application/json")
    public ResponseEntity<Payment> updatePayment(@RequestParam double amount, @RequestParam int orderId);
}
