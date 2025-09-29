public class DepositTransaction implements Transaction {
    private final DepositSlot depositSlot;
    private final Printer printer;

    public DepositTransaction(DepositSlot depositSlot, Printer printer) {
        this.depositSlot = depositSlot;
        this.printer = printer;
    }

    @Override
    public void execute(User user, double amount) {
        System.out.println("Executing deposit of $" + amount);
        depositSlot.receiveDeposit();
        user.getAccount().deposit(amount);
        printer.printReceipt("Deposited: $" + amount + "\nNew Balance: $" + user.getAccount().getBalance());
    }
}