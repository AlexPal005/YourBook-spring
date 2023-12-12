package service.yourbookspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.yourbookspring.dto.OrderDTO;
import service.yourbookspring.entity.Order;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.OrderRepository;
import service.yourbookspring.repository.UserRepository;
import service.yourbookspring.service.OrderService;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class OrderController {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        List<Order> orders = orderRepository.findOrderByUserId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
