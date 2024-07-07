import java.util.ArrayList;
public class Product extends Category {
    public String name;
    public double price;
    public int inventory;
    private ArrayList<String> comments;
    public Seller seller;
    public String information;
    public Product(String name, double price, int inventory, Seller seller, String information, Category category) {
        super(category.category.name);
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.comments = new ArrayList<>();
        //this.category = category;
        this.seller = seller;
        this.category.products.add(this);
        this.information = information;
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
