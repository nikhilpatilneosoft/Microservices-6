package com.example.order.order.controller.ResponseDTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserResponseDTO {

    private Integer userId;
    private String name;
    private double balance;
}
