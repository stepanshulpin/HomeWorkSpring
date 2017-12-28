package com.shulpin.client;

import com.shulpin.shared.Book;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("lib/books")
public interface BookService extends RestService {

    @GET
    @Path("/{sortedBy}")
    void getAllBooks(@PathParam("sortedBy") String sortedBy, MethodCallback<List<Book>> callback);


    @DELETE
    @Path("/delete/{id}/{sortedBy}")
    void deleteBook(@PathParam("sortedBy") String sortedBy, @PathParam("id") Long id, MethodCallback<List<Book>> callback);

    @POST
    @Path("/add/{sortedBy}")
    @Produces(MediaType.APPLICATION_JSON)
    void addBook(@PathParam("sortedBy") String sortedBy, Book book, MethodCallback<List<Book>> callback);

}
