import java.util.ArrayList;
import java.util.Arrays;


public class Card {
	
    private final Suite cardSuite;

    private final String cardType;
    
    private final int cardValue;
   
    private final ArrayList<String> validCardTypeList = new ArrayList<String>(Arrays.asList("2","3","4","5","6","7","8","9","10","a","j","k","q")); 
    
    // Representation invariant: 
    // cardSuite != null
    // cardType != null
    // cardType present in valid card types
    
       
    /**
     * Instantiates a new card and 
     * automatically assigns the card
     * a value depending on the card Type.
     *
     * @param cardSuite the card suite
     * @param cardType the card type
     */
    public Card(Suite cardSuite, String cardType) {
        this.cardSuite = cardSuite;
        
        this.cardType = cardType;
        
        if(this.cardType == "k" || this.cardType == "j" || this.cardType == "q"){
        	this.cardValue = 10;
        }
        else if(this.cardType == "a"){
        	this.cardValue = 11;
        }
        else{
        	this.cardValue = Integer.parseInt(this.cardType.trim());
        }
        
        checkRep();
    }
    

    /**
     * Gets the card suite.
     *
     * @return the suite
     */
    public Suite getSuite() {
        return this.cardSuite;
    }
    
    
    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public String getCardType(){
    	return this.cardType;
    }
    
    /**
     * Gets the card value.
     *
     * @return the card value
     */
    public int getCardValue(){
    	return this.cardValue;
    }
    
    
    /**
     * Checks the representation
     * of the Card.
     */
    private void checkRep() {
        assert this.cardSuite != null : "Suite of the card is null";
        assert this.cardType != null : "Type of the card is null";
        assert this.validCardTypeList.contains(this.cardType) : "Invalid Card type. " + this.cardType;
    }
    
    /**
     * returns the string
     * representation of Suite
     */
    public String toString() {
        return this.cardSuite.toString() + "-" + this.getCardType();
    }

}
