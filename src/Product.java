public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id    = id;
        this.name  = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public int    getId   ()    { return id; }
    public String getName ()  { return name; }
    public double getPrice() { return price; }
    public int    getStock() { return stock; }

    // Verifica si hay suficiente stock
    public boolean isAvailable(int qty) {
        return stock >= qty;
    }

    // Reduce el stock al agregar al carrito
    public void reduceStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
        }
    }

    // Representación en texto (útil para depurar)
    @Override
    public String toString() {
        return String.format("[%d] %s - $%.2f (stock: %d)", id, name, price, stock);
    }
}