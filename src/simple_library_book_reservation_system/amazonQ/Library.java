package simple_library_book_reservation_system.amazonQ;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Reservation> reservations;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public boolean reserveBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member != null && book != null && book.isAvailable() && member.canBorrowBooks()) {
            book.setAvailable(false);
            member.addBook(book);
            reservations.add(new Reservation(book, member));
            return true;
        }
        return false;
    }

    public boolean returnBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member != null && book != null) {
            book.setAvailable(true);
            member.removeBook(book);
            removeReservation(book, member);
            return true;
        }
        return false;
    }

    private Member findMember(String memberId) {
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }

    private Book findBook(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    private void removeReservation(Book book, Member member) {
        reservations.removeIf(r -> r.getBook().equals(book) && r.getMember().equals(member));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}
