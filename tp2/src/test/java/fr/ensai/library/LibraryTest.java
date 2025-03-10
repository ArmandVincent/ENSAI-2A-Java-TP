package fr.ensai.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void findActiveLoanForItem_ItemIsLoaned() {
        // GIVEN
        Library library = new Library("Test Library");
        Book book1 = new Book("978-0321765723", "Book 1", new Author("Author 1", 3, ""), 2008, 320);
        Student student = new Student("John Doe", 20, 2, true);
        Loan loan1 = new Loan(book1, student, new Date());
        library.getActiveLoans().add(loan1);

        // WHEN
        Loan foundLoan = library.findActiveLoanForItem(book1);

        // THEN
        assertEquals(loan1, foundLoan);
    }

    @Test
    void findActiveLoanForItem_ItemIsNotLoaned() {
        // GIVEN
        Library library = new Library("Test Library");
        Book book1 = new Book("978-0321765723", "Book 1", new Author("Author 1", 3, ""), 2008, 320);
        Book book2 = new Book("978-0596009205", "Book 2", new Author("Author 2", 3, ""), 2005, 450);
        Student student = new Student("John Doe", 20, 2, true);
        Loan loan1 = new Loan(book1, student, new Date());
        library.getActiveLoans().add(loan1);

        // WHEN
        Loan foundLoan = library.findActiveLoanForItem(book2);

        // THEN
        assertNull(foundLoan);
    }

    @Test 
    public void getBooksByAuthor_test(){
        Library library = new Library("Test Library");
        Book book1 = new Book("978-0321765723", "Book 1", new Author("Author 1", 3, ""), 2008, 320);
        Book book2 = new Book("978-0596009205", "Book 2", new Author("Author 2", 3, ""), 2005, 450);
        Book book3 = new Book("978-0596065405", "Book 3", new Author("Author 2", 3, ""), 2005, 450);
        Author auteur1 = new Author("Author 1", 3, "");
        Author auteur2 = new Author("Author 2", 3, "");
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);

        ArrayList<Book> liste1 = new ArrayList<Book>();
        liste1.add(book1);

        ArrayList<Book> liste2 = new ArrayList<Book>();
        liste2.add(book2);
        liste2.add(book3);

        //WHEN

        ArrayList<Book> L1_a_verif = library.getBooksByAuthor(auteur1);

        //THEN
        assertEquals(L1_a_verif, liste1);


        //WHEN

        ArrayList<Book> L2_a_verif = library.getBooksByAuthor(auteur2);
        //THEN
        assertEquals(L2_a_verif, liste2);    
    }
}