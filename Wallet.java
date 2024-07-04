public class Wallet {
    private double balance;
    public Wallet (double balance){
        this.balance = 0.0;
    }
    public double getBalance(){
        return balance;
    }
    public void addFund (double fund){
        this.balance += fund;
    }
    public void displayBalance(){
        System.out.println(balance);
    }
}