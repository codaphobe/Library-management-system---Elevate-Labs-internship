import java.util.ArrayList;
import java.util.UUID;

public class CheckoutManagement {

    private final ArrayList<Checkout> checkoutList = new ArrayList<>();
    private final UserManagement userManagement;
    private final BooksManagement booksManagement;

    public CheckoutManagement(UserManagement userManagement, BooksManagement booksManagement) {
        this.userManagement = userManagement;
        this.booksManagement = booksManagement;
    }

    public void checkoutBook(String userEmail, String bookId, String borrowedDate, String endDate, double rent) {
        User user = userManagement.getUserByEmail(userEmail);
        Book book = booksManagement.getBookById(bookId);

        if (user == null || book == null) {
            System.err.println("❌ Invalid user or book details!");
            return;
        }

        if (!book.isAvailable()) {
            System.err.println("❌ Book is currently unavailable!");
            return;
        }

        // Create a new checkout record
        Checkout checkout = new Checkout(user, UUID.randomUUID().toString(), book.getBookName(),
                borrowedDate, endDate, rent);

        // Update user record
        user.getBorrowedBooks().add(book);
        user.getCheckout().add(checkout);
        user.setDue(user.getDue() + rent);

        // Update book availability
        book.setAvailable(false);

        // Add to global checkout list
        checkoutList.add(checkout);

        System.out.println("✅ Book checked out successfully!");
    }

    public void returnBook(String userEmail, String bookId) {
        User user = userManagement.getUserByEmail(userEmail);
        Book book = booksManagement.getBookById(bookId);

        if (user == null || book == null) {
            System.err.println("❌ Invalid user or book details!");
            return;
        }

        // Check if the user has borrowed this book
        boolean hasBook = user.getBorrowedBooks().removeIf(b -> b.getBookId().equalsIgnoreCase(bookId));
        if (!hasBook) {
            System.err.println("❌ This user has not borrowed the book!");
            return;
        }

        // Update availability
        book.setAvailable(true);

        System.out.println("✅ Book returned successfully!");
    }

    public void viewUserCheckouts(String userEmail) {
        User user = userManagement.getUserByEmail(userEmail);
        System.out.println(user);
        if (user == null) return;

        ArrayList<Checkout> userCheckouts = user.getCheckout();
        if (userCheckouts.isEmpty()) {
            System.out.println("⚠️ No checkouts found for this user.");
            return;
        }

        System.out.println("\n--- Checkout History for " + user.getName() + "---");
        userCheckouts.forEach(System.out::println);
    }

    public void listAllCheckouts() {
        if (checkoutList.isEmpty()) {
            System.out.println("⚠️ No checkout records found.");
            return;
        }

        System.out.println("\n--- All Checkout Records ---");
        checkoutList.forEach(System.out::println);
    }

    public void calculateDue(String userEmail) {
        User user = userManagement.getUserByEmail(userEmail);
        if (user == null) return;

        System.out.println("💰 Total Due for " + user.getName() + ": Rs. " + user.getDue());
    }

    public ArrayList<Checkout> getCheckoutList() {
        return checkoutList;
    }
}

