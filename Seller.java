import java.util.ArrayList;
public class Seller extends Account {
    public String companyName;
    public ArrayList<Product> availableProducts;
    public Wallet wallet;
    public Request sellRequest;
    public boolean permissionToSell = false;
    public Seller(String username, String password, String companyName) {
        super(username, password, null, null, null, Permission.SELLER);
        this.companyName = companyName;
        this.availableProducts = new ArrayList<>();
        this.wallet = new Wallet(0.0);
    }
    public void addProduct(Product product) {
        availableProducts.add(product);
    }
    public void removeProduct(Product product) {
        availableProducts.remove(product);
    }
    public void displayAvailableProducts(){
        int i = 1;
        for (Product product : this.availableProducts) {
            System.out.println(i + ". " + product.name + " $" + product.price);
            i += 1;
        }
    }
}
