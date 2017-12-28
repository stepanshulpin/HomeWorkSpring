package com.shulpin.sort;

import com.shulpin.shared.Book;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Book> idComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o1.getId()-o2.getId());
        }
    };

    public static Comparator<Book> authorComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getNameAuthor().compareTo(o2.getNameAuthor());
        }
    };

    public static Comparator<Book> titleComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitleBook().compareTo(o2.getTitleBook());
        }
    };

    public static Comparator<Book> pagesComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o1.getPageCount()-o2.getPageCount());
        }
    };

    public static Comparator<Book> yearComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o1.getPublicationYear()-o2.getPublicationYear());
        }
    };

    public static Comparator<Book> addedDateComparator = new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {
            if((o1.getAddedDateYear()-o2.getAddedDateYear())!=0){
                return (int)(o1.getAddedDateYear()-o2.getAddedDateYear());
            }
            else{
                if((o1.getAddedDateMonth()-o2.getAddedDateMonth())!=0){
                    return (int)(o1.getAddedDateMonth()-o2.getAddedDateMonth());
                }
                else{
                    return (int)(o1.getAddedDateDay()-o2.getAddedDateDay());
                }
            }
        }
    };


}
