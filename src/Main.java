import entities.Customer;
import service.Printer;
import service.RandomValue;
import utils.OrderList;
import utils.ProductList;

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
        Printer printer = new Printer();

        for (int i = 0; i < customers.length; i++) {
            customers[i] = random.randomCustomer(i + 1);
        }
        String[] names = {"Milk", "Water", "Chocolate", "Car", "Flower", "Juice", "Fruit"};
        for (int i = 0; i < names.length; i++) {
            products.addProduct(random.randomProduct(i + 1, names[i]));
        }
        for (int i = 0; i < 11; i++) {
            orders.addOrder(random.randomOrder(products, customers, i + 1));
        }
        printer.printAwaitingDeliveryOrders(orders);
        printer.printProductList(products, orders);
        printer.advanced(orders);
        printer.hard(customers, orders);


    }


}
