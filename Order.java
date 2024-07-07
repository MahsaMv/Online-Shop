import java.util.ArrayList;
public class Order {
    public double totalPrice;
    User user;
    public static ArrayList<Order> orders = new ArrayList<>();

    public Order(User user, double totalPrice){
        this.user = user;
        this.totalPrice = totalPrice;
        orders.add(this);
    }
    public static void displayOrders(){
        int i = 1;
        for (Order order : Order.orders){
            System.out.println(i + ". " + order.user.username + ": $" + order.totalPrice);
            i += 1;
        }
    }
}