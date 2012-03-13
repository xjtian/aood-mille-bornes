package baseclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * A Mille Bournes game.
 * 
 * This class encapsulates all of the logic-checking behind whether or not a move 
 * is valid. This class is designed so that a "dumb" user interface just passes 
 * a user's attempted moves to the methods to check for legality.
 * 
 * @author Jacky Tian
 */
public class Game implements Serializable {
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
    public static final int WIDTH = 600;
    /**
     * Mandatory color for the background of all GUIs. Hack around black background 
     * of a rotated BufferedImage.
     */
    public static final Color BACKGROUND = Color.WHITE;
    
    /**
     * Instantiates the discard pile and both players and populates the deck.
     */
    public Game() {
        discardPile = new ArrayList<Card>();
        deck = new ArrayList<Card>();
        humanPlayer = new Player();
        cpuPlayer = new Player();
        cpuPlayer.name = "Computer";
        
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
        
        for (int i = 0; i < 3; i++) {
            deck.add(new Card(CardType.ACCIDENT));
            deck.add(new Card(CardType.FLAT));
            deck.add(new Card(CardType.EMPTY));
            deck.add(new Card(CardType.LIMIT));
            deck.add(new Card(CardType.STOP));
        }
        
        deck.add(new Card(CardType.STOP));
        deck.add(new Card(CardType.STOP));
        deck.add(new Card(CardType.LIMIT));
        
        deck.add(new Card(CardType.DRIVING_ACE));
        deck.add(new Card(CardType.EXTRA_TANK));
        deck.add(new Card(CardType.PUNCTURE_PROOF));
        deck.add(new Card(CardType.RIGHT_OF_WAY));
        
        shuffleDeck();
    }
    
    private void shuffleDeck() {
        Random r = new Random();
        for (int i = 0; i < 150; i++) {
            Collections.swap(deck, r.nextInt(deck.size()), r.nextInt(deck.size()));
        }
    }
    
    /**
     * Set the human player's name.
     * 
     * @param name The new name.
     */
    public void setPlayerName(String name) {
        humanPlayer.name = name;
    }
    
    /**
     * Get the specified player's name.
     * 
     * @param player Either <code>HUMAN</code> or <code>CPU</code>.
     * @return The name of the player.
     * @throws Exception Indicates an invalid player code.
     */
    public String getPlayerName(int player) {
        if (player == HUMAN)
            return humanPlayer.name;
        else if (player == CPU)
            return cpuPlayer.name;
        else
            return "Invalid Player Code";
    }
    
    /**
     * Determine the validity of a given move.
     * 
     * @param player 1 for human, 2 for computer.
     * @param card Index of card to play in the player's hand.
     * @return True if the move is legal, false otherwise.
     * @throws Exception Indicates an invalid player code.
     */
    public boolean validateMove(int player, int card) {
        if (player == HUMAN) {
            Card c = humanPlayer.getCard(card);
            
            
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
                case D200:
                    distance = 200;
                    break;
                case ACCIDENT:
                case EMPTY:
                case FLAT:
                case STOP:
                case LIMIT:
                    return cpuTableau.validMove(c);
                default:
                    return humanTableau.validMove(c);
            }
            
            if (humanPlayer.miles + distance > 1000)
                return false;
            
            return humanTableau.validMove(c);
        } else if (player == CPU) {
            Card c = cpuPlayer.getCard(card);
                
            if (!cpuTableau.validMove(c))
                return false;
            
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
                case D200:
                    distance = 200;
                    break;
                default:
                    return true;
            }
            
