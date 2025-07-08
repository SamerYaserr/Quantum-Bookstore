package Models;

public class PurchaseContext {
    public String email;
    public String address;
    public int quantity;

    public PurchaseContext(String email, String address, int quantity) {
        this.email = email;
        this.address = address;
        this.quantity = quantity;
    }
}