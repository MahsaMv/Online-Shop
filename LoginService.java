import java.util.ArrayList;
public class LoginService {
    //private Shop shop = new Shop("Myshop", "www.MyShop.com", "1234567890");
//    public LoginService(Shop shop) {
//        this.shop = shop;
//    }

    public Account login(String username, String password) {
        for (Account account : Shop.accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
//    public void checkPermission(Account currentAccount) {
//        switch (currentAccount.getPermission()) {
//            case ADMIN:
//                System.out.println("You have admin access.");
//                break;
//            case USER:
//                System.out.println("You have user access.");
//                break;
//            case SELLER:
//                System.out.println("You have seller access.");
//                break;
//            default:
//                System.out.println("Unknown access level.");
//                break;
//        }
//    }
}
