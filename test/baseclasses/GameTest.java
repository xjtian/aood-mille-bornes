/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Jacky Tian
 */
public class GameTest {
    
    private Game game;
    
    public GameTest() {
        game = new Game();
    }

    /**
     * Test of setPlayerName method, of class Game.
     */
    @Ignore
    @Test
    public void testSetPlayerName() {
        System.out.println("setPlayerName");
        game.setPlayerName("Test");
        String expResult = "Test";
        String result;
        try {
            result = game.getPlayerName(Game.HUMAN);
        } catch (Exception ex) {
            result = "blah";
        }
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerName method, of class Game.
     */
    @Ignore
    @Test
    public void testGetPlayerName() throws Exception {
        System.out.println("getPlayerName");
    }

    /**
     * Test of validateMove method, of class Game.
     */
    @Ignore
    @Test
    public void testValidateMove() throws Exception {
        System.out.println("validateMove");
    }

    /**
     * Test of makeMove method, of class Game.
     */
    @Ignore
    @Test
    public void testMakeMove() throws Exception {
        System.out.println("makeMove");
    }

    /**
     * Test of generateCPUMove method, of class Game.
     */
    @Ignore
    @Test
    public void testGenerateCPUMove() {
        System.out.println("generateCPUMove");
    }

    /**
     * Test of getAllValidPlays method, of class Game.
     */
    @Ignore
    @Test
    public void testGetAllValidPlays() throws Exception {
        System.out.println("getAllValidPlays");
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Ignore
    @Test
    public void testIsOver() {
        System.out.println("isOver");
    }

    /**
     * Test of drawAllCards method, of class Game.
     */
    @Ignore
    @Test
    public void testDrawAllCards() {
        System.out.println("drawAllCards");
    }

    /**
     * Test of drawCard method, of class Game.
     */
    @Ignore
    @Test
    public void testDrawCard() throws Exception {
        System.out.println("drawCard");
    }

    /**
     * Test of discard method, of class Game.
     */
    @Ignore
    @Test
    public void testDiscard() throws Exception {
        System.out.println("discard");
    }

    /**
     * Test of quit method, of class Game.
     */
    @Ignore
    @Test
    public void testQuit() {
        System.out.println("quit");
    }

    /**
     * Test of save method, of class Game.
     */
    @Ignore
    @Test
    public void testSave() {
        System.out.println("save");
    }

    /**
     * Test of draw method, of class Game.
     */
    @Ignore
    @Test
    public void testDraw_0args() {
        System.out.println("draw");
    }

    /**
     * Test of draw method, of class Game.
     */
    @Test
    public void testDraw_Graphics() {
        game.drawAllCards();
        JFrame frame = new JFrame();
        frame.add(new JComponent() {
            public void paintComponent(Graphics g) {
                game.draw(g);
            }
        });
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        while(frame.isVisible()) {}
        assert true;
    }
}
