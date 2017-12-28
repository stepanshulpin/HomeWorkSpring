package com.shulpin.server.service;

import com.shulpin.shared.Book;

import java.util.List;

public interface BookService {

    void saveBook(Book book);

    List<Book> findAllBooks(String sortedBy);

    void deleteBookById(Long id);

    Book findById(Long id);

    void updateBook(Book book);

}
