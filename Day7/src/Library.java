import java.util.ArrayList;

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
