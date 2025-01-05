package simple_library_book_reservation_system.gitHubCopilot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a User");
            System.out.println("3. Reserve a Book");
            System.out.println("4. Unreserve a Book");
            System.out.println("5. Display all Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    library.addUser(new User(name, userId));
                    break;
                case 3:
                    System.out.print("Enter book title to reserve: ");
                    String reserveTitle = scanner.nextLine();
                    System.out.print("Enter your user ID: ");
                    String reserveUserId = scanner.nextLine();
                    library.reserveBook(reserveTitle, reserveUserId);
                    break;
                case 4:
                    System.out.print("Enter book title to unreserve: ");
                    String unreserveTitle = scanner.nextLine();
                    System.out.print("Enter your user ID: ");
                    String unreserveUserId = scanner.nextLine();
                    library.unreserveBook(unreserveTitle, unreserveUserId);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the library system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
