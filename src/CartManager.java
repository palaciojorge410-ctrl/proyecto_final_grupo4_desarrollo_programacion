import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CartManager {
    private ArrayList<CartItem> items = new ArrayList<>();
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    

    public void addToCart(Product product, int qty) {
        if (product.getStock() < qty) {
            System.out.println("Stock insuficiente.");
            return;
        }
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.increaseQty(qty);
                product.reduceStock(qty);
                return;
            }
        }
        items.add(new CartItem(product, qty));
        product.reduceStock(qty);
    }

    public void removeItem(int productId) {
        items.removeIf(i -> i.getProduct().getId() == productId);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQty();
        }
        return total;
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        for (CartItem item : items) {
            System.out.printf("%-20s x%d  $%.2f%n",
                item.getProduct().getName(),
                item.getQty(),
                item.getProduct().getPrice() * item.getQty());
        }
        System.out.printf("TOTAL: $%.2f%n", calculateTotal());
    }

    public void generateInvoice() {
        try (FileWriter fw = new FileWriter("data/invoice.txt")) {
            fw.write("=== CROSSOVER – Tienda Geek ===\n");
            fw.write("FACTURA\n\n");
            for (CartItem item : items) {
                fw.write(item.getProduct().getName() + " x" +
                    item.getQty() + " = $" +
                    (item.getProduct().getPrice() * item.getQty()) + "\n");
            }
            fw.write("\nTOTAL: $" + calculateTotal() + "\n");
            System.out.println("Factura generada en data/invoice.txt");
        } catch (IOException e) {
            System.out.println("Error al generar factura: " + e.getMessage());
        }
    }

    public void clearCart() {
        items.clear();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
}
