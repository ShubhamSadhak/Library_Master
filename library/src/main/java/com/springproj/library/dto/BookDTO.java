package com.springproj.library.dto;


import lombok.*;

@Getter
@Setter
@Data
public class BookDTO {

    private Long Id;

    private String bookName;

    private Integer bookPrice;

    private String bookWriter;

    private String publisher;
}
