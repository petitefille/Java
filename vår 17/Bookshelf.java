public class Bookshelf {
    
    public static void main(String[] args) {
        
        Container<Book> books = new Container<Book>(2);
        
        Book one = new Book("Battle Royale", "Unknown");
        Book two = new Book("Beauty and the Beast", "Disney");
        Book three = new Book("A song of ice and fire", "George Martin");
        
        int added;
        added = books.place(one);
        System.out.println("The book got placed at index: " + added);
        
        added = books.place(two);
        System.out.println("The book got placed at index: " + added);
        
        added = books.place(three);
        System.out.println("The book got placed at index: " + added);
        
    }
    
}
