package Interfaces;

import Models.Book;

import java.util.List;

public interface IInventoryService {
    void addBook(Book book);
    List<Book> removeOutdated(int years);
    double buyBook(String isbn, int quantity, String email, String address);
}
