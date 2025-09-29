public class AuthenticatedState implements ATMState {

    @Override
    public void selectTransaction(ATM atm, TransactionType type, double amount) {
        System.out.println("Starting transaction of type: " + type);
        atm.executeTransaction(type, amount);
  
        System.out.println("\nTransaction complete. Please select another transaction or eject your card.");
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
        System.out.println("Error: A card is already inserted.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("Error: PIN has already been authenticated.");
    }
}