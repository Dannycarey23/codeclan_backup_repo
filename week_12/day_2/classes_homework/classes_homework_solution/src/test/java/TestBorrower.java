import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBorrower {

    Book book;
    Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book = new Book("The Crow Road", "Ian Banks", "Mystery");
        borrower = new Borrower("John");
    }

    @Test
    public void testCountBooks() {
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void testCanAddBook() {
        borrower.addBook(book);
        assertEquals(1, borrower.bookCount());
    }
}