            if (cpuPlayer.miles + distance > 1000)
                return false;
            
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Have a specified player play a specified card.
     * 
     * @param player Either <code>HUMAN</code> or <code>CPU</code>.
     * @param card Index of card to play in the player's hand.
     * @throws Exception Check the message to see if the error is an illegal move, 
     * invalid player code, or logical differences between Tableau and Game.
     */
    public void makeMove(int player, int card) throws Exception {
        if (!validateMove(player, card))
            throw new Exception("Illegal Move");
        
        if (player == HUMAN) {
            Card c = humanPlayer.getCard(card);
            switch (c.type) {
                case D25: 
                    humanPlayer.miles += 25; 
                    humanTableau.playCard(c);
                    break;
                case D50: 
                    humanPlayer.miles += 50; 
                    humanTableau.playCard(c); 
                    break;
                case D75: 
                    humanPlayer.miles += 75; 
                    humanTableau.playCard(c); 
                    break;
                case D100: 
                    humanPlayer.miles += 100; 
                    humanTableau.playCard(c); 
                    break;
                case D200:
                    if (humanTableau.isRolling())
                        humanPlayer.miles += 200;
                    humanTableau.playCard(c);
                    break;
                case ACCIDENT:
                case EMPTY:
                case LIMIT:
                case FLAT:
                case STOP:
                    cpuTableau.playCard(c);
                    break;
                default:
                    humanTableau.playCard(c);
            }
            humanPlayer.playCard(card);
        } else if (player == CPU) {
            Card c = cpuPlayer.getCard(card);
            switch (c.type) {
                case D25: 
                    cpuPlayer.miles += 25; 
                    cpuTableau.playCard(c);
                    break;
                case D50: 
                    cpuPlayer.miles += 50; 
                    cpuTableau.playCard(c); 
                    break;
                case D75: 
                    cpuPlayer.miles += 75; 
                    cpuTableau.playCard(c); 
                    break;
                case D100: 
                    cpuPlayer.miles += 100; 
                    cpuTableau.playCard(c); 
                    break;
                case D200:
                    if (cpuTableau.isRolling())
                        cpuPlayer.miles += 200;
                    cpuTableau.playCard(c);
                    break;
                case ACCIDENT:
                case EMPTY:
                case LIMIT:
                case FLAT:
                case STOP:
                    humanTableau.playCard(c);
                    break;
                default:
                    cpuTableau.playCard(c);
            }
            cpuPlayer.playCard(card);
        }
    }
    
    /**
     * Generate a random valid move by the CPU player.
     * 
     * @return Index of the card to play in the CPU player's hand. -1 means discard.
     */
    public int generateCPUMove() {
        //@TODO: Currently Stubbed. Complete the AI algorithm.
        boolean[] valids = getAllValidPlays(CPU);
        
        int counter = 0;
        for (int i = 0; i < valids.length; i++) {
            if (valids[i])
                counter++;
        }
        
        if (counter == 0)
            return -1;
        else {
            for (int i = 0; i < valids.length; i++) {
                if (valids[i])
                    return i;
            }
            return -1;
        }
    }
    
    /**
     * Generate a boolean array to indicate which cards in a player's hand are 
     * legal to play.
     * 
     * @param player Either <code>HUMAN</code> or <code>CPU</code>.
     * @return A boolean array with values corresponding to the legality of each 
     * card in the player's hand.
     * @throws Exception Indicates an invalid player code.
     */
    public boolean[] getAllValidPlays(int player) {
        if (player == HUMAN) {
            boolean[] output = new boolean[humanPlayer.getHandSize()];
            for (int i = 0; i < output.length; i++) {
                output[i] = validateMove(player, i);
            }
            
            return output;
        } else if (player == CPU) {
            boolean[] output = new boolean[cpuPlayer.getHandSize()];
            for (int i = 0; i < output.length; i++) {
                output[i] = validateMove(player, i);
            }
            
            return output;
        } else {
            return new boolean[]{false};
        }
    }
    
    /**
     * Determine if the game is over.
     * 
     * @return <code>HUMAN</code> if the human won, <code>CPU</code> if the 
     * computer won, or 0 if no winner.
     */
    public int isOver() {
        if (humanPlayer.miles == 1000)
            return HUMAN;
        else if (cpuPlayer.miles == 1000)
            return CPU;
        else
            return 0;
    }
    
    /**
     * Each player draws a 6-card hand.
     */
    public void drawAllCards() {
        for (int i = 0; i < 6; i++) {
            humanPlayer.drawCard(deck.remove(0));
            cpuPlayer.drawCard(deck.remove(0));
        }
    }
    
