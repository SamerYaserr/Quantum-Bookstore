package Commands;

import Interfaces.PurchaseCommand;
import Models.Book;
import Models.EBook;
import Models.PaperBook;
import Models.PurchaseContext;

public class ReduceStockCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        if (book instanceof PaperBook paperBook) {
            paperBook.reduceStock(context.quantity);
        }
        if(book instanceof  EBook eBook){
            eBook.reduceStock(context.quantity);
        }
    }
}
