public class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {
        atm.getCardReader().readCard(card);
        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState());
        System.out.println("State changed to: CardInsertedState. Please enter your PIN.");
    }

    @Override
    public void enterPin(ATM atm, int pin) { 
        System.out.println("Please insert a card first."); 
    }
    @Override
    public void selectTransaction(ATM atm, TransactionType type, double amount) { 
        System.out.println("Please insert a card first."); 
    }
    @Override
    public void ejectCard(ATM atm) { 
        System.out.println("No card to eject."); 
    }
}