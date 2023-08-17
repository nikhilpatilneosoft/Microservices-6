package com.example.order.order.controller;

import com.example.order.order.controller.RequestDTO.CreateUserRequestDTO;
import com.example.order.order.controller.ResponseDTO.*;
import com.example.order.order.entities.Order;
import com.example.order.order.entities.Payment;
import com.example.order.order.entities.User;
import com.example.order.order.services.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private ModelMapper mapper;

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO user)
    {
        User savedUser = orderService.createUser(user);
        CreateUserResponseDTO createUserResponseDTO = mapper.map(savedUser, CreateUserResponseDTO.class);
        return ResponseEntity.ok(createUserResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestParam double amount, @RequestParam Integer userId)
    {
        Order order = orderService.createOrder(amount, userId);
        CreateOrderResponseDTO createOrderResponseDTO = mapper.map(order, CreateOrderResponseDTO.class);
        return ResponseEntity.ok(createOrderResponseDTO);
    }

    @PutMapping()
    public ResponseEntity<UpdateOrderResponseDTO> updateOrder(@RequestParam int amount, @RequestParam Integer orderId)
    {
        Order order = orderService.updateOrder(amount, orderId);
        UserResponseDTO userResponseDTO = mapper.map(order.getUser(), UserResponseDTO.class);
        UpdateOrderResponseDTO updateOrderResponseDTO = mapper.map(order, UpdateOrderResponseDTO.class);
        updateOrderResponseDTO.setUser(userResponseDTO);
        return ResponseEntity.ok(updateOrderResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllOrderResponseDTO>> getAllOrders()
    {
        List<Order> orders = orderService.getAllOrders();
        List<GetAllOrderResponseDTO> getAllOrderResponseDTOS = orders.stream().map(x-> mapper.map(x, GetAllOrderResponseDTO.class)).collect(Collectors.toList());
        List <UserResponseDTO> userResponseDTOS = orders.stream().map(x-> mapper.map(x.getUser(), UserResponseDTO.class)).collect(Collectors.toList());

        for(int i = 0; i < getAllOrderResponseDTOS.size(); i++)
            getAllOrderResponseDTOS.get(i).setUser(userResponseDTOS.get(i));

        return ResponseEntity.ok(getAllOrderResponseDTOS);
    }
}
