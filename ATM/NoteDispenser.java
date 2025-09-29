public abstract class NoteDispenser {
    protected NoteDispenser nextDispenser;
    protected int denomination;

    public void setNextDispenser(NoteDispenser next) {
        this.nextDispenser = next;
    }

    public void dispense(int amount) {
        if (amount >= denomination) {
            int numNotes = amount / denomination;
            int remainder = amount % denomination;
            System.out.println("Dispensing " + numNotes + " x $" + denomination + " note(s)");
            if (remainder != 0 && nextDispenser != null) {
                nextDispenser.dispense(remainder);
            }
        } else if (nextDispenser != null) {
            nextDispenser.dispense(amount);
        }
    }
}