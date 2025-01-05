package simple_library_book_reservation_system.gitHubCopilot;

public class Book {
    private String title;
    private String author;
    private boolean isReserved;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveBook() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void unreserveBook() {
        if (isReserved) {
            isReserved = false;
            System.out.println("Book unreserved successfully.");
        } else {
            System.out.println("Book is not reserved.");
        }
    }
}
