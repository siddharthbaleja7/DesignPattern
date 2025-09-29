public class BalanceInquiry implements Transaction {
    private final Printer printer;

    public BalanceInquiry(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute(User user, double amount) {
        System.out.println("Executing balance inquiry.");
        double balance = user.getAccount().getBalance();
        System.out.println("Current Balance: $" + balance);
        printer.printReceipt("Your current balance is: $" + balance);
    }
}