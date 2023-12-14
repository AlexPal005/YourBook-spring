package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.OrderDTO;
import service.yourbookspring.entity.Book;
import service.yourbookspring.entity.Order;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.BookRepository;
import service.yourbookspring.repository.OrderRepository;
import service.yourbookspring.repository.UserRepository;
import service.yourbookspring.utilities.JWT;
import service.yourbookspring.utilities.JWTContent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final JWT jwt;

    public Order create(OrderDTO orderDTO, String token) {
        if (token != null && token.startsWith("Bearer")) {
            token = token.substring(7);
        }
        JWTContent content = jwt.decode(token);
        User user = userRepository.findById(content.getUserId()).orElseThrow();

        List<Long> booksId = orderDTO.getBooksId();
        Set<Book> books = new HashSet<>();
        for (Long id : booksId) {
            Book book = bookRepository.findById(id).orElseThrow();
            books.add(book);
        }

        Order order = Order.builder()
                .date(orderDTO.getDate())
                .totalSum(orderDTO.getTotalSum())
                .status(orderDTO.getStatus())
                .user(user)
                .books(books)
                .build();
        return orderRepository.save(order);
    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
