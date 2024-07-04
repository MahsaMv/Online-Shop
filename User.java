import java.util.ArrayList;
public class User extends Account {
    private ArrayList<Product> cart;
    private ArrayList<Order> orders;
    private Wallet wallet;
    //private Permission permission;
    public User(String username, String password, String email, String phoneNumber, String address) {
        super(username, password, email, phoneNumber, address, Permission.USER);
        this.cart = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.wallet = new Wallet(0);
    }

    public void addToCart(Product product){
        cart.add(product);
    }
    public void displayCart(){
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            product.displayProduct();
        }
    }
}