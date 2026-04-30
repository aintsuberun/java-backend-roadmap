import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        Library lib = new Library();
        InputHelper input = new InputHelper();
        MenuChoice command;
        do {
            mainMenu.showMenu();
            int choice = input.checkInteger(scanner);
            command = MenuChoice.fromInt(choice);

            if (command == null) {
                System.out.println("Invalid value. Try again!");
                continue;
            }

            switch (command) {
                case ADD_BOOK:
                    addBookLogic(scanner, lib, input);
                    break;

                case SHOW_BOOKS:
                    lib.showAllBooks();
                    break;

                case FIND_BY_ID:
                    System.out.println("Enter ID: ");
                    int findById = input.checkInteger(scanner);
                    lib.findById(findById);
                    break;

                case REMOVE_BOOK:
                    System.out.println("Enter ID: ");
                    int findId = input.checkInteger(scanner);
                    if (input.confirmAction(scanner)) {
                        lib.removeBookById(findId);
                    } else {
                        System.out.println("Book deletion cancelled.");
                    }
                    break;

                case SHOW_EXPENSIVE:
                    System.out.println("Enter price: ");
                    double expensivePrice = input.checkDouble(scanner);
                    lib.showExpensiveBooks(expensivePrice);
                    break;
                case FIND_BY_TITLE:
                    System.out.println("Enter title: ");
                    String findTitle = input.checkString(scanner);
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
                    String findAuthor = input.checkString(scanner);
                    lib.findByAuthor(findAuthor);
                    break;

                case EXIT:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (command != MenuChoice.EXIT);
        scanner.close();
    }

    private static void addBookLogic(Scanner scanner, Library lib, InputHelper input) {
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
            lib.addBook(book);
            lib.showAddedBook(book);

            if (!input.continueAction(scanner)) {
                break;
            }

        } while (true);
    }
}




