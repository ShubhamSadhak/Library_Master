package com.springproj.library.service;


import com.springproj.library.dto.BookDTO;
import com.springproj.library.enitity.Book;
import com.springproj.library.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public Book postBook(BookDTO bookDTO){
        return saveOrUpdate(new Book(),bookDTO);
    }

    private Book saveOrUpdate(Book book, BookDTO bookDTO){
        book.setBookName(bookDTO.getBookName());
        book.setBookPrice(bookDTO.getBookPrice());
        book.setBookWriter(bookDTO.getBookWriter());
        book.setPublisher(bookDTO.getPublisher());

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public BookDTO getBookById(Long id){//getting DTO to the application
        Optional<Book> optionalBook =  bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get().getBookDto();
        }else {
            throw new EntityNotFoundException("Entity is not present with id " + id);
        }
    }

    public Book updateBook(BookDTO bookDTO,Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return saveOrUpdate(optionalBook.get(),bookDTO);
        }else{
            throw new EntityNotFoundException("Entity is not present with id " + id);
        }
    }

    public void deleteBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
             bookRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Entity is not present with id " + id);
        }
    }
}
