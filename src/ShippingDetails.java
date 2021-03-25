import java.math.BigDecimal;

public class ShippingDetails {
    private BigDecimal coast;
    private String address;

    public ShippingDetails(BigDecimal coast, String address) {
        this.coast = coast;
        this.address = address;
    }

    public BigDecimal getCoast() {
        return coast;
    }

    public void setCoast(BigDecimal coast) {
        this.coast = coast;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "coast=" + coast +
                ", address: " + address;
    }
}
