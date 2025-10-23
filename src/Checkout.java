public class Checkout {

    private User user;
    private String checkoutId;
    private String borrowedBook;
    private String borrowedDate;
    private String endDate;
    private double rent;

    public Checkout(User user, String checkoutId, String borrowedBook, String borrowedDate, String endDate, double rent) {
        this.user = user;
        this.checkoutId = checkoutId;
        this.borrowedBook = borrowedBook;
        this.borrowedDate = borrowedDate;
        this.endDate = endDate;
        this.rent = rent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "user=" + (user != null ? user.getEmail() : "N/A")  +
                ", checkoutId='" + checkoutId + '\'' +
                ", borrowedBook='" + borrowedBook + '\'' +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rent=" + rent +
                '}';
    }
}
