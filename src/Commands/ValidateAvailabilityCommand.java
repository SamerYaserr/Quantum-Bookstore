package Commands;

import Interfaces.PurchaseCommand;
import Interfaces.Sellable;
import Models.Book;
import Models.PaperBook;
import Models.PurchaseContext;

public class ValidateAvailabilityCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        if (!(book instanceof Sellable)) {
            throw new UnsupportedOperationException(book.getTitle() + "is not sellable");
        }
    }
}
