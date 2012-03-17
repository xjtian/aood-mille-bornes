package baseclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

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
public final class Tableau implements Serializable {
    /**
     * How many 200-mile cards have been played to the distance pile.
     */
    protected int played200;
    
    /**
     * Integer code for battle pile.
     */
    public static final int BATTLE = 1;
    /**
     * Integer code for speed pile.
     */
    public static final int SPEED = 2;
    /**
     * Integer code for distance pile.
     */
    public static final int DISTANCE = 3;
    
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
            throw new Exception("Tableau Says Illegal Move");
        
        switch (c.type) {
            case D25:
            case D50:
            case D75:
            case D100:
                playToDistance(c);
                break;
            case D200:
                if (isRolling())
                    playToDistance(c);
                else
                    playToBattle(c);
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
                if (!isRolling())
                    playToBattle(c);
                else
                    playToSpeed(c);
                break;
            case DRIVING_ACE:
            case PUNCTURE_PROOF:
            case RIGHT_OF_WAY:
            case EXTRA_TANK:
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
        c.turnSideways();
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
     * Return the <code>CardType</code> of the last card to be played to the battle 
     * pile. For coup-fourres.
     * 
     * @return The <code>CardType</code> of the top battle pile card, 
     * <code>BLANK_CARD</code> if the battle pile is empty.
     */
    public CardType getBattleTopType() {
        CardType top;
        if (!battlePile.isEmpty())
            top = battlePile.get(battlePile.size() - 1).type;
        else
            top = CardType.BLANK_CARD;
        return top;
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
        
        for (int i = speedPile.size() - 2; i >= 0; i--) {
            temp.add(speedPile.remove(i));
        }
        
        for (int i = battlePile.size() - 2; i >= 0; i--) {
            temp.add(battlePile.remove(i));
        }
        
        for (int i = distancePile.size() - 2; i >= 0; i--) {
            temp.add(distancePile.remove(i));
        }
        
        return temp;
    }
    
    /**
     * Test the validity of a move.
     * 
     * Target pile does not have to be specified because that is implied with the 
     * type of the card. This method does NOT check the legality of a certain distance 
     * in the event a player is close to winning (greater than 800 miles).
     * 
     * @param c <code>Card</code> to be potentially played.
     * @return
     */
    public boolean validMove(Card c) {
        Card battleTop;
        if (! battlePile.isEmpty())
            battleTop = battlePile.get(battlePile.size() - 1);
        else
            battleTop = new Card(CardType.BLANK_CARD);
        
        
        Card speedTop;
        if (! speedPile.isEmpty())
            speedTop = speedPile.get(speedPile.size() - 1);
        else
            speedTop = new Card(CardType.BLANK_CARD);
        
        boolean hasSpeedLimit = true;
        for (Card cc : safetyPile) {
            if (cc.type == CardType.DRIVING_ACE)
                hasSpeedLimit = false;
        }
        hasSpeedLimit = (hasSpeedLimit && speedTop.type == CardType.LIMIT);
        
        boolean canplay = true;
        switch(c.type)   {
            case D25:
            case D50:
                return isRolling();
            case D75:
            case D100:
                return (isRolling() && !hasSpeedLimit);
            case D200:
                if (isRolling() && !hasSpeedLimit && played200 < 2)
                    return true;
                else {
                    switch (battleTop.type) {
                        case ACCIDENT:
                        case EMPTY:
                        case FLAT:
                            return false;
                        default:
                            return !isRolling();
                    }
                }
            case ACCIDENT:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.RIGHT_OF_WAY)
                        canplay = false;
                return (canplay && isRolling());
            case EMPTY:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.EXTRA_TANK)
                        canplay = false;
                return (canplay && isRolling());
            case FLAT:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.PUNCTURE_PROOF)
                        canplay = false;
                return (canplay && isRolling());
            case STOP:
                return isRolling();
            case LIMIT:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.DRIVING_ACE)
                        canplay = false;
                return (canplay && speedTop.type != CardType.LIMIT);
            case END_LIMIT:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.DRIVING_ACE)
                        canplay = false;
                return (canplay && speedTop.type == CardType.LIMIT);
            case GAS:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.EXTRA_TANK)
                        canplay = false;
                return (canplay && battleTop.type == CardType.EMPTY);
            case REPAIR:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.RIGHT_OF_WAY)
                        canplay = false;
                return (canplay && battleTop.type == CardType.ACCIDENT);
            case ROLL:
                switch (battleTop.type) {
                    case STOP:
                    case GAS:
                    case REPAIR:
                    case SPARE:
                        return true;
                    case ACCIDENT:
                    case EMPTY:
                    case FLAT:
                        return false;
                    default:
                        return !isRolling();
                }
            case SPARE:
                for (Card cc : safetyPile)
                    if (cc.type == CardType.PUNCTURE_PROOF)
                        canplay = false;
                return (canplay && battleTop.type == CardType.FLAT);
            case ROAD_SERVICE:
                return !isRolling() || hasSpeedLimit;
            case DRIVING_ACE:
            case PUNCTURE_PROOF:
            case RIGHT_OF_WAY:
            case EXTRA_TANK:
                return true;
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
        Card battleTop;
        if (! battlePile.isEmpty())
            battleTop = battlePile.get(battlePile.size() - 1);
        else
            return false;
        
        switch (battleTop.type) {
            case ROAD_SERVICE:
            case ROLL:
            case D200:
                return true;
            case ACCIDENT:
                for (Card c : safetyPile)
                    if (c.type == CardType.RIGHT_OF_WAY)
                        return true;
                return false;
            case EMPTY:
                for (Card c : safetyPile)
                    if (c.type == CardType.EXTRA_TANK)
                        return true;
                return false;
            case FLAT:
                for (Card c : safetyPile)
                    if (c.type == CardType.PUNCTURE_PROOF)
                        return true;
                return false;
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
        g.setColor(Color.BLACK);
        
        if (distancePile.isEmpty()) {
            g.drawRect(x, y, Card.CARD_WIDTH, Card.CARD_HEIGHT);
            g.drawString("Dist", x + 1, y + Card.CARD_HEIGHT/2);
        } else {
            distancePile.get(distancePile.size() - 1).draw(g, x, y);
        }
        
        int currX = x + Card.CARD_WIDTH + 10;
        int currY = y;
        
        if (battlePile.isEmpty()) {
            g.drawRect(currX, currY, Card.CARD_WIDTH, Card.CARD_HEIGHT);
            g.drawString("Battle", currX + 1, currY + Card.CARD_HEIGHT/2);
        } else {
            battlePile.get(battlePile.size() - 1).draw(g, currX, currY);
        }
        
        currX += Card.CARD_WIDTH + 10;
        
        if (speedPile.isEmpty()) {
            g.drawRect(currX, currY, Card.CARD_WIDTH, Card.CARD_HEIGHT);
            g.drawString("Speed", currX + 1, currY + Card.CARD_HEIGHT/2);
        } else {
            speedPile.get(speedPile.size() - 1).draw(g, currX, currY);
        }
        
        currX = x;
        currY += Card.CARD_HEIGHT + 10;
        
        for (int i = 0; i < safetyPile.size(); i++) {
            safetyPile.get(i).draw(g, currX + 10*i + (Card.CARD_WIDTH*i), currY);
        }
    }
    
    /**
     * Get the icon of the top card of a tableau pile.
     * 
     * @param pile Which of the three valid piles to retrieve.
     * @return An <code>ImageIcon</code> of the top card of the pile.
     */
    public ImageIcon getTableauIcon(int pile) {
        Card top;
        
        switch (pile) {
            case BATTLE:
                if (! battlePile.isEmpty())
                    top = battlePile.get(battlePile.size() - 1);
                else
                    return null;
                break;
            case DISTANCE:
                if (! distancePile.isEmpty())
                    top = distancePile.get(distancePile.size() - 1);
                else
                    return null;
                break;
            case SPEED:
                if (! speedPile.isEmpty())
                    top = speedPile.get(speedPile.size() - 1);
                else
                    return null;
                break;
            default:
                return null;
        }
        
        if (top.sprite == null)
            top.loadImage();
        return new ImageIcon(top.sprite.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST));
    }
    
    /**
     * Get the icons of all played safety cards in a collection.
     * 
     * @return An <code>ArrayList</code> of <code>ImageIcon</code>s of the cards 
     * in the safety pile.
     */
    public ArrayList<ImageIcon> getSafetyIcons() {
        ArrayList<ImageIcon> back = new ArrayList<ImageIcon>();
        for (Card c : safetyPile) {
            if (c.sprite == null)
                c.loadImage();
            back.add(new ImageIcon(c.sprite.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST)));
        }
        
        return back;
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
