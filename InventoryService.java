import java.util.List;
import java.util.ArrayList;

public class InventoryService {
    
    private List<Product> products = new ArrayList<>();
    
    public void addProduct(Product product) {
        if(product.getPrice() > 0 && product.getStock() >= 0) {
            products.add(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product p : products ) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void showProducts() {
        for (Product p : products) {
            System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice());
        }
    }
}
