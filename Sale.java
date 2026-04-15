import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int id;
    private List<SaleItem> items = new ArrayList<>();
    private double total;
    private double tax;
    private double discount;

    public void calculateTotal() {
        double subtotal = 0;
        for (SaleItem item : items) {
            subtotal += item.getSubtotal();
        }

        tax = subtotal * 0.07;
        total = subtotal + tax - discount;
    }

    public Sale() {}

    public Sale(int id, List<SaleItem> items, double total, double tax, double discount){
        this.id = id;
        this.items = items;
        this.total = total;
        this.total = tax;
        this.total = discount;
    }

    public int getId() {
        return id;
    }

    public void addItem(SaleItem item) {
        items.add(item);
    }

    public double getTotal() {
        return total;
    }

    public double getTax() {
        return tax;
    }
    public void steTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}