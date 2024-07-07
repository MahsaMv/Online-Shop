import java.util.ArrayList;
public class WalletService {
    public User requester;
    public double fund;
    public static ArrayList<WalletService> fundRequests;
    public WalletService(User requester, double fund){
        this.requester = requester;
        this.fund = fund;
        this.fundRequests = new ArrayList<>();
    }
    public static void displayFundRequests() {
        int i = 1;
        for (WalletService wallet : WalletService.fundRequests){
            System.out.println(i + ". " + wallet.requester.username);
            i += 1;
        }
    }
}
