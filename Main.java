// File: Main.java
import com.ecommerce.*;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product("P101", "Laptop", 999.99);
        Product p2 = new Product("P102", "Smartphone", 499.99);
        Product p3 = new Product("P103", "Headphones", 59.99);

        // Display products
        System.out.println("Available Products:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Create a customer
        Customer customer = new Customer("C001", "Alice");

        // Add products to cart
        customer.addToCart(p1);
        customer.addToCart(p3);

        // Display cart total
        System.out.println("\nCart total: $" + customer.calculateTotal());

        // Place an order
        Order order = new Order("O1001", customer, customer.getCart());
        System.out.println("\nOrder Summary:");
        System.out.println(order.getSummary());

        // Update and display order status
        order.updateStatus("Shipped");
        System.out.println("\nUpdated Order Status:");
        System.out.println(order.getSummary());
    }
}

