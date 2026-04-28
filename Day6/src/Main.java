import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Library lib = new Library();
        Book book1 = new Book("It","Stephen King");
        Book book2 = new Book("Crime and punishment", "Fyodor Dostoevsky", 560, 399.90);
        Book book3 = new Book("The Fate Of a man", "Mikhail Sholokhov");
        Book book4 = new Book ("War and peace", "Leo Tolstoy", 780, 599.90);
        Book book5 = new Book ("Martin Eden", "Jack London", 320, 289.90);
        Book book6 = new Book ("Rich Dad Poor Dad", "Robert Kiyosaki", 336, 1199.99);
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        lib.addBook(book6);
        lib.showAllBooks();
        lib.countBooks();
        lib.findBookByTitle("It");
        lib.removeBookById(3);
        lib.showAllBooks();
        lib.showExpenciveBooks(570);
        //book1.showInfo();
        //book2.showInfo();
        //book3.showInfo();
        //book4.showInfo();
        //book5.showInfo();
        //Book.showTotalBooks();
        //book2.discount(22.5);
        //book2.showInfo();
    }
}

class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    static private int totalBooks;
    private int id;
    static private int nextId = 1;

    Book(String title, String author){
        this(title,author,0, 0);
    }

    Book(String title, String author, int pages, double price){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        totalBooks++;
        this.id=nextId;
        nextId++;

    }

    void showInfo(){
        System.out.println("Title: " + title + "\nAuthor: " + author
                + "\nPages: " + pages + "\nPrice: " + price);
        System.out.println("Book " + title +" id: " + id);
    }
    static void showTotalBooks(){
        System.out.println("Total books created: " + totalBooks);
    }

    void discount(double percent){
        if (percent > 0 && percent < 80){
            price = price - (price/100)*percent;
            System.out.println("Total price with " + percent + "% discont is: " + price);
        }
    }

    public String getTitle(){
        return title;
    }

    public int getId(){
        return id;
    }

    public double getPrice() {
        return price;
    }
}

class Library{
    private ArrayList<Book> books;

    Library(){
        books = new ArrayList<>();
    }

    void addBook(Book book){
        books.add(book);
    }

    void showAllBooks(){
        for (Book book : books){
            book.showInfo();
        }
    }

    void countBooks(){
        System.out.println("Total books in library: " + books.size());
    }

    void findBookByTitle(String title){
        for (Book book: books){
            if (book.getTitle().equals(title)){
                System.out.println("The book <<" + title +">> found.");
                return;
            }
        }
        System.out.println("The book <<" + title + ">> not found.");
    }

    void removeBookById(int id){
        for (Book book: books){
            if(book.getId() == id) {
                books.remove(book);
                System.out.println("The book with id " + id + " has been removed.");
                return;
            }
        }
        System.out.println("The book with id " + id + "wasn't found.");
    }

    void showExpenciveBooks(double price){
        System.out.println("Books price higher than " + price);
        for (Book book: books){
            if (book.getPrice()>price){
                book.showInfo();
            }
        }
    }
}