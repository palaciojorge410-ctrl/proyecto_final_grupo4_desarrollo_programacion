public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager("data/inventory.txt");
        CartManager cart = new CartManager();
        Menu menu = new Menu(inventory, cart);
        menu.start();
    }
}