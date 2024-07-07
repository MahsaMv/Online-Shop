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
    public boolean acceptOrder(Order order) {
        for (Product product : order.user.cart.keySet()) {
            if (product.inventory >= order.user.cart.get(product)) {
                product.inventory -= order.user.cart.get(product);
            } else {
                System.out.println("Not enough stock!");
                return false;
            }
        }
        order.user.wallet.balance -= order.totalPrice;
        order.user.wallet.balance -= order.totalPrice;
        for (Product product : order.user.cart.keySet()){
            product.seller.wallet.balance += order.user.cart.get(product) * product.price * 0.9;
            Shop.totalProfit += order.user.cart.get(product) * product.price * 0.1;
        }
        order.user.bought.putAll(order.user.cart);
        order.user.cart.clear();
        return true;
    }
}
