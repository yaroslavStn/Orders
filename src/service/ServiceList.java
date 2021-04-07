package service;

import entities.OrderStatus;
import entities.Product;
import entities.ShippingDetails;

import java.math.BigDecimal;

public class ServiceList implements Comparable<ServiceList> {
    private int counter;
    private Product product;
    private int orderId;
    private int day;
    private OrderStatus status;
    private String productName;
    private String customerName;
    private BigDecimal totalCoast;
    private String isDelivery;
    private ShippingDetails shippingDetails;
    private int customerId;


    ServiceList(int counter, int orderId, int day, OrderStatus status, String productName, String customerName, BigDecimal totalCoast, String isDelivery) {
        this.counter = counter;
        this.orderId = orderId;
        this.day = day;
        this.status = status;
        this.productName = productName;
        this.customerName = customerName;
        this.totalCoast = totalCoast;
        this.isDelivery = isDelivery;
    }

    ServiceList(int counter, Product product) {
        this.counter = counter;
        this.product = product;
    }

    ServiceList(int counter, String customerName, BigDecimal totalCoast, int customerId) {
        this.counter = counter;
        this.customerName = customerName;
        this.totalCoast = totalCoast;
        this.customerId = customerId;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    int getCustomerId() {
        return customerId;
    }

    int getOrderId() {
        return orderId;
    }

    int getDay() {
        return day;
    }

    OrderStatus getStatus() {
        return status;
    }

    String getProductName() {
        return productName;
    }

    String getCustomerName() {
        return customerName;
    }

    BigDecimal getTotalCoast() {
        return totalCoast;
    }

    int getCounter() {
        return counter;
    }

    Product getProduct() {
        return product;
    }

    String getIsDelivery() {
        return isDelivery;
    }

    public int compareTo(ServiceList other) {
        int dayOfMonthResult = Integer.compare(
                other.day, this.day);
        if (dayOfMonthResult != 0) {
            return dayOfMonthResult;
        }

        int statusResult = Integer.compare(
                this.status.ordinal(),
                other.status.ordinal());
        if (statusResult != 0) {
            return statusResult;
        }

        int customerResult = this.customerName.compareTo(other.customerName);
        if (customerResult != 0) {
            return customerResult;
        }

        int priceResult = other.totalCoast.compareTo(this.totalCoast);
        if (priceResult != 0) {
            return priceResult;
        }


        return 0;
    }

    int counterCompareTo(ServiceList other) {
        int counterResult = Integer.compare(this.counter, other.counter);
        if (counterResult != 0) {
            return counterResult;
        }
        return 0;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
