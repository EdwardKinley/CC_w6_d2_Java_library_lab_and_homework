import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    public HashMap<Genre, Integer> bookNumbersByGenre;
    private int capacity;

    public Library(int capacity){
        this.books = new ArrayList<>();
        this.bookNumbersByGenre = new HashMap<>();
        this.capacity = capacity;
    }

    public int bookCount() {
        return this.books.size();
    }

    public void addBookToHashMap(Book book) {
        this.bookNumbersByGenre.merge(book.genre,1, Integer::sum);
    }

    public void addBook(Book book) {
        if(capacity > books.size())
        {this.books.add(book);
        this.addBookToHashMap(book);}
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Book takeBook(int index) {
        return this.books.remove(index);
    }

    public Boolean takeBookObject(Book book) {
        return this.books.remove(book);
    }


}
