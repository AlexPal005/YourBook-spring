package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.OrderDTO;
import service.yourbookspring.dto.OrderDetailsDTO;
import service.yourbookspring.entity.Book;
import service.yourbookspring.entity.Order;
import service.yourbookspring.entity.OrderDetails;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.BookRepository;
import service.yourbookspring.repository.OrderDetailsRepository;
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
    private final OrderDetailsService orderDetailsService;
    private final BookRepository bookRepository;
    private final JWT jwt;

    public Order create(OrderDTO orderDTO, String token) {
        if (token != null && token.startsWith("Bearer")) {
            token = token.substring(7);
        }
        JWTContent content = jwt.decode(token);
        User user = userRepository.findById(content.getUserId()).orElseThrow();


        Order order = Order.builder()
                .date(orderDTO.getDate())
                .totalSum(orderDTO.getTotalSum())
                .status(orderDTO.getStatus())
                .user(user)
                .build();
        Order resOrder = orderRepository.save(order);
        System.out.println(order);
        //create order details
        List<Long> booksId = orderDTO.getBooksId();
        Set<Book> books = new HashSet<>();
        for (Long bookId : booksId) {
            Book book = bookRepository.findById(bookId).orElseThrow();
            books.add(book);
        }
        orderDetailsService.create(new OrderDetailsDTO(
                books, order));

        return resOrder;
    }
}
