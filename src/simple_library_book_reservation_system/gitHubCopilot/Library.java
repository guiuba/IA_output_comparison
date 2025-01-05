package simple_library_book_reservation_system.gitHubCopilot;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

public Library() {
    books = new ArrayList<>();
    users = new ArrayList<>();
}

// Methods to add books and users
public void addBook(Book book) {
    books.add(book);
    System.out.println("Book added to the library.");
}

public void addUser(User user) {
    users.add(user);
    System.out.println("User added to the library.");
}

// Method to reserve a book
public void reserveBook(String title, String userId) {
    for (Book book : books) {
        if (book.getTitle().equals(title)) {
            book.reserveBook();
            return;
        }
    }
    System.out.println("Book not found.");
}

// Method to unreserve a book
public void unreserveBook(String title, String userId) {
    for (Book book : books) {
        if (book.getTitle().equals(title)) {
            book.unreserveBook();
            return;
        }
    }
    System.out.println("Book not found.");
}

// Method to display all books
public void displayBooks() {
    for (Book book : books) {
        System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Reserved: " + book.isReserved());
    }
}
}

