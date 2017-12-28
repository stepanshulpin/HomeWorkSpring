package com.shulpin.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.shulpin.shared.Book;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Library implements EntryPoint, DialogBoxOpener {

    private InputDialog dialogBox;
    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable booksFlexTable = new FlexTable();
    private List<Book> books = new ArrayList<>();
    private Button add = new Button("add");
    private BookService service = GWT.create(BookService.class);
    private String sortedBy="id";



    public void onModuleLoad() {
        String root = Defaults.getServiceRoot();
        root = root.replace("Library/", "");
        Defaults.setServiceRoot(root);
        createTable();
        mainPanel.add(booksFlexTable);
        mainPanel.add(add);

        RootPanel.get("library").add(mainPanel);

        add.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                openInputDialog();

            }
        });
    }

    private void openInputDialog() {
        dialogBox = new InputDialog();
        dialogBox.setOpener(this);
        dialogBox.center ();
        dialogBox.show();
    }

    class SortMethodCallBack implements MethodCallback<List<Book>> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            Window.alert("sort failed");
        }

        @Override
        public void onSuccess(Method method, List<Book> books) {
            drawTable(books);
        }
    }

    private void drawTable(List<Book> books) {
        mainPanel.remove(booksFlexTable);
        mainPanel.remove(add);
        booksFlexTable=new FlexTable();
        mainPanel.add(booksFlexTable);
        mainPanel.add(add);


        Button id = new Button("Id");
        id.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="id";
                service.getAllBooks(sortedBy, new SortMethodCallBack());
            }
        });
        Button author = new Button("Author");
        author.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="nameAuthor";
                service.getAllBooks(sortedBy, new SortMethodCallBack());
            }
        });
        Button title = new Button("Title");
        title.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="titleBook";
                service.getAllBooks(sortedBy, new SortMethodCallBack());
            }
        });
        Button pages = new Button("Pages");
        pages.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="pageCount";
                service.getAllBooks(sortedBy, new SortMethodCallBack());
            }
        });
        Button published = new Button("Published");
        published.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="publicationYear";
                service.getAllBooks(sortedBy, new SortMethodCallBack());
            }
        });
        Button addDate = new Button("Add date");





        booksFlexTable.setWidget(0, 0, id);
        booksFlexTable.setWidget(0, 1, author);
        booksFlexTable.setWidget(0, 2, title);
        booksFlexTable.setWidget(0, 3, pages);
        booksFlexTable.setWidget(0, 4, published);
        booksFlexTable.setWidget(0, 5, addDate);

        booksFlexTable.getRowFormatter().addStyleName(0,"header");
        booksFlexTable.addStyleName("list");

        for (Book book:books) {
            addRow(book);
        }

    }


    private void addRow(Book book){
        int row = booksFlexTable.getRowCount();
        booksFlexTable.setText(row,0, String.valueOf(book.getId()));
        booksFlexTable.setText(row,1, book.getNameAuthor());
        booksFlexTable.setText(row,2, book.getTitleBook());
        booksFlexTable.setText(row,3, String.valueOf(book.getPageCount()));
        booksFlexTable.setText(row,4, String.valueOf(book.getPublicationYear()));
        booksFlexTable.setText(row,5, String.valueOf(book.getAddedDateYear())+
            "-"+book.getAddedDateMonth()+"-"+book.getAddedDateDay());
        Button delete = new Button("x");
        delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                service.deleteBook(sortedBy,book.getId(), new MethodCallback<List<Book>>() {
                    @Override
                    public void onFailure(Method method, Throwable throwable) {
                        Window.alert("delete failed");
                    }

                    @Override
                    public void onSuccess(Method method, List<Book> books) {
                        drawTable(books);
                    }
                });
            }
        });
        booksFlexTable.setWidget(row, 7, delete);
    }

    private void createTable(){

        service.getAllBooks(sortedBy,new MethodCallback<List<Book>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("load failed");
            }

            @Override
            public void onSuccess(Method method, List<Book> books) {

                drawTable(books);
            }
        });
    }

    @Override
    public void dialogBoxCancelled() {
        service.addBook(sortedBy,new Book(dialogBox.getAuthor(), dialogBox.getTitle(), dialogBox.getPagesCount(), dialogBox.getPublishedYear(), new Date().getYear() + 1900, new Date().getMonth() + 1, new Date().getDate()), new MethodCallback<List<Book>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("add failed");
            }

            @Override
            public void onSuccess(Method method, List<Book> books) {
                drawTable(books);
            }
        });
    }
}
