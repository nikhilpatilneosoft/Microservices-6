package com.example.order.order.controller.ResponseDTO;

import com.example.order.order.entities.Payment;
import com.example.order.order.entities.User;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateOrderResponseDTO {

    private Integer orderId;

    private double amount;

    private User user;

    private Payment payment;
}
