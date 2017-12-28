package com.shulpin.server.dao;

import com.shulpin.shared.Book;

import java.util.List;

public interface BookDao {

    void saveBook(Book book);

    List<Book> findAllBooks(String sortedBy);

    void deleteBookById(Long id);

    Book findById(Long id);

    void updateBook(Book book);

}
