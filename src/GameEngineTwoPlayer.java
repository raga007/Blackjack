import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class GameEngineTwoPlayer extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The image one. */
	private JLabel imageOne;
	
	/** The image two. */
	private JLabel imageTwo;
	
	/** The player one card list. */
	private JComboBox playerOneCardList;
	
	/** The player two card list. */
	private JComboBox playerTwoCardList;
	
	/** The player one score label. */
	private JLabel playerOneScoreLabel;
	
	/** The player two score label. */
	private JLabel playerTwoScoreLabel;
	
	/** The new game button. */
	private JButton newGame;
	
	/** The turn label. */
	private JLabel turnLabel;
	
	/** The hit button. */
	private JButton hitButton;
	
	/** The stand button. */
	private JButton standButton;
	
	/** The card deck. */
	private Deck cardDeck;

	/** The Constant SINGLE_PLAYER_MODE. */
	private static final int SINGLE_PLAYER_MODE = 1;
	
	/** The Constant DOUBLE_PLAYER_MODE. */
	private static final int DOUBLE_PLAYER_MODE = 2;

	/** The Constant PLAYER_ONE_TURN. */
	private static final int PLAYER_ONE_TURN = 1;
	
	/** The Constant PLAYER_TWO_TURN. */
	private static final int PLAYER_TWO_TURN = 2;

	private static final int PLAYER_STARTING_CASH = 100;
	
	public static int currentPlayerMoney = PLAYER_STARTING_CASH;
	
	public static int betAmount  = 0;

	/** The player one. */
	private Player playerOne = null;
	
	/** The player two. */
	private Player playerTwo = null;
	
	/** The player one name. */
	private String playerOneName = null;
	
	/** The player two name. */
	private String playerTwoName = null;
	
	/** The game mode. */
	private int gameMode = 0;
	
	/** The turn. */
	private int turn = 0;
	private JLabel lblPlayerCash;
	
	// On click of a new game button, ask the user if it
	//	is a two player or a one player game. If it is a two
	// game, who is the dealer.

	// Ask for player names etc and generate random cards
	// make sure one of the cards is upside down for the dealer.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEngineTwoPlayer frame = new GameEngineTwoPlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GameEngineTwoPlayer() throws IOException {
		cardDeck = new Deck();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getImageOne());
		contentPane.add(getImageTwo());
		contentPane.add(getPlayerOneCardList());
		contentPane.add(getPlayerTwoCardList());
		contentPane.add(getplayerOneScoreLabel());
		contentPane.add(getplayerTwoScoreLabel());
		contentPane.add(getNewGame());
		contentPane.add(getTurnLabel());
		contentPane.add(getHitButton());
		contentPane.add(getStandButton());
		contentPane.add(getLblPlayerCash());

	}

	/**
	 * Gets the image one.
	 *
	 * @return the image one
	 */
	private JLabel getImageOne() {
		if (imageOne == null) {
			imageOne = new JLabel("Choose a New Game");
			imageOne.setBorder(new LineBorder(new Color(0, 0, 0)));
			imageOne.setBackground(Color.BLACK);
			imageOne.setBounds(70, 78, 161, 229);
		}
		return imageOne;
	}



	/**
	 * Gets the image two.
	 *
	 * @return the image two
	 */
	private JLabel getImageTwo() {
		if (imageTwo == null) {
			imageTwo = new JLabel("Choose a New Game");
			imageTwo.setBorder(new LineBorder(new Color(0, 0, 0)));
			imageTwo.setBounds(396, 78, 161, 229);
		}
		return imageTwo;
	}
	
	/**
	 * Gets the player one card list.
	 *
	 * @return the player one card list
	 */
	private JComboBox getPlayerOneCardList() {
		if (playerOneCardList == null) {
			playerOneCardList = new JComboBox();
			playerOneCardList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedCardName = (String)playerOneCardList.getSelectedItem();
					try {
						setImageOne("150/" + selectedCardName + "-150.png");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			playerOneCardList.setBounds(70, 337, 161, 27);
		}
		return playerOneCardList;
	}
	
	/**
	 * Gets the player two card list.
	 *
	 * @return the player two card list
	 */
	private JComboBox getPlayerTwoCardList() {
		if (playerTwoCardList == null) {
			playerTwoCardList = new JComboBox();
			playerTwoCardList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedCardName = (String)playerTwoCardList.getSelectedItem();
					try {
						if(selectedCardName != "Face up"){
							setImageTwo("150/" + selectedCardName + "-150.png");
						}
						else {
							setImageTwo("150/back-blue-150-1.png");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			playerTwoCardList.setBounds(396, 337, 161, 27);
		}
		return playerTwoCardList;
	}
	
	/**
	 * Gets the player one score label.
	 *
	 * @return the player one score label
	 */
	private JLabel getplayerOneScoreLabel() {
		if (playerOneScoreLabel == null) {
			playerOneScoreLabel = new JLabel("Choose a New Game");
			playerOneScoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			playerOneScoreLabel.setBounds(54, 382, 161, 50);
		}
		return playerOneScoreLabel;
	}
	
	/**
	 * Gets the player two score label.
	 *
	 * @return the player two score label
	 */
	private JLabel getplayerTwoScoreLabel() {
		if (playerTwoScoreLabel == null) {
			playerTwoScoreLabel = new JLabel("Choose a New Game");
			playerTwoScoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			playerTwoScoreLabel.setBounds(407, 382, 166, 50);
		}
		return playerTwoScoreLabel;
	}
	
	/**
	 * Gets the new game.
	 *
	 * @return the new game
	 */
	private JButton getNewGame() {
		if (newGame == null) {
			newGame = new JButton("New Game");
			newGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setNewGame();
				}
			});
			newGame.setBounds(243, 336, 136, 42);
		}
		return newGame;
	}
	
	/**
	 * Gets the turn label.
	 *
	 * @return the turn label
	 */
	private JLabel getTurnLabel() {
		if (turnLabel == null) {
			turnLabel = new JLabel("Choose a New Game");
			turnLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			turnLabel.setBounds(214, 399, 181, 33);
		}
		return turnLabel;
	}
	
	/**
	 * Gets the hit button.
	 *
	 * @return the hit button
	 */
	private JButton getHitButton() {
		if (hitButton == null) {
			hitButton = new JButton("Hit");
			hitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					controlHit();
				}
			});
			hitButton.setBounds(243, 138, 136, 42);
		}
		return hitButton;
	}
	
	/**
	 * Gets the stand button.
	 *
	 * @return the stand button
	 */
	private JButton getStandButton() {
		if (standButton == null) {
			standButton = new JButton("Stand");
			standButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controlStand();
				}
			});

			standButton.setBounds(243, 202, 136, 42);
		}
		return standButton;
	}

	/**
	 * Control stand.
	 */
	private void controlStand(){
		if(gameMode == SINGLE_PLAYER_MODE){

			int playerOneScore = 0;
			for(Card c : playerOne.getPlayerHand().getHand()){
				playerOneScore += c.getCardValue();
			}

			int playerTwoScore = 0;
			for(Card c : playerTwo.getPlayerHand().getHand()){
				playerTwoScore += c.getCardValue();
			}


			while(playerTwoScore < 16){
				playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
				playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));

				playerTwoScore = 0;
				for(Card c : playerTwo.getPlayerHand().getHand()){
					playerTwoScore += c.getCardValue();
				}
			}

			if(playerTwoScore > 21){
				GameEngineTwoPlayer.currentPlayerMoney += 2*GameEngineTwoPlayer.betAmount;
				lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
				turnLabel.setText(playerOneName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerTwoName.toString() + " is busted!","Game Over " + playerOneName.toString() + " wins!",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				if(playerTwoScore >= playerOneScore){
					GameEngineTwoPlayer.currentPlayerMoney -= GameEngineTwoPlayer.betAmount;
					lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerTwoName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					GameEngineTwoPlayer.currentPlayerMoney += 2*GameEngineTwoPlayer.betAmount;
					lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
					turnLabel.setText(playerOneName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerOneName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
			}

			//update scores
			playerTwoScoreLabel.setText(playerTwo.toString() + " - " + String.valueOf(playerTwoScore));
			playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

			//update combo boxes
			playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
			playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));
		}
		else{
			int playerOneScore = 0;
			for(Card c : playerOne.getPlayerHand().getHand()){
				playerOneScore += c.getCardValue();
			}

			int playerTwoScore = 0;
			for(Card c : playerTwo.getPlayerHand().getHand()){
				playerTwoScore += c.getCardValue();
			}


			if(playerTwo.isDealer()){
				if(playerTwoScore >= playerOneScore){
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerTwoName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					turnLabel.setText(playerOneName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerOneName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else{
				if(playerTwoScore > playerOneScore){
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerTwoName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					turnLabel.setText(playerOneName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerOneName.toString() + " Wins!","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			

			//update scores
			playerTwoScoreLabel.setText(playerTwo.toString() + " - " + String.valueOf(playerTwoScore));
			playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

			//update combo boxes
			playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
			playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));
		}

	}
	
	
	/**
	 * Sets the new game.
	 */
	private void setNewGame(){
		
		if(GameEngineTwoPlayer.currentPlayerMoney < 0){
			JOptionPane.showMessageDialog(null, "You do not have enough money to play the game. Please restart the game.");
			System.exit(0);
		}
		
		//Custom button text
		Object[] options = {"Single Player Mode",
		"Double Player Mode"};
		int n = JOptionPane.showOptionDialog(null,
				"Please choose the mode of the New Game ",
				"New Game Wizard",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==0){
			
			gameMode = SINGLE_PLAYER_MODE;
			lblPlayerCash.setVisible(true);
			lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
			
			
			playerOneName = JOptionPane.showInputDialog(null, "Please Enter Name of Player One : ", "Enter Name", JOptionPane.PLAIN_MESSAGE);
			playerTwoName = "Computer";
			playerOne = new Player(playerOneName,false,false);
			playerTwo = new Player(playerTwoName,true,true);

			// add random cards to the player decks
			playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());

			//set the cards to the player combo boxes
			playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
			Object[] playerTwocards = playerTwo.getPlayerHand().getCardNames().toArray();
			playerTwocards[1] = "Face up";
			playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwocards));

			//count the score of player One as this is just a single player mode
			int playerOneScore = 0;
			for(Card c : playerOne.getPlayerHand().getHand()){
				playerOneScore += c.getCardValue();
			}

			int playerTwoScore = 0;
			for(Card c : playerTwo.getPlayerHand().getHand()){
				playerTwoScore += c.getCardValue();
			}

			//score of the dealer has to be shown towards the end
			playerTwoScoreLabel.setText(playerTwo.toString() + " - N/A");
			playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

			// change the picture so that it matches the one currently selected
			String selectedCardNameOne = (String)playerOneCardList.getSelectedItem();
			String selectedCardNameTwo = (String)playerTwoCardList.getSelectedItem();
			try {
				setImageOne("150/" + selectedCardNameOne + "-150.png");
				setImageTwo("150/" + selectedCardNameTwo + "-150.png");
			} catch (IOException e1) {
				e1.printStackTrace();
			}


			String bet = JOptionPane.showInputDialog(null, "Please enter the bet amount : ", "Enter Bet Amount", JOptionPane.PLAIN_MESSAGE);
			GameEngineTwoPlayer.betAmount = Integer.parseInt(bet);
			
			// check if Either of them has a blackJack
			if(playerOneScore == 21 && playerTwoScore == 21){
				turnLabel.setText(playerTwoName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, "Both players have a BlackJack! ,so " + playerTwoName.toString() + " wins the game.","Game Over",JOptionPane.INFORMATION_MESSAGE);
				GameEngineTwoPlayer.currentPlayerMoney -= GameEngineTwoPlayer.betAmount;
				lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
			}
			else if(playerOneScore == 21){
				turnLabel.setText(playerOneName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerOneName.toString() + " has a black and wins the game.","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				GameEngineTwoPlayer.currentPlayerMoney += 2*GameEngineTwoPlayer.betAmount;
				lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
			}
			else if(playerTwoScore == 21){
				turnLabel.setText(playerTwoName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerTwoName.toString() + " has a black and wins the game.","Game Over ",JOptionPane.INFORMATION_MESSAGE);
				GameEngineTwoPlayer.currentPlayerMoney -= GameEngineTwoPlayer.betAmount;
				lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
			}

			// none of them has a blackJack ask player if he wants to hit or stand
			turnLabel.setText(playerOneName.toString() + "'s turn");

		}
		else{
			
			
			lblPlayerCash.setVisible(false);
			
			playerOneName= JOptionPane.showInputDialog(null, "Please Enter Name of Player One : ", "Enter Name", JOptionPane.PLAIN_MESSAGE);
			playerTwoName = JOptionPane.showInputDialog(null, "Please Enter Name of Player Two : ", "Enter Name", JOptionPane.PLAIN_MESSAGE);

			//Custom button text
			Object[] dealeroOptions = {playerOneName,
					playerTwoName};
			int dealerNumber = JOptionPane.showOptionDialog(null,
					"Please choose the dealer of the New Game ",
					"Choose Dealer",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,dealeroOptions,dealeroOptions[1]);

			//add two new players depending on the dealer
			if(dealerNumber == 0){
				playerOne = new Player(playerOneName,false,true);
				playerTwo = new Player(playerTwoName,false,false);
			}
			else{
				playerOne = new Player(playerOneName,false,false);
				playerTwo = new Player(playerTwoName,false,true);
			}

			// add random cards to the player decks
			playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());

			//set the cards to the player combo boxes
			if(playerTwo.isDealer()){
				turn = PLAYER_ONE_TURN;
				playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
				Object[] playerTwocards = playerTwo.getPlayerHand().getCardNames().toArray();
				playerTwocards[1] = "Face up";
				playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwocards));
			}
			else{
				turn = PLAYER_TWO_TURN;
				playerTwoCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
				Object[] playerOnecards = playerOne.getPlayerHand().getCardNames().toArray();
				playerOnecards[1] = "Face up";
				playerOneCardList.setModel(new DefaultComboBoxModel(playerOnecards));
			}

			//count the scores
			int playerOneScore = 0;
			for(Card c : playerOne.getPlayerHand().getHand()){
				playerOneScore += c.getCardValue();
			}

			int playerTwoScore = 0;
			for(Card c : playerTwo.getPlayerHand().getHand()){
				playerTwoScore += c.getCardValue();
			}

			//score of the dealer has to be shown towards the end
			playerTwoScoreLabel.setText(playerTwo.toString() + " - " + " ");
			playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

			// change the picture so that it matches the one currently selected
			String selectedCardNameOne = (String)playerOneCardList.getSelectedItem();
			String selectedCardNameTwo = (String)playerTwoCardList.getSelectedItem();
			try {
				setImageOne("150/" + selectedCardNameOne + "-150.png");
				setImageTwo("150/" + selectedCardNameTwo + "-150.png");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// check if Either of them has a blackJack
			if(playerOneScore == 21 && playerTwoScore == 21){
				if(playerTwo.isDealer()){
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, "Both players have a BlackJack! ,so " + playerTwoName.toString() + " wins the game.","Game Over",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					turnLabel.setText(playerOneName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, "Both players have a BlackJack! ,so " + playerOneName.toString() + " wins the game.","Game Over",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(playerOneScore == 21){
				turnLabel.setText(playerOneName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerOneName.toString() + " has a black and wins the game.","Game Over ",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(playerTwoScore == 21){
				turnLabel.setText(playerTwoName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerTwoName.toString() + " has a black and wins the game.","Game Over ",JOptionPane.INFORMATION_MESSAGE);
			}

			//set player turns
			if(turn == PLAYER_ONE_TURN){
				turnLabel.setText(playerOneName.toString() + "'s turn");
			}
			else{
				turnLabel.setText(playerTwoName.toString() + "'s turn");
			}


		}

	}

	/**
	 * Control hit.
	 */
	private void controlHit(){
		if(gameMode == SINGLE_PLAYER_MODE){
			playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
			//update combo box
			playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
			int playerOneScore = 0;
			for(Card c : playerOne.getPlayerHand().getHand()){
				playerOneScore += c.getCardValue();
			}

			if(playerOneScore > 21){
				turnLabel.setText(playerTwoName.toString() + " wins!");
				JOptionPane.showMessageDialog(null, playerOneName.toString() + " is busted!","Game Over " + playerTwoName.toString() + " wins!",JOptionPane.INFORMATION_MESSAGE);
				GameEngineTwoPlayer.currentPlayerMoney -= GameEngineTwoPlayer.betAmount;
				lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
			}

			//update scores
			playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

		}
		else {
			if(turn == PLAYER_ONE_TURN){
				
				playerOne.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
				//update combo box
				playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
				int playerOneScore = 0;
				for(Card c : playerOne.getPlayerHand().getHand()){
					playerOneScore += c.getCardValue();
				}
				
				int playerTwoScore = 0;
				for(Card c : playerTwo.getPlayerHand().getHand()){
					playerTwoScore += c.getCardValue();
				}

				if(playerOneScore > 21){
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerOneName.toString() + " is busted!","Game Over " + playerTwoName.toString() + " wins!",JOptionPane.INFORMATION_MESSAGE);
					
					GameEngineTwoPlayer.currentPlayerMoney -= GameEngineTwoPlayer.betAmount;
					lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
					//update scores
					playerTwoScoreLabel.setText(playerTwo.toString() + " - " + String.valueOf(playerTwoScore));
					playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

					//update combo boxes
					playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
					playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));
				}

				//update scores
				if(!playerOne.isDealer()){
					playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));
				}
				
				turn = PLAYER_TWO_TURN;
				turnLabel.setText(playerTwoName.toString() + "'s turn");
			}
			else{
				playerTwo.getPlayerHand().addCardToHand(cardDeck.getRandomCard());
				//update combo box
				playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));
				int playerTwoScore = 0;
				for(Card c : playerTwo.getPlayerHand().getHand()){
					playerTwoScore += c.getCardValue();
				}
				
				int playerOneScore = 0;
				for(Card c : playerOne.getPlayerHand().getHand()){
					playerOneScore += c.getCardValue();
				}

				if(playerTwoScore > 21){
					turnLabel.setText(playerTwoName.toString() + " wins!");
					JOptionPane.showMessageDialog(null, playerTwoName.toString() + " is busted!","Game Over " + playerOneName.toString() + " wins!",JOptionPane.INFORMATION_MESSAGE);
					GameEngineTwoPlayer.currentPlayerMoney += 2*GameEngineTwoPlayer.betAmount;
					lblPlayerCash.setText("Player Cash - " + GameEngineTwoPlayer.currentPlayerMoney );
					//update scores
					playerTwoScoreLabel.setText(playerTwo.toString() + " - " + String.valueOf(playerTwoScore));
					playerOneScoreLabel.setText(playerOne.toString() + " - " + String.valueOf(playerOneScore));

					//update combo boxes
					playerOneCardList.setModel(new DefaultComboBoxModel(playerOne.getPlayerHand().getCardNames().toArray()));
					playerTwoCardList.setModel(new DefaultComboBoxModel(playerTwo.getPlayerHand().getCardNames().toArray()));
				}

				//update scores
				if(!playerTwo.isDealer()){
					playerTwoScoreLabel.setText(playerTwo.toString() + " - " + String.valueOf(playerTwoScore));
				}
				
				turn = PLAYER_ONE_TURN;
				turnLabel.setText(playerOneName.toString() + "'s turn");
			}
		}
	}
	
	/**
	 * Sets the image one.
	 *
	 * @param fileName the new image one
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setImageOne(String fileName) throws IOException{
		BufferedImage myPicture = ImageIO.read(new File(fileName));
		imageOne.setIcon(new ImageIcon( myPicture ));
	}

	/**
	 * Sets the image two.
	 *
	 * @param fileName the new image two
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setImageTwo(String fileName) throws IOException{
		BufferedImage myPicture = ImageIO.read(new File(fileName));
		imageTwo.setIcon(new ImageIcon( myPicture ));
	}
	private JLabel getLblPlayerCash() {
		if (lblPlayerCash == null) {
			lblPlayerCash = new JLabel("PLAYER CASH - ");
			lblPlayerCash.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblPlayerCash.setBounds(214, 30, 213, 36);
		}
		return lblPlayerCash;
	}
}
