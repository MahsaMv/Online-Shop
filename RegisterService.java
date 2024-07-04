import java.util.Scanner;
public class RegisterService {
    public Shop shop = new Shop("MyShop", "www.myshop.com","1234567890");
    public void registerUser(String username, String password, String email, String phoneNumber, String address, Permission permission) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Register ===");
        System.out.println("Username: ");
        username = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        System.out.println("Email: ");
        email = sc.nextLine();
        System.out.println("Phone number: ");
        phoneNumber = sc.nextLine();
        System.out.println("Address: ");
        address = sc.nextLine();*/
        User user = new User(username, password, email, phoneNumber, address);
        //shop.addAccount(user);

        //Ashkan
        //Askhan
        //Askhan
        Shop.accounts.add(user);
        System.out.println("Welcome! " + username);
    }
    public void registerSeller(String username, String password, String companyName, Permission permission) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Register as entity.Seller ===");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        System.out.println("Company name: ");
        String companyName = sc.nextLine();*/
        Seller seller = new Seller(username, password, companyName);
        //shop.addAccount(seller);
        Shop.accounts.add(seller);
        System.out.println("Welcome! " + username);
    }
}
