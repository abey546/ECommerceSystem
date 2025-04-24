// File: com/ecommerce/Customer.java
package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private List<Product> cart;

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
        System.out.println(product.getName() + " removed from cart.");
    }

    public double calculateTotal() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getCart() {
        return cart;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }
}