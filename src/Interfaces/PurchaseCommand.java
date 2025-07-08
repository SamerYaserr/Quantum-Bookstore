package Interfaces;

import Models.Book;
import Models.PurchaseContext;

public interface PurchaseCommand {
    void execute(Book book, PurchaseContext context);
}
