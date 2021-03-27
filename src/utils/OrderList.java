package utils;

import entities.Order;

import java.util.Arrays;

public class OrderList {
    private Order[] orders = new Order[0];

    public void addOrder(Order order) {
        orders = Arrays.copyOf(orders, orders.length + 1);
        orders[orders.length - 1] = order;
    }

    public Order getOrder(int index) {
        return orders[index];
    }

    public void setOrder(int index, Order value) {
        orders[index] = value;
    }

    public int size() {
        return orders.length;
    }

    @Override
    public String toString() {
        return arrayToString();
    }

    private String arrayToString() {
        if (orders == null)
            return "null";

        int iMax = orders.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();

        for (int i = 0; ; i++) {
            b.append(orders[i]).append(System.lineSeparator());
            if (i == iMax)
                return b.toString();
        }
    }
}
