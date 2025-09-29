public class ChangePinTransaction implements Transaction {
    private final Printer printer;
    private final Keypad keypad;
    private final ATM atm;

    public ChangePinTransaction(ATM atm, Keypad keypad, Printer printer) {
        this.atm = atm;
        this.keypad = keypad;
        this.printer = printer;
    }

    @Override
    public void execute(User user, double newPin) {
        System.out.println("Executing PIN change.");
        int pin = (int) newPin;
        atm.getBankService().changePin(atm.getCurrentCard(), pin);
        printer.printReceipt("Your PIN has been successfully changed.");
    }
}