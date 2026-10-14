package com.springproj.library.repository;

import com.springproj.library.enitity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
