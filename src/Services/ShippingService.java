package Services;

import Models.Book;

public class ShippingService{
    public static void ship(Book book, String address) {
        System.out.println("[ShippingService] Dispatching '" + book.getTitle() + "' (ISBN: " + book.getISBN() + ") to address: " + address);
    }
}
