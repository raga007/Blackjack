
public class Deck {

	public static Card[] deck = new Card[52];

	public static void main(String[] args){
		System.out.println(new Deck().getRandomCard().toString());
	}


	/**
	 * Instantiates a new deck of 
	 * 52 cards consisting of 4 suites
	 * each containing 13 cards.
	 */
	public Deck(){
		Card[] cardSet = new Card[52];

		// clubs
		for(int i=0;i <9;i++){
			cardSet[i] = new Card(new Suite("clubs"), String.valueOf(i+2));
		}
		cardSet[9] = new Card(new Suite("clubs"), "k");
		cardSet[10] = new Card(new Suite("clubs"), "q");
		cardSet[11] = new Card(new Suite("clubs"), "j");
		cardSet[12] = new Card(new Suite("clubs"), "a");

		//diamonds
		for(int i=0;i <9;i++){
			cardSet[i + 13] = new Card(new Suite("diamonds"), String.valueOf(i+2));
		}
		cardSet[22] = new Card(new Suite("diamonds"), "k");
		cardSet[23] = new Card(new Suite("diamonds"), "q");
		cardSet[24] = new Card(new Suite("diamonds"), "j");
		cardSet[25] = new Card(new Suite("diamonds"), "a");

		//hearts
		for(int i=0;i <9;i++){
			cardSet[i + 26] = new Card(new Suite("hearts"), String.valueOf(i+2));
		}
		cardSet[35] = new Card(new Suite("hearts"), "k");
		cardSet[36] = new Card(new Suite("hearts"), "q");
		cardSet[37] = new Card(new Suite("hearts"), "j");
		cardSet[38] = new Card(new Suite("hearts"), "a");

		//spade
		for(int i=0;i <9;i++){
			cardSet[i + 39] = new Card(new Suite("spades"), String.valueOf(i+2));
		}
		cardSet[48] = new Card(new Suite("spades"), "k");
		cardSet[49] = new Card(new Suite("spades"), "q");
		cardSet[50] = new Card(new Suite("spades"), "j");
		cardSet[51] = new Card(new Suite("spades"), "a");

		this.deck = cardSet;
	}

	
	/**
	 * Gets the random integer in
	 * the given range.
	 *
	 * @param min 
	 * 			the minimum value
	 * @param max 
	 * 			the maximum value
	 * @return the random integer 
	 * 			in the given range
	 */
	private static int getRandomIntegerInRange(int min,int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}

	
	/**
	 * Gets the random card
	 * from the existing deck 
	 * of cards.
	 *
	 * @return the random card
	 */
	public static Card getRandomCard(){
		return Deck.deck[getRandomIntegerInRange(0,51)];
	}
	
	
	/**
     * returns the string
     * representation of the Deck
     */
    public String toString() {
        String retString = "";
        for(int i=0; i< Deck.deck.length;i++){
        	retString += Deck.deck[i].toString() + "\n";
        }
        return retString;
    }
    
}
