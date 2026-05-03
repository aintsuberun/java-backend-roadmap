import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class LibraryService {
    private LibraryRepository repository;

    LibraryService(LibraryRepository repository){
        this.repository = repository;
    }

    ArrayList<Book> getAllBooks(){
        return repository.getAllBooks();
    }

    void addBook(Book book){
        repository.addBook(book);
    }

    boolean removeBookById(int id){
        return repository.removeById(id);
    }

    Optional<Book> findById(int id){
        Book book = repository.findById(id);
        if(book != null){
            return Optional.of(book);
        }
        return Optional.empty();
    }

    Optional<Book> findByTitle(String title){
        for(Book book : repository.getAllBooks()){
            if(book.getTitle().equalsIgnoreCase(title)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    ArrayList<Book> findByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : repository.getAllBooks()){
            if(book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }
        return result;
    }

    boolean sortByPrice(){
        ArrayList<Book> books = repository.getAllBooks();
        if(books.isEmpty()){
            return false;
        }
        books.sort(Comparator.comparingDouble(Book::getPrice));
        return true;
    }

    double averagePrice(){
        ArrayList<Book> books = repository.getAllBooks();
        if (books.isEmpty()) return 0.0;
        double average = 0.0;
        for(Book book : books){
            average = average + book.getPrice();
        }
        average = average/books.size();
        return average;
    }

    double expensiveBook(){
        ArrayList<Book> books = repository.getAllBooks();
        if (books.isEmpty()) return 0.0;
        double mostExpensive = books.get(0).getPrice();
        for(Book book : books){
            if(book.getPrice()>mostExpensive){
                mostExpensive = book.getPrice();
            }
        }
        return mostExpensive;
    }

    double cheapBook(){
        ArrayList<Book> books = repository.getAllBooks();
        if (books.isEmpty()) return 0.0;
        double mostCheap = books.get(0).getPrice();
        for (Book book : books){
            if(book.getPrice()<mostCheap){
                mostCheap = book.getPrice();
            }
        }
        return mostCheap;
    }

    int countBooks(){
        ArrayList<Book> books = repository.getAllBooks();
        return books.size();
    }

    ArrayList<Book> getExpensiveBooks(double price){
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : repository.getAllBooks()){
            if(book.getPrice()>price){
                result.add(book);
            }
        }
        return result;
    }
}
