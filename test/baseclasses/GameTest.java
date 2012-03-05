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
 * @author Jacky Tian
 */
public class GameTest {
    
    public GameTest() {
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
     * Test of setPlayerName method, of class Game.
     */
    @Test
    public void testSetPlayerName() {
        System.out.println("setPlayerName");
        String name = "";
        Game instance = new Game();
        instance.setPlayerName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerName method, of class Game.
     */
    @Test
    public void testGetPlayerName() throws Exception {
        System.out.println("getPlayerName");
        int player = 0;
        Game instance = new Game();
        String expResult = "";
        String result = instance.getPlayerName(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMove method, of class Game.
     */
    @Test
    public void testValidateMove() throws Exception {
        System.out.println("validateMove");
        int player = 0;
        int card = 0;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.validateMove(player, card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeMove method, of class Game.
     */
    @Test
    public void testMakeMove() throws Exception {
        System.out.println("makeMove");
        int player = 0;
        int card = 0;
        Game instance = new Game();
        instance.makeMove(player, card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateCPUMove method, of class Game.
     */
    @Test
    public void testGenerateCPUMove() {
        System.out.println("generateCPUMove");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.generateCPUMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllValidPlays method, of class Game.
     */
    @Test
    public void testGetAllValidPlays() throws Exception {
        System.out.println("getAllValidPlays");
        int player = 0;
        Game instance = new Game();
        boolean[] expResult = null;
        boolean[] result = instance.getAllValidPlays(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawAllCards method, of class Game.
     */
    @Test
    public void testDrawAllCards() {
        System.out.println("drawAllCards");
        Game instance = new Game();
        instance.drawAllCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCard method, of class Game.
     */
    @Test
    public void testDrawCard() throws Exception {
        System.out.println("drawCard");
        int player = 0;
        Game instance = new Game();
        instance.drawCard(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discard method, of class Game.
     */
    @Test
    public void testDiscard() throws Exception {
        System.out.println("discard");
        int player = 0;
        int card = 0;
        Game instance = new Game();
        instance.discard(player, card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quit method, of class Game.
     */
    @Test
    public void testQuit() {
        System.out.println("quit");
        Game instance = new Game();
        instance.quit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Game.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Game instance = new Game();
        Game expResult = null;
        Game result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Game.
     */
    @Test
    public void testDraw_0args() {
        System.out.println("draw");
        Game instance = new Game();
        String expResult = "";
        String result = instance.draw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Game.
     */
    @Test
    public void testDraw_Graphics() {
        System.out.println("draw");
        Graphics g = null;
        Game instance = new Game();
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
