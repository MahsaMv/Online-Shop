import java.util.ArrayList;
public class Seller extends Account {
    private String companyName;
    private ArrayList<Product> availableProducts;
    private Wallet wallet;
    public Seller(String username, String password, String companyName) {
        super(username, password, null, null, null, Permission.SELLER);
        this.companyName = companyName;
        this.availableProducts = new ArrayList<>();
        this.wallet = new Wallet(0.0);
    }
    public void addProduct(Product product) {
        availableProducts.add(product);
    }
}
