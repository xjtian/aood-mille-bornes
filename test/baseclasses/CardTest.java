/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit test class for <code>Card</code>. Graphic-based methods automatically 
 * assert to true - it is up to the tester to determine if the cards are painted 
 * correctly. 
 * 
 * @author Jacky Tian, Matt Hemler, Ben Ferguson, Evan M.
 */
public class CardTest {

    /**
     * Test of loadImage method, of class Card.
     */
    @Test
    public void testLoadImage() {
        System.out.println("loadImage");
        Card instance = new Card(CardType.D200);
        boolean expResult = true;
        boolean result = instance.loadImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of turnSideways method, of class Card.
     */
    @Test
    public void testTurnSideways() {
        System.out.println("turnSideways");
        final Card[] allSprites = new Card[CardType.values().length - 1];
        for (int i = 0; i < CardType.values().length - 1; i++) {
            allSprites[i] = new Card(CardType.values()[i]);
            allSprites[i].turnSideways();
        }
        
        JFrame frame = new JFrame();
        frame.add(new JComponent() {
           public void paintComponent(Graphics g) {
               for (int i = 0; i < allSprites.length; i++) {
                   allSprites[i].draw(g, 0+(Card.CARD_WIDTH*(i%6)), 0+(Card.CARD_HEIGHT*(i/6)));
               }
           } 
        });
        
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        while (frame.isVisible()) {}
        assertTrue(true);
    }

    /**
     * Test of draw method, of class Card.
     */
    @Test
    public void testDraw_3args() {
        System.out.println("draw");
        final Card[] allSprites = new Card[CardType.values().length - 1];
        for (int i = 0; i < CardType.values().length - 1; i++) {
            allSprites[i] = new Card(CardType.values()[i]);
        }
        
        JFrame frame = new JFrame();
        frame.add(new JComponent() {
           public void paintComponent(Graphics g) {
               for (int i = 0; i < allSprites.length; i++) {
                   allSprites[i].draw(g, 0+(Card.CARD_WIDTH*(i%6)), 0+(Card.CARD_HEIGHT*(i/6)));
               }
           } 
        });
        
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        while (frame.isVisible()) {}
        assertTrue(true);
    }

    /**
     * Test of draw method, of class Card.
     */
    @Test
    public void testDraw_0args() {
        System.out.println("draw");
        Card instance;
        String expResult;
        String result;
        for (CardType ct : CardType.values()) {
            instance = new Card(ct);
            expResult = ct.getArt();
            result = instance.draw();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance;
        String expResult;
        String result;
        
        for (CardType ct : CardType.values()) {
            instance = new Card(ct);
            expResult = ct.toString();
            result = instance.toString();
            assertEquals(expResult, result);
        }
    }
}
