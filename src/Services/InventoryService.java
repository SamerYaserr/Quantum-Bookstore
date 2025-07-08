package Services;

import Commands.DeliveryCommand;
import Commands.PrintReceiptCommand;
import Commands.ReduceStockCommand;
import Commands.ValidateAvailabilityCommand;
import Interfaces.IInventoryService;
import Interfaces.PurchaseCommand;
import Interfaces.Sellable;
import Models.Book;
import Models.PurchaseContext;

import java.time.Year;
import java.util.*;

public class InventoryService implements IInventoryService {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        System.out.println("Added to inventory: " + book.getTitle());
        books.put(book.getISBN(), book);
    }

    @Override
    public List<Book> removeOutdated(int age) {
        int cutoff = Year.now().getValue() - age;
        List<Book> removed = new ArrayList<>();

        for (Iterator<Book> it = books.values().iterator(); it.hasNext(); ) {
            Book book = it.next();
            if (book.getPublishedYear() < cutoff) {
                removed.add(book);
                it.remove();
                System.out.println("Removed outdated book " + book.getTitle());
            }
        }

        return removed;
    }

    @Override
    public double buyBook(String ISBN, int quantity, String email, String address) {
        if (!books.containsKey(ISBN)) throw new IllegalArgumentException("ISBN not found");
        Book book = books.get(ISBN);

        PurchaseContext context = new PurchaseContext(email, address, quantity);

        List<PurchaseCommand> commands = List.of(
                new ValidateAvailabilityCommand(),
                new ReduceStockCommand(),
                new DeliveryCommand(),
                new PrintReceiptCommand()
        );

        for (PurchaseCommand command : commands) {
            command.execute(book, context);
        }
        double total = book.getPrice() * quantity;
        return total;
    }
}
