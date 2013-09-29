
public class Player {

	/** The player name. */
	private final String playerName;
	
	/** The player hand. */
	private Hand playerHand;
	
	/** The boolean representing human player or computer. */
	private final boolean isComputer;
	
	/** The boolean representing dealer. */
	private final boolean isDealer;
	
	
	/**
	 * Instantiates a new player
	 * with a hand without any cards.
	 *
	 * @param playerName 
	 * 				the player name
	 * @param isComputer 
	 * 					The boolean representing
	 * 					human player or computer
	 * 					true if player is a computer
	 * @param isDealer 
	 * 					the boolean deciding if
	 * 					this player is a dealer.
	 * 					true if this player is 
	 * 					a dealer.
	 */
	public Player(String playerName,boolean isComputer,boolean isDealer){
		this.isComputer = isComputer;
		this.playerName = playerName;
		this.isDealer = isDealer;
		this.playerHand = new Hand();
	}
	
	
	
	/**
	 * Instantiates a new player
	 * assuming that the player is
	 * not a dealer.
	 *
	 * @param playerName 
	 * 				the player name
	 * @param isComputer 
	 * 					The boolean representing
	 * 					human player or computer
	 * 					true if player is a computer
	 * 
	 */
	public Player(String playerName,boolean isComputer){
		this(playerName,isComputer,false);
	}
	
	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName(){
		return this.playerName;
	}
	
	/**
	 * Gets the player hand.
	 *
	 * @return the player hand
	 */
	public Hand getPlayerHand(){
		return this.playerHand;
	}
	
	/**
	 * Checks if player is a computer.
	 *
	 * @return true, if player is a computer
	 */
	public boolean isComputer(){
		return this.isComputer;
	}
	
	/**
	 * Checks if player is the dealer.
	 *
	 * @return true, if player is the dealer
	 */
	public boolean isDealer(){
		return this.isDealer;
	}
	
	/**
     * returns the string
     * representation of the Player
     */
    public String toString() {
        return this.playerName;
    }
}
