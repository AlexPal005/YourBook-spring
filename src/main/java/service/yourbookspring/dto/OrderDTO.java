package service.yourbookspring.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import service.yourbookspring.entity.Book;
import service.yourbookspring.entity.User;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Date date;
    private Double totalSum;
    private String status;
    private User user;
    private List<Long> booksId;
    private Set<Book> books;
}
