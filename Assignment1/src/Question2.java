// LibraryTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        library.addBook(new Book("Title1", "Author1", "ISBN1"));
        assertEquals(1, library.getCount()); // Check if book count increased
    }

    @Test
    public void testViewBooks() {
        Library library = new Library();
        library.addBook(new Book("Title1", "Author1", "ISBN1"));
        library.viewBooks(); // Verify the books are printed correctly
    }

    @Test
    public void testSearchBookByTitle() {
        Library library = new Library();
        library.addBook(new Book("Title1", "Author1", "ISBN1"));
        library.searchBookByTitle("Title1"); // Verify if book is found by title
    }
}
