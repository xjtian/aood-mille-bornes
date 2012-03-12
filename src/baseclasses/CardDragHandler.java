/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author jacky
 */
public class CardDragHandler extends MouseAdapter {
    private boolean done;
    private final Object lock = new Object();
    private int cardNumber;
    
    public CardDragHandler(int card) {
        done = false;
        cardNumber = card;
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        me.getComponent().setBounds(me.getXOnScreen(), me.getYOnScreen(), Card.CARD_WIDTH, Card.CARD_HEIGHT);
        
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
        synchronized(lock) {
            done = true;
        }
    }
    
    public boolean isDone() {
        synchronized(lock) {
            return done;
        }
    }
    
    public int getCardNumber() {
        return cardNumber;
    }
}
