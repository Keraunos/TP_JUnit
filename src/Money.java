
/**
 * 
 * @author mservier
 * 
 * Money Class - simple class to learn how to use JUnit
 */
public class Money {
	
    /**
     * represents the amount by an int
     */
    private int fAmount;
    
    /**
     * represents a currency as a string holding the ISO three letter abbreviation (USD, CHF, etc.)
     */
    private String fCurrency;
    
    /**
     * Constructor
     * @param amount
     * @param currency
     */
    public Money(int amount, String currency) {
        fAmount= amount;
        fCurrency= currency;
    }

    /**
     * Accessor on fAmount.
     * @return an int
     */
    public int amount() {
        return fAmount;
    }

    /**
     * Accessor on fCurrency.
     * @return a String
     */
    public String currency() {
        return fCurrency;
    }
    
    /**
     * When you add two Moneys of the same currency, the resulting Money has as its amount the sum of the other two amounts.
     * @param m
     * @return a Money Object
     */
    public Money add(Money m) {
        return new Money(amount()+m.amount(), currency());
    }
    
    /**
     * Verify that Monies are equal when they have the same value but are not the same object
     */
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money aMoney= (Money)anObject;
            return aMoney.currency().equals(currency())
                && amount() == aMoney.amount();
        }
        return false;
    }
}