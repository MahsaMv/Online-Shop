import java.util.Scanner;
public class Main {
    public static RegisterService registerService;
    public static LoginService loginService;
    public static Account currentAccount;

    public static void main(String[] args) {
        Shop shop = createShop();
        System.out.printf(shop.toString());
        mainMenu();
    }
    private static Shop createShop() {
        return new Shop("MyShop", "www.myshop.com", "1234567890");
    }
    private static void mainMenu (){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Register ");
            System.out.println("2. Login ");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 1){
                System.out.println("1. Register as user");
                System.out.println("2. Register as seller");
                System.out.print("Enter your choice: ");
                int choice2 = sc.nextInt();

                if (choice2 == 1){
                    System.out.println("\n=== Register ===");
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    System.out.println("Email: ");
                    String email = sc.next();
                    System.out.println("Phone number: ");
                    String phoneNumber = sc.next();
                    System.out.println("Address: ");
                    String address = sc.next();
                    RegisterService registerService = new RegisterService();
                    registerService.registerUser(username, password, email, phoneNumber, address, Permission.USER);
                }
                if (choice2 == 2){
                    System.out.println("\n=== Register===");
                    System.out.println("Username: ");
                    String username = sc.next();
                    System.out.println("Password: ");
                    String password = sc.next();
                    System.out.println("Company name: ");
                    String companyName = sc.next();
                    RegisterService registerService = new RegisterService();
                    registerService.registerSeller(username, password, companyName, Permission.SELLER);
                }
            }
            if (choice == 2){
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                LoginService loginService = new LoginService();
                currentAccount = loginService.login(username, password);
                //loginService.checkPermission(currentAccount);
                System.out.println("Welcome" + currentAccount.getUsername() + "!");
                System.out.println(currentAccount.getPermission());

                if (currentAccount instanceof Admin) {
                    //adminMenu();
                }
                if (currentAccount instanceof Seller) {
                    //sellerMenu();
                }
                if (currentAccount instanceof User) {
                    System.out.println("\n=== User Menu ===");
                    System.out.println("Your balance: ");
                    System.out.println("1. Edit profile \n2. Add fund \n3. See products\n4. Cart \n5. Log out ");
                    System.out.print("Enter your choice: ");
                    int choice3 = sc.nextInt();
                    if (choice3 == 1){
                        String newUsername = sc.next();
                        String newPassword = sc.next();
                        String newEmail = sc.next();
                        String newPhoneNumber = sc.next();
                        String newAddress = sc.next();
                        //Account currentAccount = new Account(username, password, null, null, null, Permission.USER);
                        currentAccount.editProfile(newUsername, newPassword, newEmail, newPhoneNumber, newAddress);
                    }
                    if (choice3 == 2){
                        double fund = sc.nextDouble();
                        Wallet wallet = new Wallet(0.0);
                        wallet.addFund(fund);
                    }
                    if (choice3 == 3){

                    }
                    if (choice3 == 4){

                    }


                    //userMenu();
                }

                /*for login pls enter user and pass
                String accountType = "Admin";
                user type
                pls enter username
                pls enter pass
                Account currentAccount = new Admin();
                loginService.login();*/
            }
        }
    }
    private static void adminMenu(Scanner sc, Admin admin) {
        System.out.println("Admin Menu");
        // Add admin-specific options and functionality here
    }

    private static void userMenu(Scanner sc, User user) {
        System.out.println("User Menu");
        // Add user-specific options and functionality here
    }

    private static void sellerMenu(Scanner sc, Seller seller) {
        System.out.println("Seller Menu");
        // Add seller-specific options and functionality here
    }
}