package simple_library_book_reservation_system.amazonQ;

public class Reservation {
    private Book book;
    private Member member;
    private long reservationDate;

    public Reservation(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.reservationDate = System.currentTimeMillis();
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public long getReservationDate() {
        return reservationDate;
    }
}
