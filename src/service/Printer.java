package service;

import entities.Order;
import entities.OrderStatus;
import utils.OrderList;
import utils.ProductList;

import java.math.BigDecimal;
import java.util.Arrays;

public class Printer {
    private OrderList awaitingDeliveryOrders(OrderList orderList) {
        OrderList awaitingDeliveryOrders = new OrderList();
        for (int i = 0; i < orderList.size(); i++) {
            Order order = new Order(orderList.getOrder(i).getShippingDetails(), orderList.getOrder(i).getOrderStatus(), orderList.getOrder(i).getId());
            awaitingDeliveryOrders.addOrder(order);
        }
        return awaitingDeliveryOrders;
    }

    public void printAwaitingDeliveryOrders(OrderList orderList) {
        OrderList list = awaitingDeliveryOrders(orderList);

        System.out.println("Awaiting delivery orders: \n");
        System.out.printf("%s %12s %n", "Order \u2116", "Address");

        for (int i = 0; i < list.size(); i++) {
            if (list.getOrder(i).getOrderStatus() == OrderStatus.awaitingDelivery) {
                System.out.printf("%-12d %-25s %n", list.getOrder(i).getId(), list.getOrder(i).getShippingDetails().getAddress());
            }
        }
    }

    public void printProductList(ProductList productList, OrderList orderList) {
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
        Arrays.sort(productInOrders);
        for (ServiceList productInOrder : productInOrders) {
            System.out.println(productInOrder.getProduct().getName() + ": " + productInOrder.getCounter());
        }
    }

    public void advanced(OrderList orderList) {
        ServiceList[] advanced = new ServiceList[orderList.size()];
        for (int i = 0; i < orderList.size(); i++) {
            int orderId = orderList.getOrder(i).getId();
            int day =orderList.getOrder(i).getDay();
            OrderStatus status=orderList.getOrder(i).getOrderStatus();
            String nameFirstProduct= orderList.getOrder(i).getProductList().getProduct(0).getName();
            int quantityProducts = orderList.getOrder(i).getProductList().size();
            String customerName = orderList.getOrder(i).getCustomer().getName();
            BigDecimal totalCoast = orderList.getOrder(i).getShippingDetails().getCoast();
            boolean isDelivery= true;
            advanced[i]= new ServiceList(quantityProducts,orderId,day,status,nameFirstProduct,customerName,totalCoast,isDelivery);
        }


    }


}
