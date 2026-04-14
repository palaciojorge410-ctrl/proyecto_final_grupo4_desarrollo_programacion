import java.util.ArrayList;
import java.io.*;

public class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();
    private String filePath;

    public InventoryManager(String filePath) {
        this.filePath = filePath;
        loadInventory();
    }

    private void loadInventory() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id       = Integer.parseInt(parts[0].trim());
                String name  = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                int stock    = Integer.parseInt(parts[3].trim());
                products.add(new Product(id, name, price, stock));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar inventario: "+ e.getMessage()); 
        }
    }

    public void showCatalog() {
        System.out.println("\n=== CATÁLOGO CROSSOVER ===");
        for (Product p : products) {
            System.out.printf("[%d] %-25s $%.2f  (stock: %d)%n",
                p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void saveInventory() {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (Product p : products) {
                fw.write(p.getId() + "," + p.getName() + "," +
                         p.getPrice() + "," + p.getStock() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}