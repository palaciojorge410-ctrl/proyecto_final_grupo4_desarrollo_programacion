public class CartItem {
    private Product product;
    private int qty;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty     = qty;
    }

    // Getters
    public Product getProduct() { return product; }
    public int     getQty()     { return qty; }

    // Suma más unidades si el producto ya existe en el carrito
    public void increaseQty(int qty) {
        this.qty += qty;
    }

    // Subtotal de este ítem
    public double getSubtotal() {
        return product.getPrice() * qty;
    }

    @Override
    public String toString() {
        return String.format("%-25s x%-3d $%.2f",
            product.getName(), qty, getSubtotal());
    }
}