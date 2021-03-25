import entities.Customer;
import entities.Product;

import java.util.Arrays;

public class Order {
    private ProductList productList;
    private Customer customer;
    private ShippingDetails shippingDetails;
    private int day;
    private OrderStatus orderStatus;
    private int id;

    public Order(ProductList productList, Customer customer, ShippingDetails shippingDetails, int day, OrderStatus orderStatus, int id) {
        this.productList = productList;
        this.customer = customer;
        this.shippingDetails = shippingDetails;
        this.day = day;
        this.orderStatus = orderStatus;
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ProductList getProductList() {
        return productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order " + id + '\n' +
                productList.arrayToString()
                +
                "customer: " + customer + '\n' +
                "shippingDetails: " + shippingDetails + '\n' +
                "day=" + day +
                ", orderStatus - " + orderStatus;
    }
}
