package Commands;

import Interfaces.PurchaseCommand;
import Models.Book;
import Models.PurchaseContext;
import Utils.FormatterUtil;

public class PrintReceiptCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        double total = book.getPrice() * context.quantity;
        System.out.println("****************************");
        System.out.println("Quantum book store: Receipt");
        System.out.println(" - Book: " + book.getTitle());
        System.out.println(" - Quantity: " + context.quantity);
        System.out.println(" - Total: " + FormatterUtil.formatMoney(total));
        System.out.println("****************************");

    }
}
