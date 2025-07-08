package Models;

public class ShowcaseBook extends Book{
    public ShowcaseBook(String isbn, String title, int publishedYear, double price, String author) {
        super(isbn, title, publishedYear, price, author);
    }

    @Override
    public void deliver(String email, String address){
        throw new UnsupportedOperationException("Quantum book store: Showcase books cannot be sold");
    }
}
