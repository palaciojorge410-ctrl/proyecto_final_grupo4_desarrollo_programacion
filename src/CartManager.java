import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CartManager{
    private ArrayList<CartItem>
         items=new ArrayList<>();

    public addToCart(product produc,int qty) {
        if (produc.gestock()<qty) {
            System.out.println("stock incisuficiente.");
            return;
        }
        for (CartItem item :items) {
            if (item.getproduct()) {
                
            }
        }
    }

} 

