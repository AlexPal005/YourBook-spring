package service.yourbookspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.yourbookspring.entity.Book;
import service.yourbookspring.entity.Order;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private Set<Book> books;
    private Order order;
}
