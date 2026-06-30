import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: Rs." + price);
    }
}

public class Main {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product Added.");
    }

    static void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product Updated.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    static void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product Deleted.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    static void displayProducts() {
        System.out.println("\nInventory:");
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 50000));
        addProduct(new Product(102, "Mouse", 50, 500));

        displayProducts();

        updateProduct(101, 15, 52000);

        displayProducts();

        deleteProduct(102);

        displayProducts();
    }
}