    /**
     * Add the top card of the deck to a player's hand.
     * 
     * @param player Either <code>HUMAN</code> or <code>CPU</code>.
     * @throws Exception Indicates an invalid player code.
     */
    public void drawCard(int player) {
        if (deck.isEmpty()) {
            ArrayList<Card> hc = humanTableau.shuffleNewDeck();
            ArrayList<Card> cc = cpuTableau.shuffleNewDeck();
            deck.addAll(hc);
            deck.addAll(cc);
            shuffleDeck();
        }
        if (player == HUMAN)
            humanPlayer.drawCard(deck.remove(0));
        else if (player == CPU)
            cpuPlayer.drawCard(deck.remove(0));
    }
    
    /**
     * Discard a card from a player's hand.
     * 
     * @param player Either <code>HUMAN</code> or <code>CPU</code>.
     * @param card Index of card to play in the player's hand.
     * @throws Exception Indicates an invalid player code.
     */
    public void discard(int player, int card) {
        if (player == HUMAN)
            discardPile.add(humanPlayer.playCard(card));
        else if (player == CPU)
            discardPile.add(cpuPlayer.playCard(card));
    }
    
    /**
     * Quit the game by nullifying all instance variables.
     */
    public void quit() {
        cpuPlayer = humanPlayer = null;
        cpuTableau = humanTableau = null;
        deck = discardPile = null;
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
     * Draw an ASCII-art version of the game for text-based UI's.
     * 
     * @return A string with all the game data.
     */
    public String draw() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Draw the game on a component.
     * 
     * @param g Graphics object of the component.
     */
    public void draw(Graphics g) {
        cpuTableau.draw(g, 20, 20);
        humanTableau.draw(g, 20, 2*Card.CARD_HEIGHT + 40);
        g.drawString("CPU: " + cpuPlayer.miles, 5*Card.CARD_WIDTH + 30, 20);
        g.drawString("Human: " + humanPlayer.miles, 5*Card.CARD_WIDTH + 30, 40);
        for (int i = 0; i < humanPlayer.getHandSize(); i++) {
            humanPlayer.getCard(i).draw(g, 20 + (Card.CARD_WIDTH + 10) * i, 4*Card.CARD_HEIGHT + 50);
        }
        
        g.drawString("Discard Here", 20 + (Card.CARD_WIDTH + 10) * 7, 4*Card.CARD_HEIGHT + 50);
    }
    
    public JComponent getComponent() {
        JComponent component = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                removeAll();
                
                JComponent ctc = cpuTableau.getComponent();
                ctc.setName("cpuTableau");
                this.add(ctc);
                ctc.setBounds(0, 0, (Card.CARD_WIDTH + 10) * 4, Card.CARD_HEIGHT*2 + 10);

                JComponent htc = humanTableau.getComponent();
                htc.setName("humanTableau");
                this.add(htc);
                htc.setBounds(0, 2*Card.CARD_HEIGHT + 40, (Card.CARD_WIDTH + 10)*4, Card.CARD_HEIGHT * 2 + 10);

//                for (int i = 0; i < humanPlayer.getHandSize(); i++) {
//                    JComponent temp = humanPlayer.getCard(i).getComponent();
//                    temp.setName("Card");
//                    this.add(temp);
//                    temp.setBounds(20 + (Card.CARD_WIDTH + 10) * i, 4 * Card.CARD_HEIGHT + 50, Card.CARD_WIDTH, Card.CARD_HEIGHT);
//                }
            }
        };
        
        return component;
    }
    
    public int getPlayerHandSize() {
        return humanPlayer.getHandSize();
    }
    
    public javax.swing.JLabel getCardLabel(int card) {
        return humanPlayer.getCard(card).getComponent();
    }
    
    /**
     * Get the sprite of a specified card in the player's hand as an <code>ImageIcon</code>.
     * 
     * @param card Index of the card in the player's hand.
     * @return An <code>ImageIcon</code> that contains a scaled version of the sprite.
     */
    public ImageIcon getCardIcon(int card) {
        humanPlayer.getCard(card).loadImage();
        return new ImageIcon(humanPlayer.getCard(card).sprite.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST));
    }
}
