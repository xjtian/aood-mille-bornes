package baseclasses;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
     * Creates a new <code>Card</code> object without an image at time of 
     * instantiation.
     * 
     * @param type The <code>CardType</code> of the card.
     */
    public Card(CardType type) {
        this.type = type;
        sprite = null;
        sideways = false;
    }
    
    /**
     * Read in the image of the card as a BufferedImage. This method MUST be called 
     * before an invocation of <code>draw()</code>.
     * 
     * @return True if the operation worked, false if an exception was encountered.
     */
    public boolean loadImage() {
        try {
            sprite = ImageIO.read(getClass().getResource("baseclasses/resources/" + type.getPath()));
        } catch (IOException ex) {
            sprite = null;
            return false;
        }
        
        if (sideways)
            rotateSprite();
        
        return true;
    }
    
    /**
     * Turns the card sideways, as in a coup-fourre.
     */
    public void turnSideways() {
        sideways = true;
        if (sprite != null) {
            rotateSprite();
        }
    }
    
    private void rotateSprite() {
        int w = sprite.getWidth();
        int h = sprite.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, sprite.getType());
        Graphics2D g = dimg.createGraphics();
        g.rotate(Math.toRadians(90.0), w/2, h/2);
        g.drawImage(sprite, null, 0, 0);
        sprite = dimg;
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
        g.drawImage(sprite, x, y, CARD_WIDTH, CARD_HEIGHT, null);
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
