package Models;

import Interfaces.Sellable;
import Services.MailService;

public class EBook extends Book implements Sellable {
    private final String fileType;
    private int stock;

    public EBook(String ISBN, String title, int publishedYear, double price, String author, String fileType, int stock) {
        super(ISBN, title, publishedYear, price, author);
        this.fileType = fileType;
        this.stock = stock;
    }

    public String getFileType() { return fileType; }

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
        System.out.println("Quantum book store: Sending EBook '" + getTitle() + "' to " + email);
        MailService.send(this, email);
    }
}
