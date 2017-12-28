package com.shulpin.shared;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;


@Entity
@Table(name="books")
@EnableTransactionManagement
public class Book implements Serializable {


    private static final long serialVersionUID = -5527566248002296042L;
    //id/автор/название/количество страниц/год издания/дата добавления в базу

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameAuthor")
    private String nameAuthor;
    @Column(name = "titleBook")
    private String titleBook;
    @Column(name = "pageCount")
    private Integer pageCount;
    @Column(name = "publicationYear")
    private Integer publicationYear;
    @Column(name = "addedDateYear")
    private Integer addedDateYear;
    @Column(name = "addedDateMonth")
    private Integer addedDateMonth;
    @Column(name = "addedDateDay")
    private Integer addedDateDay;

    public Book() {
    }

    public Book(String nameAuthor, String titleBook, Integer pageCount, Integer publicationYear, Integer addedDateYear, Integer addedDateMonth, Integer addedDateDay) {
        this.nameAuthor = nameAuthor;
        this.titleBook = titleBook;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.addedDateYear = addedDateYear;
        this.addedDateMonth = addedDateMonth;
        this.addedDateDay = addedDateDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getAddedDateYear() {
        return addedDateYear;
    }

    public void setAddedDateYear(Integer addedDateYear) {
        this.addedDateYear = addedDateYear;
    }

    public Integer getAddedDateMonth() {
        return addedDateMonth;
    }

    public void setAddedDateMonth(Integer addedDateMonth) {
        this.addedDateMonth = addedDateMonth;
    }

    public Integer getAddedDateDay() {
        return addedDateDay;
    }

    public void setAddedDateDay(Integer addedDateDay) {
        this.addedDateDay = addedDateDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (nameAuthor != null ? !nameAuthor.equals(book.nameAuthor) : book.nameAuthor != null) return false;
        if (titleBook != null ? !titleBook.equals(book.titleBook) : book.titleBook != null) return false;
        if (pageCount != null ? !pageCount.equals(book.pageCount) : book.pageCount != null) return false;
        if (publicationYear != null ? !publicationYear.equals(book.publicationYear) : book.publicationYear != null)
            return false;
        if (addedDateYear != null ? !addedDateYear.equals(book.addedDateYear) : book.addedDateYear != null)
            return false;
        if (addedDateMonth != null ? !addedDateMonth.equals(book.addedDateMonth) : book.addedDateMonth != null)
            return false;
        return addedDateDay != null ? addedDateDay.equals(book.addedDateDay) : book.addedDateDay == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        result = 31 * result + (titleBook != null ? titleBook.hashCode() : 0);
        result = 31 * result + (pageCount != null ? pageCount.hashCode() : 0);
        result = 31 * result + (publicationYear != null ? publicationYear.hashCode() : 0);
        result = 31 * result + (addedDateYear != null ? addedDateYear.hashCode() : 0);
        result = 31 * result + (addedDateMonth != null ? addedDateMonth.hashCode() : 0);
        result = 31 * result + (addedDateDay != null ? addedDateDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", titleBook='" + titleBook + '\'' +
                ", pageCount=" + pageCount +
                ", publicationYear=" + publicationYear +
                ", addedDateYear=" + addedDateYear +
                ", addedDateMonth=" + addedDateMonth +
                ", addedDateDay=" + addedDateDay +
                '}';
    }


}


