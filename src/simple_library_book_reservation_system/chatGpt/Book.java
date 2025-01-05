package simple_library_book_reservation_system.chatGpt;

// Book class encapsulates details of a book
class Book {
    private String title;
    private String author;
    private boolean isReserved;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isReserved = false; // Default: not reserved
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isReserved() {
        return isReserved;
    }

    // Setters
    public void reserveBook() {
        if (!isReserved) {
            this.isReserved = true;
        }
    }

    public void unreserveBook() {
        if (isReserved) {
            this.isReserved = false;
        }
    }
}