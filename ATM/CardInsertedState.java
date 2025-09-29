public class CardInsertedState implements ATMState {

    @Override
    public void enterPin(ATM atm, int pin) {
        BankService bankService = atm.getBankService();
        User user = bankService.authenticate(atm.getCurrentCard(), pin);

        if (user != null) {
            atm.setCurrentUser(user);
            atm.setState(new AuthenticatedState());
            System.out.println("Authentication successful. State changed to: AuthenticatedState.");
            System.out.println("Welcome, " + user.getAccount().getAccountNumber() + ". Please select a transaction.");
        } else {
            System.out.println("Authentication failed: Incorrect PIN.");
            atm.getPrinter().printReceipt("Authentication failed. Please try again.");
            ejectCard(atm);
        }
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected. Thank you for using our ATM.");
        atm.setCurrentCard(null);
        atm.setCurrentUser(null);
        atm.setState(new IdleState());
        System.out.println("State changed to: IdleState.");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("A card is already inserted. Please eject the current card first.");
    }

    @Override
    public void selectTransaction(ATM atm, TransactionType type, double amount) {
        System.out.println("Please enter your PIN first to proceed with a transaction.");
    }
}