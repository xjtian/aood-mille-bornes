package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * A Mille Bournes game.
 * 
 * This class encapsulates all of the logic-checking behind whether or not a move 
 * is valid. This class is designed so that a "dumb" user interface just passes 
 * a user's attempted moves to the methods to check for legality.
 * 
 * @author Jacky Tian
 */
public class Game {
    private ArrayList<Card> discardPile;
    private ArrayList<Card> deck;
    
    private Player humanPlayer;
    private Player cpuPlayer;
    
    private Tableau humanTableau;
    private Tableau cpuTableau;
    
    /**
     * Points to the human player.
     */
    public static final int HUMAN = 1;
    /**
     * Points to the computer player.
     */
    public static final int CPU = 2;
    
    /**
     * Height of the game when it is painted.
     */
    public static final int HEIGHT = 500;
    /**
     * Width of the game when it is painted.
     */
    public static final int WIDTH = 750;
    
    /**
     * Instantiates the discard pile and both players and populates the deck.
     */
    public Game() {
        discardPile = new ArrayList<Card>();
        deck = new ArrayList<Card>();
        humanPlayer = new Player();
        cpuPlayer = new Player();
        
        humanTableau = new Tableau();
        cpuTableau = new Tableau();
        populateDeck();
    }
    
    private void populateDeck() {
        for (int i = 0; i < 10; i++) {
            deck.add(new Card(CardType.D25));
            deck.add(new Card(CardType.D50));
            deck.add(new Card(CardType.D75));
            deck.add(new Card(CardType.D100));
        }
        
        deck.add(new Card(CardType.D100));
        deck.add(new Card(CardType.D100));
        
        for (int i = 0; i < 4; i++) {
            deck.add(new Card(CardType.D200));
        }
        
        for (int i = 0; i < 3; i++) {
            deck.add(new Card(CardType.ROAD_SERVICE));
        }
        
        for (int i = 0; i < 6; i++) {
            deck.add(new Card(CardType.REPAIR));
            deck.add(new Card(CardType.SPARE));
            deck.add(new Card(CardType.END_LIMIT));
            deck.add(new Card(CardType.GAS));
            deck.add(new Card(CardType.ROLL));
        }
        
        for (int i = 0; i < 8; i++) {
            deck.add(new Card(CardType.ROLL));
        }
    }
    
    /**
     * Determine the validity of a given move.
     * 
     * @param player 1 for human, 2 for computer.
     * @param card Index of card to play in the player's hand.
     * @return True if the move is legal, false otherwise.
     */
    public boolean validateMove(int player, int card) {
        switch (player) {
            case 1:
                Card c = humanPlayer.getCard(card);
                
                if (!humanTableau.validMove(c))
                    return false;
                
                //@TODO: determine if the distance is too much
                int distance;
                switch (c.type) {
                    case D25: 
                        distance = 25;
                        break;
                    case D50: 
                        distance = 50;
                        break;
                    case D75: 
                        distance = 75;
                        break;
                    case D100:
                        distance = 100;
                        break;
                        
                }
        }
        
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Have a specified player play a specified card.
     * 
     * All logic-checking should be done beforehand.
     * 
     * @param player 1 for human, 2 for computer.
     * @param card Index of card to play in the player's hand.
     */
    public void makeMove(int player, int card) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Generate a random valid move by the CPU player.
     * 
     * @return Index of the card to play in the CPU player's hand.
     */
    public int generateCPUMove() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Generate a boolean array to indicate which cards in a player's hand are 
     * legal to play.
     * 
     * @param player 1 for human, 2 for computer.
     * @return A boolean array with values corresponding to the legality of each 
     * card in the player's hand.
     */
    public boolean[] getAllValidPlays(int player) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Determine if the game is over.
     * 
     * @return 1 if the human won, 2 if the computer won.
     */
    public int isOver() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Each player draws a 6-card hand.
     */
    public void drawAllCards() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Add the top card of the deck to a player's hand.
     * 
     * @param player 1 for human, 2 for computer.
     */
    public void draw(int player) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Discard a card from a player's hand.
     * 
     * @param player 1 for human, 2 for computer.
     * @param card Index of card to play in the player's hand.
     */
    public void discard(int player, int card) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Quit the game.
     */
    public void quit() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Return a pointer to this object for serialization.
     * 
     * @return This <code>Game</code> object.
     */
    public Game save() {
        return this;
    }
    
    /**
     * Draw the game on a component.
     * 
     * @param g Graphics object of the component.
     */
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
