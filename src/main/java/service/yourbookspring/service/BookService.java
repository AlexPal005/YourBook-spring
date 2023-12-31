package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.BookDTO;
import service.yourbookspring.entity.Book;
import service.yourbookspring.repository.BookRepository;

import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book create(BookDTO bookDTO) {
        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .description(bookDTO.getDescription())
                .price(bookDTO.getPrice())
                .picture(Base64.getDecoder().decode(bookDTO.getPicture().getBytes()))
                .build();
        return bookRepository.save(book);
    }

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
