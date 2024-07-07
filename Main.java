import java.util.Scanner;
public class Main {
    //public static RegisterService registerService;
    //public static LoginService loginService;
    public static Account currentAccount;
    //public static Seller seller;

    public static void main(String[] args) {
        Shop shop = createShop();
        System.out.printf(shop.toString());
        mainMenu();
    }
    private static Shop createShop() {
        return new Shop("MyShop", "www.myshop.com", "1234567890");
    }
    private static void initializeShop() {
        Admin admin = new Admin("admin", "123456", "admin@myshop.com");
        Shop shop = new Shop("MyShop", "www.myshop.com", "1234567890");

        shop.getAccounts().add(admin);

        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");
        Category books = new Category("Books");
        Category homeAppliances = new Category("Home Appliances");
        Category beauty = new Category("Beauty");

        shop.addCategory(electronics);
        shop.addCategory(clothing);
        shop.addCategory(books);
        shop.addCategory(homeAppliances);
        shop.addCategory(beauty);

        Product phone = new Product("iPhone", 999.99, 10, electronics);
        electronics.addProduct(phone);

        Product laptop = new Product("MacBook", 1299.99, 5, electronics);
        electronics.addProduct(laptop);

        Product shirt = new Product("Shirt", 29.99, 20, clothing);
        clothing.addProduct(shirt);
    }
    private static void mainMenu (){
        while (true){
            while (currentAccount == null){
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
            if (choice == 2) {
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                LoginService loginService = new LoginService();
                currentAccount = loginService.login(username, password);
                //loginService.checkPermission(currentAccount);
                System.out.println("Welcome" + currentAccount.getUsername() + "!");
                System.out.println(currentAccount.getPermission());
            }
                while (currentAccount instanceof Admin) {
                    System.out.println("\n=== Admin Menu ===");
                    System.out.println("1. Promote to admin \n2. Add fund to wallet \n3. Accept fund requests \n4. Orders \n5. Sell requests \n6. Log out");
                    int choice4 = sc.nextInt();
                    if (choice4 == 1){
                        System.out.println("Enter the username: ");
                        String username = sc.next();
                        Account newAdmin = Shop.findAccount(username);
                        new Admin(newAdmin.username, newAdmin.password, newAdmin.email);
                        Shop.accounts.remove(newAdmin);
                    }

                    if (choice4 == 2){
                        System.out.println("Enter the username: ");
                        String username = sc.next();
                        System.out.println("Enter the amount: ");
                        double amount = sc.nextDouble();
                        Shop.findAccount(username).wallet.balance += amount;
                        System.out.println("Amount has been added to wallet successfully!");
                    }

                    // fund requests
                    if (choice4 == 3){
                        WalletService.displayFundRequests();
                        int subChoice = sc.nextInt();
                        ((Admin) currentAccount).acceptFundRequests(WalletService.fundRequests.get(subChoice - 1));
                        WalletService.fundRequests.remove(subChoice - 1);
                    }

                    // orders
                    if (choice4 == 4){
                        Order.displayOrders();
                        int subChoice = sc.nextInt();
                        ((Admin) currentAccount).acceptOrder(Order.orders.get(subChoice - 1));
                        Order.orders.remove(subChoice - 1);
                    }

                    // certificates
                    if (choice4 == 5){
                        Request.displaySellRequests();
                        int subChoice = sc.nextInt();
                        ((Admin) currentAccount).acceptSellRequests(Request.sellRequests.get(subChoice - 1));
                        Request.sellRequests.remove(subChoice - 1);
                    }

                    // logout
                    if (choice4 == 6){
                        currentAccount = null;
                    }







                    //adminMenu();
                }
                while (currentAccount instanceof Seller) {
                    System.out.println("\n=== Seller Menu ===");
                    System.out.println("1. Edit profile \n2. Available products \n3. Log out");
                    int choice3 = sc.nextInt();
                    if (choice3 == 1){
                        String newUsername = sc.next();
                        String newPassword = sc.next();
                        String newCompanyName = sc.next();
                        currentAccount.editSellerProfile(newUsername, newPassword, newCompanyName);
                    }
                    if (choice3 == 2 && ((Seller) currentAccount).permissionToSell) {
                        ((Seller)currentAccount).displayAvailableProducts();
                        System.out.println("1. Add product");
                        System.out.println("2. Remove product");
                        int choice4 = sc.nextInt();
                        if (choice4 == 1){
                            System.out.println("Product name: ");
                            String name = sc.next();
                            System.out.println("Product price: ");
                            double price = sc.nextInt();
                            System.out.println("Product quantity: ");
                            int inventory = sc.nextInt();
                            System.out.println("Product category: ");
                            String category = sc.next();
                            Category category1 = Category.findCategory(category);
                            ((Seller)currentAccount).addProduct(new Product(name, price, inventory, category1));
                        }
                        if (choice4 == 2){
                            int index = 1;
                            for (Product product : ((Seller) currentAccount).availableProducts){
                                System.out.println(index + ". " + product.name + " $" + product.price);
                                index += 1;
                            }
                            int subChoice = sc.nextInt();
                            if (((Seller) currentAccount).availableProducts.get(subChoice - 1).inventory > 1){
                                ((Seller) currentAccount).availableProducts.get(subChoice - 1).inventory -= 1;
                            }
                            else {
                                ((Seller) currentAccount).availableProducts.get(subChoice - 1).category.products.remove(((Seller) currentAccount).availableProducts.get(subChoice - 1));
                                ((Seller) currentAccount).availableProducts.remove(subChoice - 1);
                            }
                        }





                    }
                    if (choice3 == 3){
                        currentAccount = null;
                        break;
                    }
                    //sellerMenu();
                }
                while (currentAccount instanceof User) {
                    //TODO show balance
                    System.out.println("\n=== User Menu ===");
                    System.out.println("Your balance: ");
                    System.out.println("1. Edit profile \n2. Add fund \n3. See products\n4. Search product \n5. Cart \n6. Log out ");
                    System.out.print("Enter your choice: ");
                    int choice3 = sc.nextInt();
                    if (choice3 == 1){
                        String newUsername = sc.next();
                        String newPassword = sc.next();
                        String newEmail = sc.next();
                        String newPhoneNumber = sc.next();
                        String newAddress = sc.next();
                        currentAccount.editUserProfile(newUsername, newPassword, newEmail, newPhoneNumber, newAddress);
                    }
                    if (choice3 == 2){
                        System.out.println("Enter amount to add to wallet: ");
                        double fund = sc.nextDouble();
                        new WalletService((User) currentAccount, fund);
                    }
                    // TODO search product and add to cart and buy
                    if (choice3 == 3){
                        initializeShop();
                        int i = 1;
                        for (Category category : Shop.categories){
                            System.out.println(i + ". " + category.name);
                            i += 1;
                        }
                        System.out.println("Choose the category: ");
                        int subChoice = sc.nextInt();
                        i = 1;
                        for (Product product : Shop.categories.get(subChoice - 1).products){
                            System.out.println(i + ". " + product.name + " $" + product.price);
                                i += 1;
                        }
                        int subChoice2 = sc.nextInt();
                        Shop.categories.get(subChoice - 1).products.get(subChoice2 - 1).displayProduct();
                        Shop.categories.get(subChoice - 1).products.get(subChoice2 - 1).displayComments();

                        System.out.println("1. Buy \n2. Back");
                        int subChoice3 = sc.nextInt();
                        if (subChoice3 == 1){
                            ((User) currentAccount).addToCart(Shop.categories.get(subChoice - 1).products.get(subChoice2 - 1));
                        }
                        if (subChoice3 == 2){
                            //TODO back
                        }

                    }
                    if (choice3 == 4){
                        System.out.println("Search: ");
                        String name = sc.next();
                        Product searchedProduct = Shop.searchProduct(name);
                        searchedProduct.displayProduct();
                        searchedProduct.displayComments();
                        System.out.println("1. Buy \n2. Back");
                        int choice5 = sc.nextInt();
                        if (choice5 == 1){
                            ((User) currentAccount).addToCart(searchedProduct);
                        }
                        if (choice5 == 2){
                            // TODO back
                        }
                    }
                    if (choice3 == 5){
                        double totalPrice = ((User)currentAccount).displayCart();
                        System.out.println("1 - Buy \n2 - Back");
                        int choice5 = sc.nextInt();
                        if (choice5 == 1){
                            if (currentAccount.wallet.balance > totalPrice){
                                new Order((User) currentAccount, totalPrice);
                            }
                            else {
                                System.out.println("Not enough balance");
                            }
                        }
                        if (choice5 == 2){
                            //TODO back
                        }
                    }

                    if (choice3 == 6){
                        currentAccount = null;
                        break;
                    }


                    //userMenu();
                }
            }
        }
    }
    private static void adminMenu(Scanner sc, Admin admin) {
        System.out.println("Admin Menu");
    }

    private static void userMenu(Scanner sc, User user) {
        System.out.println("User Menu");
    }

    private static void sellerMenu(Scanner sc, Seller seller) {
        System.out.println("Seller Menu");
    }
}
