import java.util.Scanner;
public class RegisterService {
    public Shop shop = new Shop("MyShop", "www.myshop.com","1234567890");
    public void registerUser(String username, String password, String email, String phoneNumber, String address, Permission permission) {
        User user = new User(username, password, email, phoneNumber, address);
        Shop.accounts.add(user);
        System.out.println("Welcome! " + username);
    }
    public void registerSeller(String username, String password, String companyName, Permission permission) {
        Seller seller = new Seller(username, password, companyName);
        Shop.accounts.add(seller);
        System.out.println("Welcome! " + username);
    }
}
