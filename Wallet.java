public class Wallet {
    public double balance;
    public Wallet (double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
//    public void addFund (double fund){
//        this.balance += fund;
//    }
    public void displayBalance(){
        System.out.println(balance);
    }
}
