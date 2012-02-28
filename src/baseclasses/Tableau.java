/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
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
}
