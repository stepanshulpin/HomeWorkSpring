package com.shulpin.server.dao;


import com.shulpin.shared.Book;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements BookDao {


    @Override
    public void saveBook(Book book) {
        persist(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findAllBooks(String sortedBy) {
        Criteria criteria = getSession().createCriteria(Book.class).addOrder(Order.asc(sortedBy));
        return (List<Book>) criteria.list();
    }

    @Override
    public void deleteBookById(Long id) {

        Query query = getSession().createSQLQuery("delete from Books where id = :id");
        query.setLong("id",id);
        query.executeUpdate();

    }

    @Override
    public Book findById(Long id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        return (Book) criteria.uniqueResult();
    }

    @Override
    public void updateBook(Book book) {
        getSession().update(book);
    }
}
