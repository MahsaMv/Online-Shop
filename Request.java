import java.util.ArrayList;
public class Request {
    public Seller seller;
    public static ArrayList<Request> sellRequests = new ArrayList<>();
    public Request(Seller seller) {
        this.seller = seller;
        sellRequests.add(this);
    }
    public static void displaySellRequests() {
        int i = 1;
        for (Request request : Request.sellRequests){
            System.out.println(i + ". " + request.seller.companyName);
            i += 1;
        }
    }
}
