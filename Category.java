import java.util.ArrayList;
public class Category{
    public String name;
    public ArrayList<Product> products;
    public Category category;
    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.category = this;
        if (Shop.categories.size() < 5) {
            Shop.categories.add(this);
        }
    }
    public Category(){

    }
    public String getName() {
        return name;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public static Category findCategory(String name){
        for (Category category : Shop.categories){
            if (category.name.equals(name)){
                return category;
            }
        }
        return null;
    }
}
