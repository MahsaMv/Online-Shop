import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private int inventory;
    private ArrayList<String> comments;
    private Category category;

    public Product(String name, double price, int inventory, ArrayList<String> comments, Category category) {
        this.name = name;
        this.price = 0.0;
        this.inventory = 0;
        this.comments = new ArrayList<>();
        this.category = category;
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
        System.out.println("entity.Product Name: " + name);
        System.out.println("Price: " + "$" + price);
        System.out.println("Quantity: " + inventory);
        System.out.println("Comments: " + comments);
        System.out.println("entity.Category: " + category.getName());
    }

    public void reduceQuantity(int amount) {
        if (amount <= inventory)
            inventory -= amount;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }
}