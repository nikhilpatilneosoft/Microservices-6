package com.example.order.order.entities;

import lombok.*;

import java.beans.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Payment {

    private Integer id;

    private double amount;

    private String paymentStatus;
}
