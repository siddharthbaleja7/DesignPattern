import java.util.*;
public class BankService {
    private Map<String, User> userDatabase;
    private Map<String, Integer> pinDatabase;

    public BankService() {
        userDatabase = new HashMap<>();
        pinDatabase = new HashMap<>();
        
        BankAccount acc1 = new BankAccount("123456789", 50.0);
        User user1 = new User("Sid", acc1);
        userDatabase.put("1111222233334444", user1);
        pinDatabase.put("1111222233334444", 1234);
    }
    
    public User authenticate(Card card, int pin) {
        if (pinDatabase.containsKey(card.getCardNumber()) && pinDatabase.get(card.getCardNumber()) == pin) {
            return userDatabase.get(card.getCardNumber());
        }
        return null;
    }

    public void changePin(Card card, int newPin) {
        pinDatabase.put(card.getCardNumber(), newPin);
        System.out.println("PIN changed successfully for card: " + card.getCardNumber());
    }
}
