package service.yourbookspring.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String description;
    private Double price;
    private byte[] picture;
}
