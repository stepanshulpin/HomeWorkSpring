package com.shulpin.server.service;


import com.shulpin.server.dao.BookDao;
import com.shulpin.shared.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;


    @Override
    public void saveBook(Book book) {
        dao.saveBook(book);
    }

    @Override
    public List<Book> findAllBooks(String sortedBy) {
        return dao.findAllBooks(sortedBy);
    }

    @Override
    public void deleteBookById(Long id) {
        dao.deleteBookById(id);
    }

    @Override
    public Book findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }
}
