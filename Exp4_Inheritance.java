
class Product {
    int product_id;
    String name;

    // Base class constructor
    Product(int product_id, String name) {
        this.product_id = product_id;
        this.name = name;
    }

    // Display common product details
    void display() {
        System.out.println("Product ID: " + product_id);
        System.out.println("Product Name: " + name);
    }
}

// Electronic subclass
class Electronic extends Product {
    String brand;

    Electronic(int product_id, String name, String brand) {
        super(product_id, name);
        this.brand = brand;
    }

    // Display electronic product details
    void displayElectronics() {
        display();
        System.out.println("Brand: " + brand);
    }
}

// Clothing subclass
class Clothing extends Product {
    String size;

    Clothing(int product_id, String name, String size) {
        super(product_id, name);
        this.size = size;
    }

    // Display clothing product details
    void displayClothing() {
        display();
        System.out.println("Size: " + size);
    }
}

public class Exp4_Inheritance {
    public static void main(String[] args) {

        // Create objects
        Electronic e = new Electronic(101, "Laptop", "HP");
        Clothing c = new Clothing(102, "T-shirt", "Large");

        System.out.println("Electronics Details");
        e.displayElectronics();

        System.out.println();

        System.out.println("Clothing Details");
        c.displayClothing();
    }
}
