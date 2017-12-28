package com.shulpin.server.controller;




import com.shulpin.server.service.BookService;
import com.shulpin.shared.Book;
import com.shulpin.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@Controller
public class LibraryService {


    @Autowired
    BookService bookService;

    @GetMapping("/books/{sortedBy}")
    @Transactional
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable("sortedBy") String sortedBy){

        return new ResponseEntity<List<Book>>(bookService.findAllBooks(sortedBy), HttpStatus.OK);

    }


    @DeleteMapping("books/delete/{id}/{sortedBy}")
    @Transactional
    public ResponseEntity<List<Book>> delete(@PathVariable("sortedBy") String sortedBy, @PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<List<Book>>(bookService.findAllBooks(sortedBy), HttpStatus.OK);
    }

    @PostMapping("/books/add/{sortedBy}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Book>> addBook(@PathVariable("sortedBy") String sortedBy, @RequestBody Book book){
        bookService.saveBook(book);
        return new ResponseEntity<List<Book>>(bookService.findAllBooks(sortedBy), HttpStatus.OK);
    }



}
