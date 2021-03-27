package utils;

import entities.Product;

import java.util.Arrays;

public class ProductList {
    private Product[] products = new Product[0];

    public void addProduct(Product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }

    public Product getProduct(int index) {
        return products[index];
    }

    public void setProduct(int index, Product value) {
        products[index] = value;
    }

    public int size() {
        return products.length;
    }

    @Override
    public String toString() {
        return arrayToString();
    }

    public String arrayToString() {
        if (products == null)
            return "null";

        int iMax = products.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();


        for (int i = 0; ; i++) {
            b.append(products[i]).append(System.lineSeparator());
            if (i == iMax)
                return b.toString();
        }
    }
}

