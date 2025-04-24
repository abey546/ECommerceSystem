package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
    private String status;

    public Order(String orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = products.stream().mapToDouble(Product::getPrice).sum();
        this.status = "Pending";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderID).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Products:\n");
        for (Product product : products) {
            sb.append(" - ").append(product).append("\n");
        }
        sb.append("Total: $").append(orderTotal).append("\n");
        sb.append("Status: ").append(status);
        return sb.toString();
    }
}