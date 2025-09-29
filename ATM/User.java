public class User {
    private final String name;
    private final BankAccount account;

    public User(String name, BankAccount account) {
        this.name = name;
        this.account = account;
    }

    public BankAccount getAccount() {
        return account;
    }
}