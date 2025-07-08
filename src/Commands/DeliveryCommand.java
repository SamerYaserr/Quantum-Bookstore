package Commands;

import Interfaces.PurchaseCommand;
import Models.Book;
import Models.PurchaseContext;

public class DeliveryCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        book.deliver(context.email, context.address);
    }
}
