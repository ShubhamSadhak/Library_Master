package com.springproj.library.service;

import com.springproj.library.dto.BookDTO;
import com.springproj.library.enitity.Book;

import java.util.List;

public interface BookService {
    public Book postBook(BookDTO bookDTO);
    public List<Book> getAllBooks();
    public BookDTO getBookById(Long id);
    public Book updateBook(BookDTO bookDTO,Long id);
    public void deleteBook(Long id);
}
