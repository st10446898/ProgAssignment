// Books
public class SectionB {
    private final String title;
    private final String author;
    private final String isbn;

    public SectionB(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }

    public String getTitle() {
        return title;
    }
}

// Library
public class Library {
    private final Book[] books = new Book[10];
    private int count = 0;

    public void addBook(Book book) {
        if (count < books.length) books[count++] = book;
        else System.out.println("Library is full.");
    }

    public void viewBooks() {
        for (int i = 0; i < count; i++) System.out.println(books[i]);
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// LibraryApp
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Add Book\n2. View Books\n3. Search Book by Title\n4. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                }
                case 2 -> library.viewBooks();
                case 3 -> {
                    System.out.print("Enter title to search: ");
                    library.searchBookByTitle(scanner.nextLine());
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
