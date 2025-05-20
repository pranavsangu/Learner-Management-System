package LMS;
import java.util.*;
class LendingService {
    private final Inventory inventory;

    public LendingService(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean checkoutBook(String isbn, Patron patron) {
        Book book = inventory.searchByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            inventory.markBorrowed(isbn);
            patron.borrowBook(book);
            Log.logger.info(patron.getName() + " checked out: " + book);
            return true;
        } else {
            Log.logger.warning("Book unavailable or not found: " + isbn);
            return false;
        }
    }

    public boolean returnBook(String isbn, Patron patron) {
        Book book = inventory.searchByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            inventory.markReturned(isbn);
            patron.returnBook(book);
            Log.logger.info("Returned: " + book);
            return true;
        } else {
            Log.logger.warning("Book already returned or not found: " + isbn);
            return false;
        }
    }
}