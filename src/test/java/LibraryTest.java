import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void before(){
        library = new Library(2);
        book1 = new Book("Five Children and It", Genre.CHILDRENS);
        book2 = new Book("It", Genre.HORROR);
        book3 = new Book("Itch 'ikers guide to t' galaxe", Genre.SCIFI);
    }

    @Test
    public void libraryStartsEmpty(){
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddBookToLibrary(){
        library.addBook(book1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, library.getCapacity());
    }

    @Test
    public void cantAddBookIfAtCapacity(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(2, library.bookCount());
    }

    @Test
    public void canGetBookByIndex(){
        library.addBook(book1);
        library.addBook(book2);
        library.takeBook(1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void canGetBookObject(){
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(true, library.takeBookObject(book1));
        assertEquals(1, library.bookCount());
    }

    @Test
    public void getBookNumbersByGenreNil(){
        assertEquals(0, library.bookNumbersByGenre.size());
    }

    @Test
    public void addBookToHashMap(){
        Library library2 = new Library(100);
        library2.addBook(book1);
        library2.addBook(book2);
        library2.addBook(book3);
        Book book4 = new Book("The Tiger Who Came to Tea", Genre.CHILDRENS);
        Book book5 = new Book("Elmer", Genre.CHILDRENS);
        Book book6 = new Book("The Three Railway Engines", Genre.CHILDRENS);
        Book book7 = new Book("2001", Genre.SCIFI);
        Book book8 = new Book("Dune", Genre.SCIFI);
        library2.addBook(book4);
        library2.addBook(book5);
        library2.addBook(book6);
        library2.addBook(book7);
        library2.addBook(book8);
        assertEquals((Integer) 4, library2.bookNumbersByGenre.get(Genre.CHILDRENS));
        assertEquals((Integer) 1, library2.bookNumbersByGenre.get(Genre.HORROR));
        assertEquals((Integer) 3, library2.bookNumbersByGenre.get(Genre.SCIFI));
    }


}
