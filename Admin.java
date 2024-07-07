public class Admin extends Account {
    public Admin(String username, String password, String email) {
        super(username, password, email, null, null, Permission.ADMIN);
    }
    public void acceptSellRequests(Request request) {
        request.seller.permissionToSell = true;
    }
    public void acceptFundRequests(WalletService wallet) {
        wallet.requester.wallet.balance += wallet.fund;
    }
    public void addFundToWallet(WalletService wallet){
        //wallet.requester.wallet.balance += wallet.fund;
    }
    public void acceptOrder(Order order){
        order.user.wallet.balance -= order.totalPrice;
        for (Product product : order.user.cart.keySet()){
            if(product.inventory >= order.user.cart.get(product)) {
                product.inventory -= order.user.cart.get(product);
            }
            else {
                System.out.println("Not enough stock!");
            }
        }
    }
}
