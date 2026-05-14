package com.library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.model.Book;
import com.library.util.HibernateUtil;

public class BookDao {

    public void addBook(Book b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(b);
        transaction.commit();
        session.close();
        System.out.println("Book added");
    }

    public void deleteBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createMutationQuery("Delete from Book where bid = :bid").setParameter("bid", id).executeUpdate();
        transaction.commit();
        session.close();
        System.out.println("Book Deleted");
    }

    public void updateBook(Book b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(b);
        transaction.commit();
        session.close();
    }

    public Book getBookById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book b = session.find(Book.class, id);
        session.close();
        return b;
    }

    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createSelectionQuery("From Book", Book.class).getResultList();
        session.close();
        return books;
    }

    public List<Book> getBorrowedBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createSelectionQuery("From Book where borrowed = true", Book.class).getResultList();
        session.close();
        return books;
    }

    public List<Book> getAvailableBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createSelectionQuery("From Book where borrowed = false", Book.class).getResultList();
        session.close();
        return books;
    }
}
