package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Tableau of cards in front of a player. 
 * 
 * This class contains various 'piles' where cards can be played, and logic-checking 
 * capabilities. However, playing a card to a pile still assumes that the move has 
 * been validated beforehand. The public methods that allow a card to be played 
 * into a specific stack are "dumb" methods, but the <code>playCard()</code> method 
 * is "smart" because it will throw an exception in the case of an invalid play.
 * 
 * Note that the tableau does not check for some cases of invalid plays, such as 
 * whether or not a distance card is valid based on how much more distance the player 
 * needs to reach 1000 miles.
 * 
 * @author Jacky Tian, Matt Hemler, Evan M., Ben Ferguson
 */
public final class Tableau {
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
     * Play a given card to the correct pile.
     * 
     * This method throws an exception in the case of an illegal play. This is 
     * the preferred way to play a card.
     * 
     * @param c <code>Card</code> to be played.
     * @throws Exception Indicates that a play is not valid. 
     */
    public void playCard(Card c) throws Exception {
        if (!validMove(c))
            throw new Exception();
        
        switch (c.type) {
            case D25:
            case D50:
            case D75:
            case D100:
            case D200:
                playToDistance(c);
                break;
            case ACCIDENT:
            case EMPTY:
            case FLAT:
            case STOP:
                playToBattle(c);
                break;
            case LIMIT:
            case END_LIMIT:
                playToSpeed(c);
                break;
            case GAS:
            case REPAIR:
            case ROLL:
            case SPARE:
                playToBattle(c);
                break;
            case ROAD_SERVICE:
                playToSafety(c);
                break;
        }
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
     * type of the card. This method does NOT check the legality of a certain distance 
     * in the event a player is very close to winning (greater than 800 miles).
     * 
     * @param c <code>Card</code> to be potentially played.
     * @return
     */
    public boolean validMove(Card c) {
        Card battleTop;
        try {
            battleTop = battlePile.get(battlePile.size() - 1);
        } catch (IndexOutOfBoundsException ex) {
            battleTop = new Card(CardType.BLANK_CARD);
        }
        
        Card speedTop;
        try {
            speedTop = speedPile.get(speedPile.size() - 1);
        } catch (IndexOutOfBoundsException ex) {
            speedTop = new Card(CardType.BLANK_CARD);
        }
        
        switch(c.type)   {
            case D25:
            case D50:
                return isRolling();
            case D75:
            case D100:
                return (isRolling() && speedTop.type != CardType.LIMIT);
            case D200:
                if (isRolling() && speedTop.type != CardType.LIMIT && played200 < 2)
                    return true;
                else
                    return !isRolling();
            case ACCIDENT:
            case EMPTY:
            case FLAT:
            case STOP:
                return isRolling();
            case LIMIT:
                return (speedTop.type != CardType.LIMIT);
            case END_LIMIT:
                return (speedTop.type == CardType.LIMIT);
            case GAS:
                return (battleTop.type == CardType.EMPTY);
            case REPAIR:
                return (battleTop.type == CardType.ACCIDENT);
            case ROLL:
                return !isRolling();
            case SPARE:
                return (battleTop.type == CardType.FLAT);
            case ROAD_SERVICE:
                return (battleTop.type != CardType.ROLL
                        || speedTop.type == CardType.LIMIT);
            default:
                return false;
        }
    }
    
    /**
     * Determine whether or not the player that owns the tableau is rolling.
     * 
     * @return True if the player is rolling, False otherwise.
     */
    public boolean isRolling()  {
        Card topBattleCard = battlePile.get(battlePile.size()-1);
        
        switch (topBattleCard.type) {
            case ROAD_SERVICE:
            case ROLL:
            case D200:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Draws the tableau.
     * 
     * @param g Graphics object of the component.
     * @param x X-coordinate of upper-left corner of the tableau.
     * @param y Y-coordinate of upper-left corner of the tableau.
     */
    public void draw(Graphics g, int x, int y) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Return an ASCII-art representation of the tableau.
     * 
     * @return A String representation of the tableau.
     */
    public String draw() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
