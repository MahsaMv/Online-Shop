public class LoginService {
    public Account login(String username, String password) {
        for (Account account : Shop.accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
