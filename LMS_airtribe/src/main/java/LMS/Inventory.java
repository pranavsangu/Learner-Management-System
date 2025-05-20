package LMS;
import java.util.*;


// Book Inventory
class Inventory {
    private final Map<String, Book> books = new HashMap<>();
    private final Set<String> borrowedBooks = new HashSet<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        Log.logger.info("Added: " + book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
        borrowedBooks.remove(isbn);
        Log.logger.info("Removed book with ISBN: " + isbn);
    }

    public void updateBook(String isbn, String title, String author, int year) {
        Book book = books.get(isbn);
        if (book != null) {
            book.updateDetails(title, author, year);
            Log.logger.info("Updated: " + book);
        }
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public void markBorrowed(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void markReturned(String isbn) {
        borrowedBooks.remove(isbn);
    }

    public boolean isBorrowed(String isbn) {
        return borrowedBooks.contains(isbn);
    }

    public Set<String> getBorrowedBooks() {
        return Collections.unmodifiableSet(borrowedBooks);
    }
}