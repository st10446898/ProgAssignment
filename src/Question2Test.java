import static org.junit.jupiter.api.Assertions.*;

public class Question2Test {

    private Question2 library;

    @BeforeEach
    public void setUp() {
        library = new Question2();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        assertEquals(1, library.getAllBooks().size());
        assertTrue(library.getAllBooks().contains(book));
    }

    @Test
    public void testGetAllBooks() {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getAllBooks().size());
        assertTrue(library.getAllBooks().contains(book1));
        assertTrue(library.getAllBooks().contains(book2));
    }

    @Test
    public void testSearchBookByTitleFound() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        Book foundBook = library.searchBookByTitle("1984");
        assertNotNull(foundBook);
        assertEquals("1984", foundBook.getTitle());
        assertEquals("George Orwell", foundBook.getAuthor());
    }

    @Test
    public void testSearchBookByTitleNotFound() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        Book foundBook = library.searchBookByTitle("Nonexistent Title");
        assertNull(foundBook);
    }
}
