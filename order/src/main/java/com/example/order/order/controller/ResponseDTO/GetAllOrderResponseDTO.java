package com.example.order.order.controller.ResponseDTO;

import com.example.order.order.entities.Payment;
import com.example.order.order.entities.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetAllOrderResponseDTO {

    private Integer orderId;

    private double amount;

    private UserResponseDTO user;
}
