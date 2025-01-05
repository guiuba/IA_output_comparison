package simple_library_book_reservation_system.amazonQ;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private static final int MAX_BOOKS = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); // Return a copy to maintain encapsulation
    }

    protected boolean canBorrowBooks() {
        return borrowedBooks.size() < MAX_BOOKS;
    }

    protected void addBook(Book book) {
        borrowedBooks.add(book);
    }

    protected void removeBook(Book book) {
        borrowedBooks.remove(book);
    }
}
