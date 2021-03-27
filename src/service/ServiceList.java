package service;

import entities.OrderStatus;
import entities.Product;

import java.math.BigDecimal;

public class ServiceList implements Comparable <ServiceList> {
    private int counter;
    private Product product;
    private int orderId;
    private int day;
    private OrderStatus status;
    private String productName;
    private String customerName;
    private BigDecimal totalCoast;
    private boolean isDelivery;


    public ServiceList(int counter, int orderId, int day, OrderStatus status, String productName, String customerName, BigDecimal totalCoast, boolean isDelivery) {
        this.counter = counter;
        this.orderId = orderId;
        this.day = day;
        this.status = status;
        this.productName = productName;
        this.customerName = customerName;
        this.totalCoast = totalCoast;
        this.isDelivery = isDelivery;
    }

    public ServiceList(int counter, Product product) {
        this.counter = counter;
        this.product = product;
    }
    public int getOrderId() {
        return orderId;
    }

    public int getDay() {
        return day;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getProductName() {
        return productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalCoast() {
        return totalCoast;
    }

    public int getCounter() {
        return counter;
    }

    public Product getProduct() {
        return product;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(ServiceList o) {
        return o.getCounter()-this.getCounter();
    }
}
