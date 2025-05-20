package LMS;
import java.util.*;

public class Patron {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

    public Patron(String name, String id){
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    @Override
    public String toString(){
        return "Patron{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
