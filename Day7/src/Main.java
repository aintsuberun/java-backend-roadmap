import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        Library lib = new Library();
        mainMenu.showMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 0) {
            if(choice == 1) {
                do {
                    System.out.println("Enter title name:");
                    String title = scanner.nextLine();

                    System.out.println("Enter author name:");
                    String author = scanner.nextLine();

                    System.out.println("Enter number of pages:");
                    int pages = scanner.nextInt();
                    scanner.nextLine();
                    while (pages < 0) {
                        System.out.println("Pages cannot be negative. Enter again:");
                        pages = scanner.nextInt();
                        scanner.nextLine();
                    }

                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    while (price < 0) {
                        System.out.println("Pages cannot be negative. Enter again:");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                    }

                    Book book = new Book(title, author, pages, price);
                    lib.addBook(book);
                    lib.showAddedBook(book);

                    System.out.println("----------------------------------\n"+
                            "Do you want to continue?\nYes - 1\nBack to menu - 2" +
                            "\n----------------------------------");
                    int continueChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (continueChoice != 1) {
                        break;
                    }
                } while (true);
            }
            else if (choice == 2){
                lib.showAllBooks();
            }
            else if (choice == 3){
                System.out.println("Enter title: ");
                String findTitle = scanner.nextLine();
                lib.findBookByTitle(findTitle);
            }
            else if (choice == 4){
                System.out.println("Enter ID: ");
                int findId = scanner.nextInt();
                scanner.nextLine();
                lib.removeBookById(findId);
            }
            else if (choice == 5){
                System.out.println("Enter price: ");
                double expensivePrice = scanner.nextDouble();
                scanner.nextLine();
                lib.showExpensiveBooks(expensivePrice);
            }
            else{
                System.out.println("Invalid value. Try again: ");
            }
            mainMenu.showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
        }
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
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else {
            System.out.println("All books: ");
            for (Book book : books) {
                book.showInfo();
            }
        }
    }


    void countBooks(){
        System.out.println("Total books in library: " + books.size());
    }

    void findBookByTitle(String title){
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else {
            for (Book book: books){
                if (book.getTitle().equals(title)){
                    System.out.println("The book <<" + title +">> found.");
                    return;
                }

            }
            System.out.println("The book <<" + title + ">> not found.");
        }
    }

    void removeBookById(int id){
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else {
            for (Book book : books) {
                if (book.getId() == id) {
                    books.remove(book);
                    System.out.println("The book with id " + id + " has been removed.");
                    return;
                }
            }
            System.out.println("The book with id " + id + " wasn't found.");
        }
    }

    void showExpensiveBooks(double price){
        if (books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else{
            System.out.println("Books price higher than " + price);
            int count = 0;
            for (Book book : books) {
                if (book.getPrice() > price) {
                    book.showInfo();
                    count++;
                }
            }
            if (count == 0){
                System.out.println("No books found with price higher than " + price);
            }
        }
    }

    void showAddedBook(Book book){
        System.out.println("You added book: ");
        book.showInfo();
    }
}

class Menu{
    void showMenu(){
        System.out.println("----------------------------------"
                +"\nHello! What you want to do?\n" +
                "1 - Add book\n" +
                "2 - Show books\n" +
                "3 - Find book\n" +
                "4 - Remove book\n" +
                "5 - Show expensive books\n" +
                "0 - Exit\n" +
                "----------------------------------");
    }
}