import java.util.ArrayList;

public class Category{
    private String name;
    private ArrayList<String> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public ArrayList<String> getProducts() {
        return products;
    }

    public void addProduct(String product) {
        products.add(product);

    }
}