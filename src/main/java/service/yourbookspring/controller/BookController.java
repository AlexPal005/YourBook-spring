package service.yourbookspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.yourbookspring.dto.BookDTO;
import service.yourbookspring.entity.Book;
import service.yourbookspring.service.BookService;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.create(bookDTO), HttpStatus.OK);
    }
}
