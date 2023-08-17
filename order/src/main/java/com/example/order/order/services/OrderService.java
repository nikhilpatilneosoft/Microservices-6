package com.example.order.order.services;

import com.example.order.order.controller.RequestDTO.CreateUserRequestDTO;
import com.example.order.order.entities.Order;
import com.example.order.order.entities.Payment;
import com.example.order.order.entities.User;

import java.util.List;

public interface OrderService {

    User createUser(CreateUserRequestDTO user);

    Order createOrder(double amount, Integer userId);

    Order updateOrder(int amount, Integer orderId);

    List<Order> getAllOrders();
}
