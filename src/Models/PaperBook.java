package Models;

import Interfaces.Sellable;
import Services.ShippingService;

public class PaperBook extends Book implements Sellable {
    private int stock;

    public PaperBook(String ISBN, String title, int publishedYear, double price, String author, int stock) {
        super(ISBN, title, publishedYear, price, author);
        this.stock = stock;
    }

    @Override
    public int getStock() { return stock; }

    @Override
    public void reduceStock(int quantity){
        if(quantity > stock)
            throw new IllegalArgumentException("Quantum book store: Not enough stock for ISBN " + getISBN());
        stock -= quantity;
    }

    @Override
    public void deliver(String email, String address){
        System.out.println("Quantum book store: Shipping PaperBook '" + getTitle() + "' to " + address);
        ShippingService.ship(this, address);
    }
}
