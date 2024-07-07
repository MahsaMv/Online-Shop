public class Account {
    public String username;
    public String password;
    public String email;
    private String phoneNumber;
    private String address;
    public Wallet wallet = new Wallet(0.0);
    private Permission permission;

    public Account(String username, String password, String email, String phoneNumber, String address, Permission permission) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.permission = permission;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCompanyName(String companyName){

    }
    public Permission getPermission() {
        return permission;
    }
    public boolean login(String password) {
        return this.password.equals(password);
    }

    public void editUserProfile(String username, String password, String email, String phoneNumber, String address) {
        if (!username.isEmpty()) {
            setUsername(username);
        }
        if (!password.isEmpty()) {
            setPassword(password);
        }
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        System.out.println("Profile updated successfully!");
    }

    public void editSellerProfile(String username, String password, String companyName) {
        if (!username.isEmpty()) {
            setUsername(username);
        }
        if (!password.isEmpty()) {
            setPassword(password);
        }
        setCompanyName(companyName);
        System.out.println("Profile updated successfully!");
    }
}
