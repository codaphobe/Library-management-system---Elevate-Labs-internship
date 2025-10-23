import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Optional;

public class BooksManagement {

    private final ArrayList<Book> allBooks = new ArrayList<>();

    public boolean bookExists(String id){
        return allBooks.stream()
                .anyMatch(b -> b.getBookId().equalsIgnoreCase(id));
    }

    public boolean addBooks(Book book){
        if(bookExists(book.getBookId())){
            System.err.println("!!Book with this ID already exists!!");
            return false;
        }
        allBooks.add(book);
        System.out.println("Book is successfully added to the library");
        return true;
    }

    public Book getBookById(String bookId){
        Optional<Book> book = allBooks.stream()
                .filter(b -> b.getBookId().equalsIgnoreCase(bookId))
                .findFirst();
        if (book.isPresent()) {
            return book.get();
        } else {
            System.err.println("❌ No book found with this ID!");
            return null;
        }
    }

    public ArrayList<Book> getBookByName(String bookName){
        ArrayList<Book> resBooks = new ArrayList<>();
        for (Book b : allBooks){
            if(b.getBookName().toLowerCase().contains(bookName.toLowerCase())){
                resBooks.add(b);
            }
        }
        if(resBooks.isEmpty()){
            System.err.println("!!No books found by that name!!");
            return null;
        }
        return resBooks;
    }

    public void removeBooks(String bookId){
        boolean removed = allBooks.removeIf(b -> b.getBookId().equalsIgnoreCase(bookId));
        if(removed){
            System.out.println("Book removed successfully");
            return;
        }
        System.err.println("No book found by that id");
    }

    public void showAllBooks(){
        if(allBooks.isEmpty()){
            System.err.println("No books found in the records");
            return;
        }
        allBooks.forEach(System.out::println);
    }

    public void listAvailableBooks(){
        boolean found=false;
        ArrayList<Book> availableBooks = new ArrayList<>();
        System.out.println("----------------All available books----------------");
        for (Book b : allBooks){
            if(b.isAvailable()){
                availableBooks.add(b);
            }
        }
        if (availableBooks.isEmpty()){
            System.err.println("No books currently available");
            return;
        }
        availableBooks.forEach(System.out::println);
    }

    public void setBookAvailability(String bookId, boolean available){
        Book book = getBookById(bookId);
        if(book!=null){
            book.setAvailable(true);
        }
    }

    public ArrayList<Book> getBooksList() {
        return allBooks;
    }


}
