class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println("ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category);
    }
}

public class Main {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Chair", "Furniture"),
                new Product(105, "Table", "Furniture")
        };

        int searchId = 103;

        System.out.println("Linear Search:");
        Product p1 = linearSearch(products, searchId);
        if (p1 != null)
            p1.display();
        else
            System.out.println("Product Not Found");

        System.out.println();

        System.out.println("Binary Search:");
        Product p2 = binarySearch(products, searchId);
        if (p2 != null)
            p2.display();
        else
            System.out.println("Product Not Found");
    }
}
