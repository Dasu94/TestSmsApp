package hms.smsApp.repository;

import hms.smsApp.domain.Book;

import java.sql.ResultSet;

/**
 * THis interface holds unimplement createBook and checkBook methods.
 * Created by dasuni on 7/27/15.
 */
public interface BookRepository {

    /**
     *
     * @param book
     */
    void createBook(Book book);

    /**
     *
     * @param id
     * @return
     */
    Book checkBook(int id);

    ResultSet viewAll();
}
