import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private ArrayList<Book> borrowedBooks;
    private double due;
    private ArrayList<Checkout> checkout;


    public User(String name, String email, double due) {
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.due = due;
        this.checkout = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public ArrayList<Checkout> getCheckout() {
        return checkout;
    }

    public void setCheckout(ArrayList<Checkout> checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", borrowedBooks=" + (borrowedBooks != null ? borrowedBooks.size() : 0) +
                ", due=" + due +
                ", checkout=" + (checkout != null ? checkout.size() : 0) +
                '}';
    }
}

