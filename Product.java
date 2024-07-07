import java.util.ArrayList;
public class Product extends Category {
    public String name;
    public double price;
    public int inventory;
    public ArrayList<String> comments = new ArrayList<>();
    public Seller seller;
    public String information;
    public Product(String name, double price, int inventory, Seller seller, String information, Category category) {
        super(category.category.name);
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.seller = seller;
        this.information = information;
        this.category.products.add(this);
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getInventory() {
        return inventory;
    }
    public ArrayList<String> getComments() {
        return comments;
    }
    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + inventory);
        System.out.println("Information: " + information);
        System.out.println("Comments: " + comments);
        System.out.println("Category: " + category.getName());
    }
    public void displayComments() {
        for (String string : this.comments){
            System.out.println(string);
        }
    }
    public void addComment(String comment) {
        comments.add(comment);
    }
}
