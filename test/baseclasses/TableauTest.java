/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author jacky
 */
public class TableauTest {

    /**
     * Test of playCard method, of class Tableau.
     */
    @Test
    public void testPlayCard() throws Exception {
        System.out.println("playCard");
        Tableau instance = new Tableau();
        //  All tests should evaluate to true
        for (CardType ct : CardType.values()) {
            switch (ct) {
                case ACCIDENT:
                case EMPTY:
                case FLAT:
                case STOP:
                    instance.playToBattle(new Card(CardType.ROLL));
                    break;
                case LIMIT:
                    instance.playToSpeed(new Card(CardType.END_LIMIT));
                    break;
                case REPAIR:
                    instance.playToBattle(new Card(CardType.ACCIDENT));
                    break;
                case GAS:
                    instance.playToBattle(new Card(CardType.EMPTY));
                    break;
                case SPARE:
                    instance.playToBattle(new Card(CardType.FLAT));
                    break;
                case ROLL:
                    instance.playToBattle(new Card(CardType.STOP));
                    break;
                case END_LIMIT:
                    instance.playToBattle(new Card(CardType.LIMIT));
                    break;
                case D25:
                case D50:
                case D75:
                case D100:
                case D200:
                    instance.playToBattle(new Card(CardType.ROLL));
                    break;
                case ROAD_SERVICE:
                    instance.playToBattle(new Card(CardType.STOP));
                    instance.playToSpeed(new Card(CardType.LIMIT));
                    break;
            }
            if (ct != CardType.BLANK_CARD) {
                try {
                    instance.playCard(new Card(ct));
                    assert true;
                } catch (Exception ex) {
                    fail();
                }
            }
        }
        
        //  All method calls should throw exception
        for (CardType ct : CardType.values()) {
            switch (ct) {
                case ACCIDENT:
                case EMPTY:
                case FLAT:
                case STOP:
                case REPAIR:
                case GAS:
                case SPARE:
                case ROLL:
                    instance.playToBattle(new Card(ct));
                    break;
                case LIMIT:
                case END_LIMIT:
                    instance.playToSpeed(new Card(ct));
                    break;
                case D25:
                case D50:
                case D75:
                case D100:
                    instance.playToBattle(new Card(CardType.STOP));
                    break;
                case D200:
                    instance.playToBattle(new Card(CardType.ROLL));
                    instance.played200 = 2;
                    break;
                case ROAD_SERVICE:
                    instance.playToBattle(new Card(CardType.ROLL));
                    instance.playToSpeed(new Card(CardType.END_LIMIT));
                    break;
            }
            
            if (ct != CardType.RIGHT_OF_WAY && ct != CardType.DRIVING_ACE &&
                    ct != CardType.PUNCTURE_PROOF && ct != CardType.EXTRA_TANK &&
                    ct != CardType.BLANK_CARD) {
                try {
                    instance.playCard(new Card(ct));
                    fail();
                } catch(Exception ex) {
                    assert true;
                }
            }
        }
    }

    /**
     * Test of playToSafety method, of class Tableau.
     */
    @Ignore
    @Test
    public void testPlayToSafety() {
        System.out.println("playToSafety");
    }

    /**
     * Test of playCoupFourre method, of class Tableau.
     */
    @Ignore
    @Test
    public void testPlayCoupFourre() {
        System.out.println("playCoupFourre");
    }

    /**
     * Test of playToSpeed method, of class Tableau.
     */
    @Ignore
    @Test
    public void testPlayToSpeed() {
        System.out.println("playToSpeed");
    }

    /**
     * Test of playToBattle method, of class Tableau.
     */
    @Ignore
    @Test
    public void testPlayToBattle() {
        System.out.println("playToBattle");
    }

    /**
     * Test of playToDistance method, of class Tableau.
     */
    @Ignore
    @Test
    public void testPlayToDistance() {
        System.out.println("playToDistance");
    }

    /**
     * Test of shuffleNewDeck method, of class Tableau.
     */
    @Test
    public void testShuffleNewDeck() {
        System.out.println("shuffleNewDeck");
        Tableau instance = new Tableau();
        instance.playToBattle(new Card(CardType.BLANK_CARD));
        instance.playToBattle(new Card(CardType.BLANK_CARD));
        instance.playToDistance(new Card(CardType.BLANK_CARD));
        instance.playToDistance(new Card(CardType.BLANK_CARD));
        instance.playToSafety(new Card(CardType.BLANK_CARD));
        instance.playToSafety(new Card(CardType.BLANK_CARD));
        instance.playToSpeed(new Card(CardType.BLANK_CARD));
        instance.playToSpeed(new Card(CardType.BLANK_CARD));
        ArrayList<Card> shuffle = instance.shuffleNewDeck();
        
        int expLength = 4;
        assertEquals(shuffle.size(), expLength);
        for (Card c : shuffle) {
            assertTrue(c.type == CardType.BLANK_CARD);
        }
    }

    /**
     * Test of validMove method, of class Tableau.
     */
    @Ignore
    @Test
    public void testValidMove() {
        System.out.println("validMove");
    }

    /**
     * Test of isRolling method, of class Tableau.
     */
    @Test
    public void testIsRolling() {
        System.out.println("isRolling");
        Tableau instance = new Tableau();
        for (CardType ct : CardType.values()) {
            switch (ct) {
                case ACCIDENT:
                case EMPTY:
                case FLAT:
                case STOP:
                    instance.playToBattle(new Card(ct));
                    assertFalse(instance.isRolling());
                    break;
                case D200:
                case ROAD_SERVICE:
                case ROLL:
                    instance.playToBattle(new Card(ct));
                    assertTrue(instance.isRolling());
                    break;
            }
        }
    }

    /**
     * Test of draw method, of class Tableau.
     */
    @Test
    public void testDraw_3args() {
        System.out.println("draw");
        final Tableau instance = new Tableau();
        JFrame frame = new JFrame();
        frame.setBackground(Game.BACKGROUND);
        instance.playToBattle(new Card(CardType.ROLL));
        instance.playToDistance(new Card(CardType.D25));
        instance.playToSpeed(new Card(CardType.END_LIMIT));
        instance.playToSafety(new Card(CardType.DRIVING_ACE));
        instance.playCoupFourre(new Card(CardType.EXTRA_TANK));
        
        frame.add(new JComponent() {
           @Override
           public void paintComponent(Graphics g) {
               g.setColor(Game.BACKGROUND);
               g.fillRect(0, 0, 1000, 1000);
               instance.draw(g, 0, 0);
           } 
        });
        
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        while (frame.isVisible()) {}
        assertTrue(true);
    }

    /**
     * Test of draw method, of class Tableau.
     */
    @Ignore
    @Test
    public void testDraw_0args() {
        System.out.println("draw");
        Tableau instance = new Tableau();
        String expResult = "";
        String result = instance.draw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
