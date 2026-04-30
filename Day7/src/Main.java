import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        Library lib = new Library();
        MenuChoice command;
        do {
            mainMenu.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            command = MenuChoice.fromInt(choice);

            if (command == null) {
                System.out.println("Invalid value. Try again!");
                continue;
            }

            switch (command) {
                case ADD_BOOK:
                    addBookLogic(scanner, lib);
                    break;

                case SHOW_BOOKS:
                    lib.showAllBooks();
                    break;

                case FIND_BY_ID:
                    System.out.println("Enter ID: ");
                    int findById = scanner.nextInt();
                    scanner.nextLine();
                    lib.findById(findById);
                    break;

                case REMOVE_BOOK:
                    System.out.println("Enter ID: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();
                    lib.removeBookById(findId);
                    break;

                case SHOW_EXPENSIVE:
                    System.out.println("Enter price: ");
                    double expensivePrice = scanner.nextDouble();
                    scanner.nextLine();
                    lib.showExpensiveBooks(expensivePrice);
                    break;
                case FIND_BY_TITLE:
                    System.out.println("Enter title: ");
                    String findTitle = scanner.nextLine();
                    lib.findBookByTitle(findTitle);
                    break;

                case SORT_BOOKS:
                    lib.sortByPrice();
                    lib.showAllBooks();
                    break;

                case SHOW_STATISTIC:
                    lib.showStatistic();
                    break;

                case FIND_BY_AUTHOR:
                    System.out.println("Enter author: ");
                    String findAuthor = scanner.nextLine();
                    lib.findByAuthor(findAuthor);
                    break;

                case EXIT:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (command != MenuChoice.EXIT);
        scanner.close();
    }

    private static void addBookLogic(Scanner scanner, Library lib) {
        do {
            System.out.println("Enter title name without spaces:");
            String title = scanner.nextLine();
            while(title.isBlank() || title.contains(" ")){
                System.out.println("Title can not be empty and can not contain spaces");
                title = scanner.nextLine();
            }

            System.out.println("Enter author name:");
            String author = scanner.nextLine();
            while(author.isEmpty()){
                System.out.println("Author can not be empty");
                System.out.println("Enter author name:");
                author = scanner.nextLine();
            }

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
            while (price <= 0) {
                System.out.println("Price cannot be negative. Enter again:");
                price = scanner.nextDouble();
                scanner.nextLine();
            }

            Book book = new Book(title, author, pages, price);
            lib.addBook(book);
            lib.showAddedBook(book);

            System.out.println("----------------------------------\n" +
                    "Do you want to continue?\nYes - 1\nBack to menu - 2" +
                    "\n----------------------------------");
            int continueChoice = scanner.nextInt();
            scanner.nextLine();

            if (continueChoice != 1) {
                break;
            }
        } while (true);
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

    public String getAuthor(){ return author;}

    public int getId(){
        return id;
    }

    public double getPrice() {
        return price;
    }

}

class Library {
    private ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet");
        } else {
            System.out.println("All books: ");
            for (Book book : books) {
                book.showInfo();
            }
        }
    }

    void findBookByTitle(String title) {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet");
        } else {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    System.out.println("The book <<" + title + ">> found.");
                    return;
                }

            }
            System.out.println("The book <<" + title + ">> not found.");
        }
    }

    void removeBookById(int id) {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet");
        } else {
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

    void showExpensiveBooks(double price) {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet");
        } else {
            System.out.println("Books price higher than " + price);
            int count = 0;
            for (Book book : books) {
                if (book.getPrice() > price) {
                    book.showInfo();
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No books found with price higher than " + price);
            }
        }
    }

    void showAddedBook(Book book) {
        System.out.println("You added book: ");
        book.showInfo();
    }

    void findByAuthor(String author){
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else{
            for (Book book: books){
                if(book.getAuthor().equalsIgnoreCase(author)){
                    book.showInfo();
                    System.out.println("Book written by " +author+" has been found.");
                    continue;
                }
            }
            System.out.println("Book written by "+author+" wasn't found.");
        }
    }

    void findById(int id){
        if (books.isEmpty()) {
            System.out.println("No books in the library yet");
        } else {
            for (Book book : books) {
                if (book.getId() == id) {
                    book.showInfo();
                    System.out.println("The book with id " + id + " has been found.");
                    return;
                }
            }
            System.out.println("The book with id " + id + " wasn't found.");
        }
    }

    int countBooks(){
        return books.size();
    }

    double averagePrice(){
        if (books.isEmpty()) return 0.0;
        double average = 0.0;
        double sum = 0.0;
        for(Book book : books){
            average= average +book.getPrice();
        }
        sum = average/books.size();
        return sum;
    }

    double expensiveBook(){
        if (books.isEmpty()) return 0.0;
        double mostExpensive = books.getFirst().getPrice();
        for(Book book : books){
            if(book.getPrice()>mostExpensive){
                mostExpensive = book.getPrice();
            }
        }
        return mostExpensive;
    }

    double cheapBook(){
        if (books.isEmpty()) return 0.0;
        double mostCheap = books.getFirst().getPrice();
        for (Book book : books){
            if(book.getPrice()<mostCheap){
                mostCheap = book.getPrice();
            }
        }
        return mostCheap;
    }
    void showStatistic(){
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else{
            System.out.println("==========LIBRARY STATISTIC==========\n"+
                    "Total books in library: " + countBooks()+
                    "\nAverage price: " + averagePrice() +
                    "\nThe most expensive book: " + expensiveBook() +
                    "\nThe cheapest book: " + cheapBook()+
                    "\n=====================================");
        }
    }
    void sortByPrice(){
        if(books.isEmpty()){
            System.out.println("No books in the library yet");
        }
        else{
            books.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
            System.out.println("Books were sorted. New list:\n");
        }
    }
}

class Menu{
    void showMenu(){
        System.out.println("----------------------------------"
                +"\nHello! What you want to do?\n" +
                "1 - Add book\n" +
                "2 - Show books\n" +
                "3 - Find book by ID\n" +
                "4 - Remove book\n" +
                "5 - Find book by title\n" +
                "6 - Show expensive books\n" +
                "7 - Sort books\n" +
                "8 - Show Statistic\n" +
                "9 - Find book by author\n" +
                "0 - Exit\n" +
                "----------------------------------");
    }
}


enum MenuChoice{
    ADD_BOOK(1),
    SHOW_BOOKS(2),
    FIND_BY_ID(3),
    REMOVE_BOOK(4),
    FIND_BY_TITLE(5),
    SHOW_EXPENSIVE(6),
    SORT_BOOKS(7),
    SHOW_STATISTIC(8),
    FIND_BY_AUTHOR(9),
    EXIT(0);

    private final int value;

    MenuChoice(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static MenuChoice fromInt(int choice){
        for (MenuChoice command : MenuChoice.values()){
            if(command.getValue() == choice){
                return command;
            }
        }
        return null;
    }
}

