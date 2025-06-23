import java.util.*;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " - " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.addProduct(new Product("P101", "Mouse", 50, 299.99));
        ims.addProduct(new Product("P102", "Keyboard", 30, 499.99));
        ims.updateProduct("P101", 45, 289.99);
        ims.displayInventory();
        ims.deleteProduct("P102");
        ims.displayInventory();
    }
}
