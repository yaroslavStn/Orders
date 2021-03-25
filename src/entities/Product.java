package entities;

import java.math.BigDecimal;

public class Product {
    private BigDecimal cost;
    private String name;
    private int id;

    public Product(BigDecimal cost, String name, int id) {
        this.cost = cost;
        this.name = name;
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("|%d| %s %s", id, name, cost);

    }
}
