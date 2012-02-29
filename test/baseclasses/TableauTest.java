/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;

/**
 *
 * @author xtian8741
 */
public class TableauTest {
    
    public TableauTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class Tableau.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Card c = null;
        Tableau instance = new Tableau();
        instance.play(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playToSafety method, of class Tableau.
     */
    @Test
    public void testPlayToSafety() {
        System.out.println("playToSafety");
        Card c = null;
        Tableau instance = new Tableau();
        instance.playToSafety(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playCoupFourre method, of class Tableau.
     */
    @Test
    public void testPlayCoupFourre() {
        System.out.println("playCoupFourre");
        Card c = null;
        Tableau instance = new Tableau();
        instance.playCoupFourre(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playToSpeed method, of class Tableau.
     */
    @Test
    public void testPlayToSpeed() {
        System.out.println("playToSpeed");
        Card c = null;
        Tableau instance = new Tableau();
        instance.playToSpeed(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playToBattle method, of class Tableau.
     */
    @Test
    public void testPlayToBattle() {
        System.out.println("playToBattle");
        Card c = null;
        Tableau instance = new Tableau();
        instance.playToBattle(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playToDistance method, of class Tableau.
     */
    @Test
    public void testPlayToDistance() {
        System.out.println("playToDistance");
        Card c = null;
        Tableau instance = new Tableau();
        instance.playToDistance(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleNewDeck method, of class Tableau.
     */
    @Test
    public void testShuffleNewDeck() {
        System.out.println("shuffleNewDeck");
        Tableau instance = new Tableau();
        ArrayList expResult = null;
        ArrayList result = instance.shuffleNewDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validMove method, of class Tableau.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        Card c = null;
        Tableau instance = new Tableau();
        boolean expResult = false;
        boolean result = instance.validMove(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRolling method, of class Tableau.
     */
    @Test
    public void testIsRolling() {
        System.out.println("isRolling");
        Tableau instance = new Tableau();
        boolean expResult = false;
        boolean result = instance.isRolling();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Tableau.
     */
    @Test
    public void testDraw_3args() {
        System.out.println("draw");
        Graphics g = null;
        int x = 0;
        int y = 0;
        Tableau instance = new Tableau();
        instance.draw(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Tableau.
     */
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
