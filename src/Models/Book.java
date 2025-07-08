package Models;

import Interfaces.IProduct;

public abstract class Book implements IProduct {
    private final String ISBN;
    private final String title;
    private final int publishedYear;
    private final double price;
    private final String author;

    public Book(String ISBN, String title, int publishedYear, double price, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getISBN() { return ISBN; }

    @Override
    public String getAuthor() { return author; }

    @Override
    public double getPrice() { return price; }

    @Override
    public int getPublishedYear() { return publishedYear; }

    @Override
    public String getTitle() { return title; }

    public abstract void deliver(String email, String address);
}
