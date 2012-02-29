/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * A player in a game of Mille Bornes. 
 * 
 * This class is "dumb", meaning that all of its methods do not calculate the 
 * logic behind whether or not a certain move is valid. The public methods of the 
 * class assume that all logic-checking is done outside.
 * 
 * @author jacky
 */
public class Player {
    private ArrayList<Card> hand;
    /**
     * The name of the player.
     */
    protected String name;
    
    /**
     * How many miles the player has accumulated.
     */
    protected int miles;
    
    /**
     * Default constructor to make a player with no name.
     */
    public Player() {
        hand = new ArrayList<Card>();
        name = "No Name.";
        miles = 0;
    }
    
    /**
     * Set the player's name.
     * 
     * @param name the player's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the card at specified index in the hand for logic-checking.
     * 
     * The game MUST use this method before a call to <code>playCard()</code> to 
     * ensure that every move is legal.
     * 
     * @param i the index of the card in the hand to play.
     * @return the <code>Card</code> at the index.
     */
    public Card getCard(int i) {
        return hand.get(i);
    }
    
    /**
     * Play the card at the index in the hand specified by <code>i</code>.
     * 
     * This method assumes the logic behind whether or not the move is a valid 
     * play has already been satisfied, and removes and returns the card at the 
     * specified position.
     * 
     * Note that this method does not specify where the card goes. It only removes 
     * the card from the hand. All logic about where the card needs to go should 
     * be handled in a separate class.
     * 
     * @param i the index of the card in the hand to play.
     * @return the <code>Card</code> object to be played.
     */
    public Card playCard(int i) {
        return hand.remove(i);
    }
    
    /**
     * Get the size of the player's hand.
     * 
     * Note that this method should only ever return 5, 6, or 7.
     * 
     * @return the size of the player's hand.
     */
    public int getHandSize() {
        return hand.size();
    }
    
    /**
     * Draw the hand as a sequential list of all the cards.
     * 
     * @param g graphics object associated with a component.
     * @param x x-coordinate of top-left corner of first card.
     * @param y y-coordinate of top-left corner of first card.
     */
    public void drawHand(Graphics g, int x , int y) {
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).draw(g, x + (Card.CARD_HEIGHT * i), y);
        }
    }
    
    /**
     * Return an ASCII-art representation of the player's hand.
     * 
     * @return a String representation of the player's hand.
     */
    public String drawHand() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Player adds a specified card to his/her hand.
     * 
     * @param c the card to be drawn.
     */
    public void drawCard(Card c) {
        hand.add(c);
    }
}
