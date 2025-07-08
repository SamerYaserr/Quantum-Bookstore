import Interfaces.IInventoryService;
import Models.EBook;
import Services.InventoryService;
import Models.PaperBook;
import Models.ShowcaseBook;

public class QuantumBookstore {
    public static void main(String[] args) {
        IInventoryService inventory = new InventoryService();

        inventory.addBook(new EBook("ISBN001", "How Can I Avoid Making Foolish Mistakes?", 2025, 30.0, "Samer Samora", "pdf", 5));
        inventory.addBook(new PaperBook("ISBN002", "Happy Life", 2025, 45.0, "Samer Samora", 10));
        inventory.addBook(new PaperBook("ISBN003", "Clean Code", 2008, 45.0, "Uncle Bob", 10));
        inventory.addBook(new EBook("ISBN004", "Effective Java", 2018, 30.0, "JB", "pdf", 5));
        inventory.addBook(new ShowcaseBook("ISBN005", "Java Concurrency", 2006, 50.0, "BG"));

        inventory.removeOutdated(10);

        inventory.buyBook("ISBN001", 1, "bob@example.com", "n/a");
        inventory.buyBook("ISBN003", 3, "bob@example.com", "n/a");
        inventory.buyBook("ISBN001", 5, "alice@example.com", "123 Main St");
    }
}