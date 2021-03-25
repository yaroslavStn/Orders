import entities.Customer;
import entities.Product;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }


    private void run() {

        RandomValue random = new RandomValue();
        Customer[] customers = new Customer[12];
        ProductList products = new ProductList();
        OrderList orders = new OrderList();

        for (int i = 0; i < customers.length; i++) {
            customers[i] = random.randomCustomer(i + 1);
        }
        for (int i = 0; i < 12; i++) {
            products.addProduct(random.randomProduct(i + 1));
        }
        for (int i = 0; i < 11; i++) {
            orders.addOrder(random.randomOrder(products, customers, i + 1));
        }
        System.out.println(orders);

    }

}
