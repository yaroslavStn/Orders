package service;

import entities.*;
import utils.ProductList;

import java.math.BigDecimal;

public class RandomValue {
    public Customer randomCustomer(int randomId) {
        String[] names = {"Вася", "Петя", "Коля", "Женя", "Толя", "Саша", "Тема"};
        String randomName = names[(int) (Math.random() * names.length)];

        return new Customer(randomName, randomId);
    }


    public Product randomProduct(int randomId, String name) {
        BigDecimal randomCoast = BigDecimal.valueOf(Math.random() * 1000);
        return new Product(randomCoast, name, randomId);
    }

    public Order randomOrder(ProductList products, Customer[] customers, int orderId) {
        ProductList cart = new ProductList();
        for (int i = 0; i < (int) ((Math.random()) * 10 + 1); i++) {
            cart.addProduct(products.getProduct((int) ((Math.random() * products.size()))));
        }
        Customer randomCust = customers[(int) ((Math.random() * customers.length))];
        BigDecimal cartCoast = new BigDecimal("0");
        for (int i = 0; i < cart.size(); i++) cartCoast = cart.getProduct(i).getCost().add(cartCoast);
        ShippingDetails randomDetails = new ShippingDetails(cartCoast, randomAddress());
        OrderStatus[] statuses = OrderStatus.values();
        OrderStatus randomStatus = statuses[(int) ((Math.random()) * statuses.length)];
        int randomDay = (int) ((Math.random() * 30) + 1);

        return new Order(cart, randomCust, randomDetails, randomDay, randomStatus, orderId);
    }

    private String randomAddress() {
        String[] address = {"1st avenue", "122nd avenue", "31th avenue", "4th avenue", "52th avenue", "6th avenue", "7th avenue"};
        return address[(int) (Math.random() * address.length)];
    }
}
