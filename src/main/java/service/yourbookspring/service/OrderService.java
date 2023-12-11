package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.OrderDTO;
import service.yourbookspring.entity.Order;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.OrderRepository;
import service.yourbookspring.repository.UserRepository;
import service.yourbookspring.utilities.JWT;
import service.yourbookspring.utilities.JWTContent;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public Order create(OrderDTO orderDTO) {
        Long userId = orderDTO.getUserId();
        User user = userRepository.findById(userId).orElseThrow();

        Order order = Order.builder()
                .date(orderDTO.getDate())
                .totalSum(orderDTO.getTotalSum())
                .status(orderDTO.getStatus())
                .user(user)
                .build();
        return orderRepository.save(order);
    }
}
