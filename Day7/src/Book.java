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
    /*static void showTotalBooks(){
        System.out.println("Total books created: " + totalBooks);
    }

    void discount(double percent){
        if (percent > 0 && percent < 80){
            price = price - (price/100)*percent;
            System.out.println("Total price with " + percent + "% discont is: " + price);
        }
    }*/

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