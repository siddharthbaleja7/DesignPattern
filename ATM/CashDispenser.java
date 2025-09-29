public class CashDispenser {
    private final NoteDispenser dispenserChain;

    public CashDispenser() {
        this.dispenserChain = new Dispenser50();
        NoteDispenser d20 = new Dispenser20();
        NoteDispenser d10 = new Dispenser10();

        dispenserChain.setNextDispenser(d20);
        d20.setNextDispenser(d10);
    }

    public void dispenseCash(int amount) {
        if (amount % 10 != 0) {
            System.out.println("Amount must be in multiples of 10.");
            return;
        }
        System.out.println("Dispensing cash: $" + amount);
        dispenserChain.dispense(amount);
    }
}