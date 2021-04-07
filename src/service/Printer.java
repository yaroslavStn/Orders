package service;

import entities.Customer;
import entities.Order;
import entities.OrderStatus;
import utils.OrderList;
import utils.ProductList;

import java.math.BigDecimal;

public class Printer {


    public void printAwaitingDeliveryOrders(OrderList orderList) {
        OrderList awaitingDeliveryOrders = new OrderList();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.getOrder(i).getOrderStatus() == OrderStatus.awaitingDelivery) {
                Order order = new Order(orderList.getOrder(i).getShippingDetails(), orderList.getOrder(i).getOrderStatus(), orderList.getOrder(i).getId());
                awaitingDeliveryOrders.addOrder(order);
            }
        }

        System.out.println("Awaiting delivery orders: \n");
        System.out.printf("%s %12s %n", "Order \u2116", "Address");
        for (int i = 0; i < awaitingDeliveryOrders.size(); i++) {
            System.out.printf("%-12d %-25s %n", awaitingDeliveryOrders.getOrder(i).getId(), awaitingDeliveryOrders.getOrder(i).getShippingDetails().getAddress());
        }
        System.out.println();
    }

    public void printProductList(ProductList productList, OrderList orderList) {
        String HEADER_FORMAT = "%10s %3s";
        String ROW_FORMAT = "%10s %5d";

        ServiceList[] productInOrders = new ServiceList[productList.size()];
        for (int i = 0; i < productList.size(); i++) {
            int sum = 0;
            for (int j = 0; j < orderList.size(); j++) {
                for (int k = 0; k < orderList.getOrder(j).getProductList().size(); k++) {
                    int productId = productList.getProduct(i).getId();
                    int productInCartId = orderList.getOrder(j).getProductList().getProduct(k).getId();
                    if (productId == productInCartId)
                        sum++;
                }
            }
            productInOrders[i] = new ServiceList(sum, productList.getProduct(i));
        }

        sortTable(productInOrders);

        System.out.printf(HEADER_FORMAT,
                "Product",
                "Quantity");
        System.out.println();
        for (ServiceList productInOrder : productInOrders) {
            String product = productInOrder.getProduct().getName();
            int quantity = productInOrder.getCounter();
            System.out.printf(ROW_FORMAT,
                    product,
                    quantity
            );
            System.out.println();
        }
        System.out.println();
    }

    public void advanced(OrderList orderList) {
        ServiceList[] advanced = new ServiceList[orderList.size()];
        for (int i = 0; i < orderList.size(); i++) {
            int orderId = orderList.getOrder(i).getId();
            int day = orderList.getOrder(i).getDay();
            OrderStatus status = orderList.getOrder(i).getOrderStatus();
            String nameFirstProduct = orderList.getOrder(i).getProductList().getProduct(0).getName();
            int quantityProducts = orderList.getOrder(i).getProductList().size();
            String customerName = orderList.getOrder(i).getCustomer().getName();
            BigDecimal totalCoast = orderList.getOrder(i).getShippingDetails().getCoast();
            String isDelivery = orderList.getOrder(i).getShippingDetails() != null ? "Yes" : "No";

            advanced[i] = new ServiceList(quantityProducts, orderId, day, status, nameFirstProduct, customerName, totalCoast, isDelivery);
        }
        sortTable(advanced);
        printSortedTable(advanced);
        System.out.println();
    }

    public void hard(Customer[] customers, OrderList orderList) {
        ServiceList[] hard = new ServiceList[customers.length];

        for (int i = 0; i < customers.length; i++) {
            int quantity = 0;
            BigDecimal totalCoast = BigDecimal.ZERO;
            int customerId = customers[i].getId();
            for (int j = 0; j < orderList.size(); j++) {
                int customerInOrder = orderList.getOrder(j).getCustomer().getId();
                if (customerId == customerInOrder) {
                    quantity++;
                    totalCoast = totalCoast.add(orderList.getOrder(j).getShippingDetails().getCoast());
                }
            }
            hard[i] = new ServiceList(quantity, customers[i].getName(), totalCoast, customers[i].getId());
        }
        printHardTable(hard);
    }

    private void sortTable(ServiceList[] serviceList) {
        for (int i = 0; i < serviceList.length; i++) {
            int compare;
            for (int j = 0; j < serviceList.length; j++) {
                if (serviceList[i].getDay() == 0) {
                    compare = serviceList[i].counterCompareTo(serviceList[j]);
                } else compare = serviceList[i].compareTo(serviceList[j]);
                if (compare < 0) {
                    ServiceList item = serviceList[j];
                    serviceList[j] = serviceList[i];
                    serviceList[i] = item;
                }
            }
        }
    }

    private void printHardTable(ServiceList[] items) {
        String HEADER_FORMAT = "%5s %10s %3s %10s";
        String ROW_FORMAT = "%5d %10s %5d %13s";

        System.out.printf(HEADER_FORMAT,
                "ID",
                "Customer",
                "Quantity",
                "Total");
        System.out.println();

        for (ServiceList item : items) {
            System.out.printf(ROW_FORMAT,
                    item.getCustomerId(),
                    item.getCustomerName(),
                    item.getCounter(),
                    item.getTotalCoast()
            );
            System.out.println();
        }
    }

    private void printSortedTable(ServiceList[] items) {
        String HEADER_FORMAT = "%5s %3s%20s %-15s%3s %15s %12s %5s";
        String ROW_FORMAT = "%5d %3d%20s %-15s%5d %15s %15s %5s";

        System.out.printf(HEADER_FORMAT,
                "ID",
                "Day",
                "Status",
                "Product",
                "Quantity",
                "Customer",
                "Total",
                "Shipping");
        System.out.println();

        for (ServiceList item : items) {
            System.out.printf(ROW_FORMAT,
                    item.getOrderId(),
                    item.getDay(),
                    item.getStatus(),
                    item.getProductName(),
                    item.getCounter(),
                    item.getCustomerName(),
                    item.getTotalCoast(),
                    item.getIsDelivery() != null ? "Yes" : "No"
            );
            System.out.println();
        }
    }


}
