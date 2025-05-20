package LMS;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        LendingService lendingService = new LendingService(inventory);

        Book b1 = new Book("123", "book1", "Author 1", 1995);
        Book b2 = new Book("456", "book 2", "Author 2", 1994);
        inventory.addBook(b1);
        inventory.addBook(b2);

        Patron patron = new Patron("A","100");
        lendingService.checkoutBook("123", patron);
        lendingService.returnBook("123", patron);

        System.out.println("Currently borrowed books: " + inventory.getBorrowedBooks());
    }
}
