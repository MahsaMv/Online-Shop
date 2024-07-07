import java.util.ArrayList;
public class Order {
    public double totalPrice;
    User user;
    public Order(User user, double totalPrice){
        this.user = user;
        this.totalPrice = totalPrice;
        Shop.orders.add(this);
    }
    public static void displayOrders(){
        int i = 1;
        for (Order order : Shop.orders){
            System.out.println(i + ". " + order.user.username + ": $" + order.totalPrice);
            i += 1;
        }
    }
}