package hms.smsApp.repository;

import hms.smsApp.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class implements the BookRepository interface.
 * and overrides createBook and checkBook methods.
 * Created by dasuni on 7/24/15.
 */
public class BookRepositoryMysqlDBlmpl implements BookRepository {

    //SQL prepared statements for createBook and checkBook
    private static final String CREATE_BOOK = "INSERT INTO BOOKS (id, name, author, isbn, isAvailable) VALUES (?,?,?,?,?)";
    private static final String CHECK_BOOK = "SELECT * FROM BOOKS WHERE ID = ?";
    private static final String VIEW_ALL = "SELECT * FROM BOOKS";

    //creates connection to the database
    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement;

    /**
     *Creates a book
     * @param book
     */
    @Override
    public void createBook(Book book) {
        try {
            preparedStatement = connection.prepareStatement(CREATE_BOOK);

            //pass data to the prepared statement.
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setBoolean(5, book.isAvailable());

            //Execute the statement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *Search for a particular book by its id
     * @param id int, book id
     * @return book object
     */
    @Override
    public Book checkBook(int id) {

        Book book = null;
        try {
            preparedStatement = connection.prepareStatement(CHECK_BOOK);

            //pass data to the preparedStatement
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();//execute statement

            //get resultSet and save it as a book object.
            while (resultSet.next()) {
                book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getString("isbn"),
                        resultSet.getBoolean("isAvailable"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return book;
    }

    @Override
    public ResultSet viewAll() {

        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(VIEW_ALL);
            resultSet = preparedStatement.executeQuery();

            return resultSet;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return resultSet;

    }


}
