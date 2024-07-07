import java.util.ArrayList;
public class Shop {
    private String shopName;
    private String webAddress;
    private String  supportNumber;
    public static ArrayList<Account> accounts;
    public static ArrayList<Product> products;
    public static ArrayList<Order> orders;
    public static ArrayList<Category> categories;
    public static double totalProfit;

    public Shop(String shopName, String webAddress, String supportNumber) {
        this.shopName = shopName;
        this.webAddress = webAddress;
        this.supportNumber = supportNumber;
        this.accounts = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.totalProfit = 0.0;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString(){
        return "Welcome to " + this.shopName + "\n"
                + "Website: " + this.webAddress + "\n"
                + "Support number: " + this.supportNumber;
    }
    //entity.User
    public void addAccount(Account account){
        accounts.add(account);
    }
    //entity.Seller
    public void addProduct(Product product){
        products.add(product);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
    public void viewCategories() {
        for (Category category : getCategories()) {
            System.out.println("Category: " + category.getName());
            for (Product product : category.getProducts()) {
                System.out.println("  Product: " + product.getName() + ", Price: $" + product.getPrice() + ", Stock: " + product.getInventory());
            }
        }
    }
    public static Account findAccount(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }
    public static Product searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
