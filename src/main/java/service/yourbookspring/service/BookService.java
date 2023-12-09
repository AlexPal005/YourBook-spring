package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.BookDTO;
import service.yourbookspring.entity.Book;
import service.yourbookspring.repository.BookRepository;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book create(BookDTO bookDTO) {
        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .description(bookDTO.getDescription())
                .price(bookDTO.getPrice())
                .picture(bookDTO.getPicture())
                .build();
        return bookRepository.save(book);
    }

}
