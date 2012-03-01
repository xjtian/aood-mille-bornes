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
public final class Card {
    
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
    public static final int CARD_HEIGHT = 69;
    /**
     * Pixel width of all cards when drawn.
     */
    public static final int CARD_WIDTH = 50;
    
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
            sprite = ImageIO.read(Card.class.getClass().getResource("/baseclasses/resources/" + type.getPath()));
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
        BufferedImage dimg = new BufferedImage(w, h, 5);
        Graphics2D g = dimg.createGraphics();
        g.rotate(Math.PI/2, w/2, h/2);
        g.drawImage(sprite, null, 0, 0);
        
        sprite = dimg;
    }
    
    /**
     * Paints the card on a given component.
     * 
     * This method will draw the card sized as defined by <code>CARD_WIDTH</code> 
     * and <code>CARD_HEIGHT</code>. If the image has not been loaded yet, this 
     * method loads it.
     * 
     * @param g The graphics object of the component to paint on.
     * @param x The x-coordinate of the upper-left corner of the card.
     * @param y The y-coordinate of the upper-left corner of the card.
     */
    public void draw(Graphics g, int x, int y) {
        if (sprite == null)
            loadImage();
        g.drawImage(sprite, x, y, CARD_WIDTH, CARD_HEIGHT, null);
    }
    
    /**
     * Draw the card as ASCII-art.
     * 
     * @return An ASCII image of the card.
     */
    public String draw() {
        switch(type)    {
            case D25:
                return "D25";
            case D50:
                return "D50";
            case D75:
                return "D75";
            case D100:
                return "D100";
            case D200:
                return "D200";
            case STOP:
                return "!st";
            case EMPTY:
                return "!emp";
            case FLAT:
                return "!fl";
            case ACCIDENT:
                return "!ac";
            case LIMIT:
                return "!lim";
            case ROAD_SERVICE:
                return "rd_srv";
            case GAS:
                return "*gs";
            case SPARE:
                return "*sp";
            case END_LIMIT:
                return "*end_lm";
            case REPAIR:
                return "*rp";
            case ROLL:
                return "GO";
            default:
                return "_";
        }
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
