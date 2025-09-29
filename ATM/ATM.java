public class ATM {
    private static final ATM instance = new ATM();

    private ATMState currentState;
    private final CardReader cardReader;
    private final Keypad keypad;
    private final CashDispenser cashDispenser;
    private final Printer printer;
    private final DepositSlot depositSlot;
    private final BankService bankService;
    
    private User currentUser;
    private Card currentCard;

    private ATM() {
        this.currentState = new IdleState();
        this.cardReader = new CardReader();
        this.keypad = new Keypad();
        this.cashDispenser = new CashDispenser();
        this.printer = new Printer();
        this.depositSlot = new DepositSlot();
        this.bankService = new BankService();
    }

    public static ATM getInstance() {
        return instance;
    }
    
    public void insertCard(Card card) {
        currentState.insertCard(this, card);
    }
    
    public void enterPin(int pin) {
        currentState.enterPin(this, pin);
    }
    
    public void selectTransaction(TransactionType type, double amount) {
        currentState.selectTransaction(this, type, amount);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }

    public void setState(ATMState state) { 
        this.currentState = state; 
    }
    public CardReader getCardReader() { 
        return cardReader; 
    }
    public BankService getBankService() { 
        return bankService; 
    }
    public void setCurrentUser(User user) { 
        this.currentUser = user; 
    }
    public User getCurrentUser() { 
        return currentUser; 
    }
    public void setCurrentCard(Card card) { 
        this.currentCard = card; 
    }
    public Card getCurrentCard() { 
        return currentCard; 
    }
    public Printer getPrinter() { 
        return printer; 
    }

    public void executeTransaction(TransactionType type, double amount) {
        Transaction transaction;
            switch(type) {
                case WITHDRAW:
                transaction = new WithdrawTransaction(cashDispenser, printer);
                break;

            case DEPOSIT:
                transaction = new DepositTransaction(depositSlot, printer);
                break;
            case BALANCE_INQUIRY:
                transaction = new BalanceInquiry(printer);
                break;
                
            case CHANGE_PIN:
                transaction = new ChangePinTransaction(this, keypad, printer);
                break;

            default:
                System.out.println("Transaction type not supported.");
                printer.printReceipt("Error: Selected transaction is not available.");
                return;
            }
        transaction.execute(this.currentUser, amount);
    }
}  
