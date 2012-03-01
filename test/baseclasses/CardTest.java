/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mhemle3133
 */
public class CardTest {
    
    public CardTest() {
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
        JFrame frame = new JFrame();
        final Card instance = new Card(CardType.D100);
        instance.loadImage();
        instance.turnSideways();
        
        frame.add(new JComponent() {
           public void paintComponent(Graphics g) {
               instance.draw(g, 0, 0);
           } 
        });
        
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        while (frame.isVisible()){}
        assertTrue("Is the Card Sideways?", true);
    }

    /**
     * Test of draw method, of class Card.
     */
    @Test
    public void testDraw_3args() {
        System.out.println("draw");
//        Graphics g = null;
//        int x = 0;
//        int y = 0;
//        Card instance = null;
//        instance.draw(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Card.
     */
    @Test
    public void testDraw_0args() {
        System.out.println("draw");
//        Card instance = null;
//        String expResult = "";
//        String result = instance.draw();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
//        Card instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
