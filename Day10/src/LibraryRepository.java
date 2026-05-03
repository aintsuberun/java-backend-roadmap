import java.util.ArrayList;
public class LibraryRepository {

    private ArrayList<Book> books;

    LibraryRepository(){ books = new ArrayList<>();}

    void addBook(Book book) {
        books.add(book);
    }

    ArrayList<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    Book findById(int id){
        for (Book book: books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    boolean removeById(int id){
        return books.removeIf(book -> book.getId() == id);
    }

}
