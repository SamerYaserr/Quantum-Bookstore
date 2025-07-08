# Quantum Bookstore

A Java-based application demonstrating a simple bookstore inventory and purchase management system using the Command design pattern.

## Features

* **Inventory Management**: Add books (PaperBook, EBook, ShowcaseBook) to the inventory and automatically remove outdated titles.
* **Purchase Workflow**: Handles the full purchase flow with the following commands:

  1. **ValidateAvailabilityCommand**: Ensures the book is sellable.
  2. **ReduceStockCommand**: Updates stock for physical or digital products.
  3. **DeliveryCommand**: Executes delivery logic (shipping for PaperBook, email for EBook).
  4. **PrintReceiptCommand**: Prints a formatted receipt to the console.
* **Extensible Design**: Easily add new command types, book models, or services without modifying existing code.

## Architecture & Project Structure

```
Quantum-Bookstore/
├── src/
│   ├── Commands/                      # Implementations of PurchaseCommand
│   │   ├── ValidateAvailabilityCommand.java
│   │   ├── ReduceStockCommand.java
│   │   ├── DeliveryCommand.java
│   │   └── PrintReceiptCommand.java
│   ├── Interfaces/                    # Core abstractions
│   │   ├── IProduct.java
│   │   ├── Sellable.java
│   │   ├── PurchaseCommand.java
│   │   └── IInventoryService.java
│   ├── Models/                        # Domain models
│   │   ├── Book.java                  # Abstract base class
│   │   ├── PaperBook.java             # Physical book with stock & shipping
│   │   ├── EBook.java                 # Digital book with stock & email delivery
│   │   ├── ShowcaseBook.java          # Non-sellable showcase-only book
│   │   └── PurchaseContext.java       # Context for purchase commands
│   ├── Services/                      # Core services
│   │   ├── InventoryService.java      # Implements IInventoryService
│   │   ├── ShippingService.java       # Handles physical delivery
│   │   └── MailService.java          # Handles email delivery
│   ├── Utils/                         # Utility classes
│   │   └── FormatterUtil.java         # Formats currency values
│   └── QuantumBookstore.java         # Entry point (main method)
├── .gitignore
└── Bookstore.iml (IDE config)
```

## Getting Started

### Building & Running

1. **Clone the repository**

   ```bash
   git clone https://github.com/SamerYaserr/Quantum-Bookstore.git
   cd Quantum-Bookstore
   ```

2. **Compile**

   ```bash
   javac -d out src/**/*.java
   ```

3. **Run**

   ```bash
   java -cp out QuantumBookstore
   ```

You should see console output demonstrating inventory addition, removal of outdated books, delivery actions, and printed receipts.

## Usage Example

```java
IInventoryService inventory = new InventoryService();

// Add various books
inventory.addBook(new EBook("ISBN001", "How to Avoid Mistakes?", 2025, 30.0, "Author A", "pdf", 5));
inventory.addBook(new PaperBook("ISBN002", "Happy Life", 2025, 45.0, "Author A", 10));
inventory.addBook(new ShowcaseBook("ISBN005", "Java Concurrency", 2006, 50.0, "Author B"));

// Remove books older than 10 years
inventory.removeOutdated(10);

// Purchase flow
inventory.buyBook("ISBN001", 1, "user@example.com", "n/a");
```

## Extending the System

* **Add New Book Types**: Create a new subclass of `Book` and implement delivery logic.
* **Add New Commands**: Implement the `PurchaseCommand` interface and include your command in the purchase pipeline in `InventoryService.buyBook()`.
* **Custom Services**: Provide alternative `ShippingService` or `MailService` implementations as needed.
