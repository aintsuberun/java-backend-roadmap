
public class Main{
    public static void main(String[] args){
    Book book1 = new Book("It","Steven");
    Book book2 = new Book("Преступление и наказание", "Ф.М.Достоевский", 560, 399.90);
    book1.showInfo();
    book2.showInfo();
    }
}

class Book {
    private String title;
    private String author;
    private int pages;
    private double price;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.pages = 0;
        this.price = 0;
    }

    Book(String title, String author, int pages, double price){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    void showInfo(){
        System.out.println("Title: " + title + "\nAuthor: " + author
        + "\nPages: " + pages + "\nPrice: " + price);
    }
}