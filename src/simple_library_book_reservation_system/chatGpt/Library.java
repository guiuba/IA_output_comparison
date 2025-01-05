package simple_library_book_reservation_system.chatGpt;

import java.util.ArrayList;

// Library class manages books
class Library {
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    // Display all books in the library
    public void displayBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() +
                    (book.isReserved() ? " [Reserved]" : " [Available]"));
        }
    }

    // Reserve a book
    public void reserveBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            if (!book.isReserved()) {
                book.reserveBook();
                System.out.println("Book reserved successfully.");
            } else {
                System.out.println("Book is already reserved.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    // Unreserve a book
    public void unreserveBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            if (book.isReserved()) {
                book.unreserveBook();
                System.out.println("Book unreserved successfully.");
            } else {
                System.out.println("Book is not reserved.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
    }
}
