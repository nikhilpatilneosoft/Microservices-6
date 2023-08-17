package com.example.order.order.services.serviceImpl;

import com.example.order.order.config.MyFeignClient;
import com.example.order.order.controller.RequestDTO.CreateUserRequestDTO;
import com.example.order.order.entities.Order;
import com.example.order.order.entities.Payment;
import com.example.order.order.entities.User;
import com.example.order.order.repositories.OrderRepository;
import com.example.order.order.repositories.UserRepository;
import com.example.order.order.services.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private ModelMapper mapper;
    private RestTemplate restTemplate;
    private MyFeignClient myFeignClient;

    @Override
    public User createUser(CreateUserRequestDTO user) {
        return userRepository.save(mapper.map(user, User.class));
    }

//    @Override
//    public Order createOrder(double amount, int userId) {
//        User user = userRepository.findById(userId).get();
//        if(user.getBalance() >= amount)
//        {
//            Order order = Order.builder().amount(amount).build();
//            user.setBalance(user.getBalance() - amount);
//            order.setUser(user);
//            Payment payment = restTemplate.postForEntity("http://localhost:8182/payments?amount="+amount, amount, Payment.class).getBody();
//            order.setPayment(payment);
//            return orderRepository.save(order);
//        }
//        else
//            throw new RuntimeException("not sufficient balance");
//    }

    public Order createOrder(double amount, Integer userId) {
        User user = userRepository.findById(userId).get();
        if(user.getBalance() >= amount)
        {
            Order order = Order.builder().amount(amount).build();
            user.setBalance(user.getBalance() - amount);
            order.setUser(user);
            Order savedOrder = orderRepository.save(order);
            Payment payment = createPayment(amount, savedOrder.getOrderId()).getBody();
            savedOrder.setPaymentId(payment.getId());
            Order updatedOrder = updateOrderForId(savedOrder);
            orderRepository.save(updatedOrder);
            updatedOrder.setPayment(payment);
            return updatedOrder;
        }
        else
            throw new RuntimeException("not sufficient balance");
    }

    private Order updateOrderForId(Order order)
    {
        Order retrivedOrder = orderRepository.findById(order.getOrderId()).get();
        retrivedOrder.setPaymentId(order.getPaymentId());
        return retrivedOrder;
    }

    public ResponseEntity<Payment> createPayment(@RequestParam double amount, @RequestParam Integer orderId)
    {
        return myFeignClient.createPayment(amount, orderId);
    }

    @Override
    public Order updateOrder(int amount, Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setAmount(amount);
        Order savedOrder = orderRepository.save(order);
        Payment payment = updatePayment(amount, orderId).getBody();
        savedOrder.setPayment(payment);
        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public ResponseEntity<Payment> updatePayment(@RequestParam double amount, @RequestParam Integer orderId)
    {
        return myFeignClient.updatePayment(amount, orderId);
    }
}