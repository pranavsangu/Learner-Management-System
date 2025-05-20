package LMS;

import java.util.*;


public class Book {
    private final String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable = true;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void updateDetails(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
    }

    @Override
    public String toString() {
        return String.format("%s - %s by %s (%d)", isbn, title, author, publicationYear);
    }
}



