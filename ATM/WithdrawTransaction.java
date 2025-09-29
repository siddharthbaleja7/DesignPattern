public class WithdrawTransaction implements Transaction {
    private final CashDispenser cashDispenser;
    private final Printer printer;

    public WithdrawTransaction(CashDispenser cashDispenser, Printer printer) {
        this.cashDispenser = cashDispenser;
        this.printer = printer;
    }

    @Override
    public void execute(User user, double amount) {
        System.out.println("Executing withdrawal of $" + amount);
        if (user.getAccount().withdraw(amount)) {
            cashDispenser.dispenseCash((int)amount);
            printer.printReceipt("Withdrew: $" + amount + "\nNew Balance: $" + user.getAccount().getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            printer.printReceipt("Withdrawal failed for $" + amount);
        }
    }
}