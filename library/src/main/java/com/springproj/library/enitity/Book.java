package com.springproj.library.enitity;

import com.springproj.library.dto.BookDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String bookName;

    private Integer bookPrice;

    private String bookWriter;

    private String publisher;


    public BookDTO getBookDto(){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(Id);
        bookDTO.setBookName(bookName);
        bookDTO.setBookWriter(bookWriter);
        bookDTO.setBookPrice(bookPrice);
        bookDTO.setPublisher(publisher);

        return bookDTO;
    }
}
