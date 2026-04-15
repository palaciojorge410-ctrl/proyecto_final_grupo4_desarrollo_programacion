import java.util.Scanner;

public class Menu {
    private InventoryManager inventory;
    private CartManager cart;
    private Scanner scanner = new Scanner(System.in);

    public Menu(InventoryManager inventory, CartManager cart) {
        this.inventory = inventory;
        this.cart      = cart;
    }

    public void start() {
        int opcion;
        do {
            System.out.println("\n+==============================+");
            System.out.println("|  CROSSOVER - Tienda Geek    |");
            System.out.println("+==============================+");
            System.out.println("|  1. Ver catalogo             |");
            System.out.println("|  2. Agregar al carrito       |");
            System.out.println("|  3. Ver carrito              |");
            System.out.println("|  4. Eliminar del carrito     |");
            System.out.println("|  5. Finalizar compra         |");
            System.out.println("|  0. Salir                    |");
            System.out.println("+==============================+");
            System.out.print("Elige una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Opcion invalida. Intenta de nuevo: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    inventory.showCatalog();
                    break;

                case 2:
                    inventory.showCatalog();
                    System.out.print("ID del producto: ");
                    int id = scanner.nextInt();
                    Product p = inventory.findById(id);
                    if (p == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    int qty = scanner.nextInt();
                    if (qty <= 0) {
                        System.out.println("Cantidad invalida.");
                        break;
                    }
                    cart.addToCart(p, qty);
                    System.out.println("\"" + p.getName() + "\" agregado al carrito.");
                    break;

                case 3:
                    cart.showCart();
                    break;

                case 4:
                    cart.showCart();
                    if (!cart.isEmpty()) {
                        System.out.print("ID del producto a eliminar: ");
                        int removeId = scanner.nextInt();
                        cart.removeItem(removeId);
                    }
                    break;

                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("El carrito esta vacio. Agrega productos primero.");
                        break;
                    }
                    cart.showCart();
                    System.out.print("Confirmar compra? (1=Si / 0=No): ");
                    int confirm = scanner.nextInt();
                    if (confirm == 1) {
                        cart.generateInvoice();
                        inventory.saveInventory();
                        cart.clearCart();
                        System.out.println("Compra realizada exitosamente!");
                    } else {
                        System.out.println("Compra cancelada.");
                    }
                    break;

                case 0:
                    System.out.println("Hasta pronto! Vuelve por mas.");
                    break;

                default:
                    System.out.println("Opcion invalida. Elige entre 0 y 5.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}