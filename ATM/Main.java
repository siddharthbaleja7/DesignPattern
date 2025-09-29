public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM System!");
        
        ATM atm = ATM.getInstance();
        Card card = new Card("1111222233334444", "Sid");
        
        System.out.println("SUCCESSFUL WITHDRAWAL");
        atm.insertCard(card);
        atm.enterPin(1234);
        atm.selectTransaction(TransactionType.WITHDRAW, 180);
        atm.ejectCard();

        System.out.println("FAILED AUTHENTICATION");
        atm.insertCard(card);
        atm.enterPin(9999);
        atm.ejectCard();

        System.out.println("INSUFFICIENT FUNDS");
        atm.insertCard(card);
        atm.enterPin(1234);
        atm.selectTransaction(TransactionType.WITHDRAW, 5000);
        atm.ejectCard();
    }
}
