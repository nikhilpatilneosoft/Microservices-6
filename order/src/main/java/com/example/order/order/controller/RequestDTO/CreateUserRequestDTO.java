package com.example.order.order.controller.RequestDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserRequestDTO {
    private String name;
    private double balance;
}
