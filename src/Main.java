import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            UserManagement userManagement = new UserManagement();
            BooksManagement booksManagement = new BooksManagement();
            CheckoutManagement checkoutManagement = new CheckoutManagement(userManagement, booksManagement);


            while (true) {
                System.out.println("\n========= LIBRARY MANAGEMENT SYSTEM =========");
                System.out.println("1. User Operations");
                System.out.println("2. Book Operations");
                System.out.println("3. Checkout Operations");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = readInt(sc);

                switch (choice) {
                    case 1:
                        userMenu(sc, userManagement);
                        break;
                    case 2:
                        bookMenu(sc, booksManagement);
                        break;
                    case 3:
                        checkoutMenu(sc, checkoutManagement);
                        break;
                    case 4:
                        System.out.println("Exiting Library Management System...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
    }
    private static void userMenu(Scanner sc, UserManagement userManagement) {
        while (true) {
            System.out.println("\n--- USER MANAGEMENT ---");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Delete User");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    userManagement.addUser(new User(name, email, 0));
                    break;

                case 2:
                    userManagement.showAllUsers();
                    break;

                case 3:
                    System.out.print("Enter user email to delete: ");
                    String delEmail = sc.nextLine();
                    userManagement.deleteUser(delEmail);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void bookMenu(Scanner sc, BooksManagement booksManagement) {
        while (true) {
            System.out.println("\n--- BOOK MANAGEMENT ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter book name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    booksManagement.addBooks(new Book(bookId, bookName, author, true));
                    break;

                case 2:
                    booksManagement.showAllBooks();
                    break;

                case 3:
                    System.out.print("Enter book ID to delete: ");
                    String delBookId = sc.nextLine();
                    booksManagement.removeBooks(delBookId);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }


    private static void checkoutMenu(Scanner sc, CheckoutManagement checkoutManagement) {
        while (true) {
            System.out.println("\n--- CHECKOUT MANAGEMENT ---");
            System.out.println("1. Checkout Book");
            System.out.println("2. Return Book");
            System.out.println("3. View User Checkouts");
            System.out.println("4. View All Checkouts");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter user email: ");
                    String userEmail = sc.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter borrow date (DD-MM-YYYY): ");
                    String borrowDate = sc.nextLine();
                    System.out.print("Enter return date (DD-MM-YYYY): ");
                    String endDate = sc.nextLine();
                    System.out.print("Enter rent amount: ");
                    double rent = Double.parseDouble(sc.nextLine());
                    checkoutManagement.checkoutBook(userEmail, bookId, borrowDate, endDate, rent);
                    break;

                case 2:
                    System.out.print("Enter user email: ");
                    String retUser = sc.nextLine();
                    System.out.print("Enter book ID: ");
                    String retBookId = sc.nextLine();
                    checkoutManagement.returnBook(retUser, retBookId);
                    break;

                case 3:
                    System.out.print("Enter user email: ");
                    String viewEmail = sc.nextLine();
                    checkoutManagement.viewUserCheckouts(viewEmail);
                    break;

                case 4:
                    checkoutManagement.listAllCheckouts();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static int readInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1; // invalid input
        }
    }
}