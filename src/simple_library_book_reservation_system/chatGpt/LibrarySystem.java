package simple_library_book_reservation_system.chatGpt;

import java.util.Scanner;

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding some books to the library
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Display books");
            System.out.println("2. Reserve a book");
            System.out.println("3. Unreserve a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the book number to reserve: ");
                    int reserveIndex = scanner.nextInt() - 1;
                    library.reserveBook(reserveIndex);
                    break;
                case 3:
                    System.out.print("Enter the book number to unreserve: ");
                    int unreserveIndex = scanner.nextInt() - 1;
                    library.unreserveBook(unreserveIndex);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
