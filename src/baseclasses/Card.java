package baseclasses;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A card object for the game.
 * 
 * This class can only take on types as defined in the <code>CardType</code> enum. 
 * This is to ensure that only the cards legal for play in Mille Bornes are ever 
 * instantiated. 
 * 
 * @author Jacky Tian
 */
public class Card {
    
    /**
     * Which card this card is. Also contains information such as name.
     */
    protected CardType type;
    private BufferedImage sprite;
    /**
     * Whether or not the card is played as a coup-fourre.
     */
    protected boolean sideways;
    /**
     * Pixel height of all cards when drawn.
     */
    public static final int CARD_HEIGHT = 688;
    /**
     * Pixel width of all cards when drawn.
     */
    public static final int CARD_WIDTH = 500;
    
    /**
     * Creates a new <code>Card</code> object and reads in the appropriate sprite 
     * as defined by the type as a buffered image.
     * 
     * If, for some reason, there is an error reading the image at the specified 
     * path, the sprite for the card is set to null.
     * 
     * @param type The <code>CardType</code> of the card.
     */
    public Card(CardType type) {
        this.type = type;
        try {
            sprite = ImageIO.read(new File("images\\" + type.getPath()));
        } catch (IOException ex) {
            sprite = null;
        }
        sideways = false;
    }
    
    /**
     * Turns the card sideways, as in a coup-fourre.
     */
    public void turnSidways() {
        sideways = ! sideways;
    }
    
    /**
     * Paints the card on a given component.
     * 
     * This method will draw the card sized as defined by <code>CARD_WIDTH</code> 
     * and <code>CARD_HEIGHT</code>.
     * 
     * @param g The graphics object of the component to paint on.
     * @param x The x-coordinate of the upper-left corner of the card.
     * @param y The y-coordinate of the upper-left corner of the card.
     */
    public void draw(Graphics g, int x, int y) {
        if (!sideways)
            g.drawImage(sprite, x, y, CARD_WIDTH, CARD_HEIGHT, null);
        else
            g.drawImage(sprite, x, y, CARD_HEIGHT, CARD_WIDTH, null);
    }
    
    /**
     * Draw the card as ASCII-art.
     * 
     * @return An ASCII image of the card.
     */
    public String draw() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
    
    /**
     * Get a string representing the card.
     * 
     * @return The type of the card as a String.
     */
    @Override
    public String toString() {
        return type.toString();
    }
}
