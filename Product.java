import java.util.ArrayList;
public class Product {
    public String name;
    public double price;
    public int inventory;
    private ArrayList<String> comments;
    public Category category;

    public Product(String name, double price, int inventory, Category category) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
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
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + "$" + price);
        System.out.println("Quantity: " + inventory);
        System.out.println("Comments: " + comments);
        System.out.println("Category: " + category.getName());
    }
    public void displayComments() {
        for (String string : this.comments){
            System.out.println(string);
        }
    }

    public void reduceQuantity(int amount) {
        if (amount <= inventory)
            inventory -= amount;
    }
//TODO write this
    public void addComment(String comment) {
        comments.add(comment);
    }
}
