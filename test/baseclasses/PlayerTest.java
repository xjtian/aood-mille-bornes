/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author xtian8741
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Player instance = new Player();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCard method, of class Player.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        int i = 0;
        Player instance = new Player();
        Card expResult = null;
        Card result = instance.getCard(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playCard method, of class Player.
     */
    @Test
    public void testPlayCard() {
        System.out.println("playCard");
        int i = 0;
        Player instance = new Player();
        Card expResult = null;
        Card result = instance.playCard(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandSize method, of class Player.
     */
    @Test
    public void testGetHandSize() {
        System.out.println("getHandSize");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getHandSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawHand method, of class Player.
     */
    @Test
    public void testDrawHand_3args() {
        System.out.println("drawHand");
        Graphics g = null;
        int x = 0;
        int y = 0;
        Player instance = new Player();
        instance.drawHand(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawHand method, of class Player.
     */
    @Test
    public void testDrawHand_0args() {
        System.out.println("drawHand");
        Player instance = new Player();
        String expResult = "";
        String result = instance.drawHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCard method, of class Player.
     */
    @Test
    public void testDrawCard() {
        System.out.println("drawCard");
        Card c = null;
        Player instance = new Player();
        instance.drawCard(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
