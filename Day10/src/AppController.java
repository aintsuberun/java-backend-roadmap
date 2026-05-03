import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class AppController {

    void start(){

        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);
        InputHelper input = new InputHelper();
        MenuChoice command;
        do {
            mainMenu.showMenu();
            int choice = input.checkInteger(scanner);
            command = MenuChoice.fromInt(choice);

            if (command == MenuChoice.INVALID) {
                System.out.println("Invalid value. Try again!");
                continue;
            }

            switch (command) {
                case ADD_BOOK:
                    addBookLogic(scanner, service, input);
                    break;

                case SHOW_BOOKS:
                    ArrayList<Book> books = service.getAllBooks();
                    if(books.isEmpty()){
                        System.out.println("No books in the library yet.");
                        break;
                    }
                    System.out.println("All books:");
                    for (Book book : books){
                        book.showInfo();
                    }
                    break;

                case FIND_BY_ID:
                    System.out.println("Enter ID: ");
                    int findById = input.checkInteger(scanner);
                    Optional<Book> foundBookId = service.findById(findById);
                    if(foundBookId.isPresent()){
                        foundBookId.get().showInfo();
                    }
                    else{
                        System.out.println("Book not found");
                    }
                    break;

                case REMOVE_BOOK:
                    System.out.println("Enter ID: ");
                    int findId = input.checkInteger(scanner);
                    if (input.confirmAction(scanner)) {
                        service.removeBookById(findId);
                    } else {
                        System.out.println("Book deletion cancelled.");
                    }
                    break;

                case SHOW_EXPENSIVE:
                    System.out.println("Enter price: ");
                    double expensivePrice = input.checkDouble(scanner);
                    books = service.getExpensiveBooks(expensivePrice);

                    if(books.isEmpty()){
                        System.out.println("No expensive books found.");
                    }
                    else{
                        for (Book book : books){
                            book.showInfo();
                        }
                    }

                    break;
                case FIND_BY_TITLE:
                    System.out.println("Enter title: ");
                    String findTitle = input.checkString(scanner);
                    Optional<Book> findByTitle = service.findByTitle(findTitle);
                    if(findByTitle.isPresent()){
                        findByTitle.get().showInfo();
                    }
                    else{
                        System.out.println("Book not found");
                    }
                    break;

                case SORT_BOOKS:
                    if(!service.sortByPrice()){
                        System.out.println("No books in library yet.");
                    }
                    else{
                        books = service.getAllBooks();
                        System.out.println("All books:");
                        for (Book book : books){
                            book.showInfo();
                        }
                    }
                    break;

                case SHOW_STATISTIC:
                    showStatistic(service);
                    break;

                case FIND_BY_AUTHOR:
                    System.out.println("Enter author: ");
                    String findAuthor = input.checkString(scanner);

                    books = service.findByAuthor(findAuthor);
                    if(books.isEmpty()){
                        System.out.println("Book not found");
                    }
                    else{
                        for(Book book : books){
                            book.showInfo();
                        }
                        System.out.println("Found " + books.size() + " book(s) by " + findAuthor);
                    }
                    break;

                case EXIT:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (command != MenuChoice.EXIT);
        scanner.close();
    }

    private static void addBookLogic(Scanner scanner, LibraryService service, InputHelper input) {
        do {
            System.out.println("Enter title name without white spaces in start, @, $, #, %, ^, *, ~, |, /:");
            String title = input.checkString(scanner);
            while (!title.matches("^[a-zA-Zа-яА-Я\\d\\s'\\-:,.]+$")) {
                System.out.println("Title can contain only letters, numbers and spaces");
                title = input.checkString(scanner);
            }

            System.out.println("Enter author name without numbers and symbols:");
            String author = input.checkString(scanner);
            while (!author.matches("^[a-zA-Zа-яА-Я\\s.'-]+$")) {
                System.out.println("Author can contain only letters and spaces");
                author = input.checkString(scanner);
            }

            System.out.println("Enter number of pages:");
            int pages = input.checkInteger(scanner);
            while (pages < 0) {
                System.out.println("Pages cannot be negative and zero. Enter again:");
                pages = input.checkInteger(scanner);
            }

            System.out.println("Enter price:");
            double price = input.checkDouble(scanner);
            while (price <= 0) {
                System.out.println("Price cannot be negative. Enter again:");
                price = input.checkDouble(scanner);
            }

            Book book = new Book(title, author, pages, price);
            service.addBook(book);
            showAddedBook(book);

            if (!input.continueAction(scanner)) {
                break;
            }
        } while (true);
    }

    private static void showAddedBook(Book book) {
        System.out.println("You added book: ");
        book.showInfo();
    }

    private static void showStatistic(LibraryService service){
        if(service.countBooks() == 0){
            System.out.println("No books in the library yet");
        }
        else{
            System.out.println("==========LIBRARY STATISTIC==========\n"+
                    "Total books in library: " + service.countBooks()+
                    "\nAverage price: " + service.averagePrice() +
                    "\nThe most expensive book: " + service.expensiveBook() +
                    "\nThe cheapest book: " + service.cheapBook()+
                    "\n=====================================");
        }
    }
}

