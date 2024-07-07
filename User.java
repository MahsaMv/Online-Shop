import java.util.ArrayList;
import java.util.HashMap;

public class User extends Account {
    public HashMap<Product, Integer> cart;
    public ArrayList<Order> orders;
    public Wallet wallet;
    public HashMap<Product, Integer> bought;

    public User(String username, String password, String email, String phoneNumber, String address) {
        super(username, password, email, phoneNumber, address, Permission.USER);
        this.cart = new HashMap<>();
        this.orders = new ArrayList<>();
        this.wallet = new Wallet(0.0);
        this.bought = new HashMap<>();
    }

    //    public void addToCart(Product product){
//        cart.add(product);
//    }
    public double displayCart() {
        int i = 1;
        int totalPrice = 0;
        for (Product product : this.cart.keySet()) {
            System.out.println(i + ". " + product.name + ": " + this.cart.get(product));
            totalPrice += this.cart.get(product) * product.price;
            i += 1;
        }
        System.out.println("Total price: $" + totalPrice);
        return totalPrice;
    }
    public void addToCart(Product product){
        if (this.cart.containsKey(product)){
            this.cart.put(product, this.cart.get(product) + 1);
        }
        else {
            this.cart.put(product, 1);
        }
    }
}