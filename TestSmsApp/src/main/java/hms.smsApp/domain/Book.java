package hms.smsApp.domain;

/**
 * This class holds book data.
 * Created by dasuni on 7/24/15.
 */
public class Book {

    private int id;
    private String name;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(int id, String name, String author, String isbn, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
