import java.util.ArrayList;


public class Hand {

	/** The hand. */
	public ArrayList<Card> hand;
	
	
	/**
	 * Instantiates a new hand.
	 */
	public Hand(){
		this.hand = new ArrayList<Card>();
	}
	
	
	/**
	 * Gets the hand.
	 *
	 * @return the hand
	 */
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	/**
	 * Adds the given card 
	 * to the hand.
	 *
	 * @param card 
	 * 			the card
	 */
	public void addCardToHand(Card card){
		this.hand.add(card);
	}
	
	/**
	 * Gets the array List
	 * of card names in hand.
	 *
	 * @return the  array List of
	 * 			 card names
	 */
	public ArrayList<String> getCardNames(){
		ArrayList<String> retArray = new ArrayList<String>();
			for(Card c : this.hand){
				retArray.add(c.toString());
	        }
		return retArray;
	}
	
	/**
     * returns the string
     * representation of the Hand
     */
    public String toString() {
        String retString = "";
        for(Card c : this.hand){
        	retString += c.toString() + "\n";
        }
        return retString;
    }

	
}
