/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Tableau of cards in front of a player. 
 * 
 * This class contains various 'piles' where cards can be played, and logic-checking 
 * capabilities. However, playing a card to a pile still assumes that the move has 
 * been validated beforehand. Therefore, the methods are "dumb", but the class can 
 * be "smart".
 * @author jacky
 */
public class Tableau {
    /**
     * How many 200-mile cards have been played to the distance pile.
     */
    protected int played200;
    
    private ArrayList<Card> safetyPile;
    private ArrayList<Card> speedPile;
    private ArrayList<Card> battlePile;
    private ArrayList<Card> distancePile;
    
    /**
     * Default constructor that instantiates all fields.
     */
    public Tableau() {
        safetyPile = new ArrayList<Card>();
        speedPile = new ArrayList<Card>();
        battlePile = new ArrayList<Card>();
        distancePile = new ArrayList<Card>();
        played200 = 0;
    }
    
    /**
     * Play a card to the safety pile.
     * 
     * @param c <code>Card</code> to be played.
     */
    public void playToSafety(Card c) {
        safetyPile.add(c);
    }
    
    /**
     * Play a card as a coup-fourre.
     * 
     * @param c <code>Card</code> to be played.
     */
    public void playCoupFourre(Card c) {
        c.sideways = true;
        safetyPile.add(c);
    }
    
    /**
     * Play a card to the speed pile.
     * 
     * @param c <code>Card</code> to be played.
     */
    public void playToSpeed(Card c) {
        speedPile.add(c);
    }
    
    /**
     * Play a card to the battle pile.
     * 
     * @param c <code>Card</code> to be played.
     */
    public void playToBattle(Card c) {
        battlePile.add(c);
    }
    
    /**
     * Play a card to the distance pile.
     * 
     * If the card is an instance of a 200-mile card, then we increment the counter.
     * 
     * @param c <code>Card</code> to be played.
     */
    public void playToDistance(Card c) {
        if (c.type == CardType.D200) {
            played200++;
        }
        distancePile.add(c);
    }
    
    /**
     * Remove and return every card in each stack except the top card.
     * 
     * This method will clear out the stacks so that they either only contain the 
     * top card or no cards if the stack was empty to begin with.
     * 
     * @return an <code>ArrayList</code> populated with each removed card.
     */
    public ArrayList<Card> shuffleNewDeck() {
        ArrayList<Card> temp = new ArrayList<Card>();
        
        for (int i = safetyPile.size() - 2; i >= 0; i--) {
            temp.add(safetyPile.remove(i));
        }
        
        for (int i = speedPile.size() - 2; i >= 0; i++) {
            temp.add(speedPile.remove(i));
        }
        
        for (int i = battlePile.size() - 2; i >= 0; i++) {
            temp.add(battlePile.remove(i));
        }
        
        for (int i = distancePile.size() - 2; i >= 0; i++) {
            temp.add(distancePile.remove(i));
        }
        
        return temp;
    }
    
    /**
     * Test the validity of a move.
     * 
     * Target pile does not have to be specified because that is implied with the 
     * type of the card.
     * 
     * @param c <code>Card</code> to be potentially played.
     * @return
     */
    public boolean validMove(Card c) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Draws the tableau.
     * 
     * @param g graphics object of the component.
     * @param x x-coordinate of upper-left corner of the tableau.
     * @param y y-coordinate of upper-left corner of the tableau.
     */
    public void draw(Graphics g, int x, int y) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Return an ASCII-art representation of the tableau.
     * 
     * @return a String representation of the tableau.
     */
    public String draw() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
