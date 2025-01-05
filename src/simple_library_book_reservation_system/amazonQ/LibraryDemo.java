package simple_library_book_reservation_system.amazonQ;

import java.util.List;
import java.util.Scanner;

public class LibraryDemo {
    private static Library library;
    private static Scanner scanner;

    public static void main(String[] args) {
        initialize();
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();
            running = handleMenuChoice(choice);
        }

        scanner.close();
    }

    private static void initialize() {
        library = new Library();
        scanner = new Scanner(System.in);
        // Add some sample data
        addSampleData();
    }

    private static void addSampleData() {
        // Add some initial books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456"));
        library.addBook(new Book("1984", "George Orwell", "789012"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "345678"));

        // Add some initial members
        library.registerMember(new Member("M001", "John Doe"));
        library.registerMember(new Member("M002", "Jane Smith"));
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add New Book");
        System.out.println("2. Register New Member");
        System.out.println("3. Reserve a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Display All Members");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addNewBook();
                break;
            case 2:
                registerNewMember();
                break;
            case 3:
                reserveBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                displayAllBooks();
                break;
            case 6:
                displayAllMembers();
                break;
            case 0:
                System.out.println("Thank you for using the Library Management System!");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    private static void addNewBook() {
        System.out.println("\n=== Add New Book ===");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book newBook = new Book(title, author, isbn);
        library.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private static void registerNewMember() {
        System.out.println("\n=== Register New Member ===");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        Member newMember = new Member(memberId, name);
        library.registerMember(newMember);
        System.out.println("Member registered successfully!");
    }

    private static void reserveBook() {
        System.out.println("\n=== Reserve a Book ===");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        boolean success = library.reserveBook(memberId, isbn);
        if (success) {
            System.out.println("Book reserved successfully!");
        } else {
            System.out.println("Failed to reserve book. Please check member ID and ISBN, or book availability.");
        }
    }

    private static void returnBook() {
        System.out.println("\n=== Return a Book ===");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        boolean success = library.returnBook(memberId, isbn);
        if (success) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book. Please check member ID and ISBN.");
        }
    }

    private static void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        List<Book> books = library.getAllBooks(); // You'll need to add this method to Library class
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.printf("Title: %-30s Author: %-20s ISBN: %-10s Status: %s%n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.isAvailable() ? "Available" : "Reserved");
        }
    }

    private static void displayAllMembers() {
        System.out.println("\n=== All Members ===");
        List<Member> members = library.getAllMembers(); // You'll need to add this method to Library class
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member member : members) {
            System.out.printf("ID: %-10s Name: %-20s Books Borrowed: %d%n",
                    member.getMemberId(),
                    member.getName(),
                    member.getBorrowedBooks().size());
        }
    }
}
