import java.security.cert.PKIXBuilderParameters;

public class CartItem {
    private Product product;
    private int qty;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty     = qty;
    }

    
    public Product getProduct() { return Product; }
    public int     getQty()     { return qty; }

    public void increaseQty(int qty) {
        this.qty += qty;
    }

    
    public double getSubtotal() {
        return Product.getPrice() * qty;
    }

    @Override
    public String toString() {
        return String.format("%-25s x%-3d $%.2f",
            Product.getName(), qty, getSubtotal());
    }
}
