package com.shulpin.sort;

import com.shulpin.shared.Book;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sort {

    public static List<Book> exec(String sortedBy, List<Book> books){

        switch (sortedBy){
            case "id":
                Collections.sort(books,Comparators.idComparator);
                break;
            case "author":
                Collections.sort(books,Comparators.authorComparator);
                break;
            case "title":
                Collections.sort(books,Comparators.titleComparator);
                break;
            case "pages":
                Collections.sort(books,Comparators.pagesComparator);
                break;
            case "published":
                Collections.sort(books,Comparators.yearComparator);
                break;
            case "addDate":
                Collections.sort(books,Comparators.addedDateComparator);
                break;
        }
        return books;

    }

}
