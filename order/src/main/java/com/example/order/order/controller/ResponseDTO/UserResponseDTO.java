package com.example.order.order.controller.ResponseDTO;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private Integer userId;

    private String name;

    private double balance;

}
