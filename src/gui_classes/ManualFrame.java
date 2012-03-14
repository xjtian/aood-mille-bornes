/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_classes;

import baseclasses.Card;
import baseclasses.Game;
import baseclasses.Tableau;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author xtian8741
 */
public class ManualFrame extends javax.swing.JFrame {
    
    private Game game;

    /**
     * Creates new form LayoutForm
     */
    public ManualFrame() {
        game = new Game();
        game.drawAllCards();
        initComponents();
        
        startGame();
    }
    
    private void regenIcons() {
        card1.setIcon(game.getCardIcon(0));
        card2.setIcon(game.getCardIcon(1));
        card3.setIcon(game.getCardIcon(2));
        card4.setIcon(game.getCardIcon(3));
        card5.setIcon(game.getCardIcon(4));
        card6.setIcon(game.getCardIcon(5));
        card7.setIcon(game.getCardIcon(6));
    }
    
    private void startGame() {
        game.drawCard(Game.HUMAN);
        regenIcons();
    }
    
    private void resetCards() {
	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(playingArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playingArea, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
    }

    private void initComponents() {

        card1 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        card3 = new javax.swing.JLabel();
        card4 = new javax.swing.JLabel();
        card5 = new javax.swing.JLabel();
        card6 = new javax.swing.JLabel();
        card7 = new javax.swing.JLabel();
        playingArea = new PlayingPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 620));
		
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                    cardReleased(evt);
            }
            @Override
            public void mouseDragged(MouseEvent evt) {
                    cardDragged(evt);
            }
        };
        
        Dimension cardsize = new Dimension(Card.CARD_WIDTH, Card.CARD_HEIGHT);
		
        card1.setPreferredSize(cardsize);
	card2.setPreferredSize(cardsize);
        card3.setPreferredSize(cardsize);
        card4.setPreferredSize(cardsize);
        card5.setPreferredSize(cardsize);
        card6.setPreferredSize(cardsize);
        card7.setPreferredSize(cardsize);
		
        card1.addMouseListener(ma);
        card1.addMouseMotionListener(ma);
        card2.addMouseListener(ma);
        card2.addMouseMotionListener(ma);
        card3.addMouseListener(ma);
        card3.addMouseMotionListener(ma);
        card4.addMouseListener(ma);
        card4.addMouseMotionListener(ma);
        card5.addMouseListener(ma);
        card5.addMouseMotionListener(ma);
        card6.addMouseListener(ma);
        card6.addMouseMotionListener(ma);
        card7.addMouseListener(ma);
        card7.addMouseMotionListener(ma);

        resetCards();
        pack();
    }

    private void makeUserMove(int card) {
        try {
            game.makeMove(Game.HUMAN, card);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Move!", "Wrong", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        game.drawCard(Game.HUMAN);
        
        regenIcons();
        playingArea.updateTableaus();
        makeAIMove();
    }
    
    private void makeUserDiscard(int card) {
        game.discard(Game.HUMAN, card);
        game.drawCard(Game.HUMAN);
        
        regenIcons();
        playingArea.updateTableaus();
        checkWin();
        makeAIMove();
    }
    
    private void makeAIMove() {
        game.drawCard(Game.CPU);
        int aichoice = game.generateCPUMove();
        
        if (aichoice == -1) {
            game.discard(Game.CPU, new Random().nextInt(6));
        } else {
            try {
                game.makeMove(Game.CPU, aichoice);
            } catch (Exception ex) {
                System.out.println("Major error.");
            }
        }
        playingArea.updateTableaus();
        checkWin();
    }
    
    private void checkWin() {
        switch (game.isOver()) {
            case Game.CPU:
                JOptionPane.showMessageDialog(this, "The Computer Wins!", "Loser", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
            case Game.HUMAN:
                JOptionPane.showMessageDialog(this, "You Win!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
        }
    }
    
    private void cardDragged(MouseEvent evt) {
        Point drag = evt.getLocationOnScreen();
        drag.translate(- this.getLocationOnScreen().x, - this.getLocationOnScreen().y);
        evt.getComponent().setLocation(drag);
    }
    
    private void cardReleased(MouseEvent evt) {
        JLabel which = (JLabel) evt.getComponent();
        int choice = 0;
        if (which == card1)
            choice = 0;
        else if (which == card2)
            choice = 1;
        else if (which == card3)
            choice = 2;
        else if (which == card4)
            choice = 3;
        else if (which == card5)
            choice = 4;
        else if (which == card6)
            choice = 5;
        else if (which == card7)
            choice = 6;
        
        int y = which.getY();
        resetCards();
        
        if (y < 550) {
            makeUserMove(choice);
        } else {
            makeUserDiscard(choice);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ManualFrame().setVisible(true);
            }
        });
    }
    
    private JLabel card1;
    private JLabel card2;
    private JLabel card3;
    private JLabel card4;
    private JLabel card5;
    private JLabel card6;
    private JLabel card7;
    private PlayingPanel playingArea;

    private class PlayingPanel extends javax.swing.JPanel {

        public PlayingPanel() {
            initComponents();
        }

        private void initComponents() {
            cpuDist = new javax.swing.JLabel();
            cpuBattle = new javax.swing.JLabel();
            cpuSpeed = new javax.swing.JLabel();
            cpuSafe1 = new javax.swing.JLabel();
            cpuSafe2 = new javax.swing.JLabel();
            cpuSafe3 = new javax.swing.JLabel();
            cpuSafe4 = new javax.swing.JLabel();
            hDist = new javax.swing.JLabel();
            hBattle = new javax.swing.JLabel();
            hSpeed = new javax.swing.JLabel();
            hSafe1 = new javax.swing.JLabel();
            hSafe2 = new javax.swing.JLabel();
            hSafe3 = new javax.swing.JLabel();
            hSafe4 = new javax.swing.JLabel();
            cpuMileLbl = new javax.swing.JLabel();
            hMileLbl = new javax.swing.JLabel();

            setPreferredSize(new java.awt.Dimension(385, 410));

            Dimension cardsize = new Dimension(Card.CARD_WIDTH, Card.CARD_HEIGHT);

            cpuDist.setPreferredSize(cardsize);
            cpuBattle.setPreferredSize(cardsize);
            cpuSpeed.setPreferredSize(cardsize);
            cpuSafe1.setPreferredSize(cardsize);
            cpuSafe2.setPreferredSize(cardsize);
            cpuSafe3.setPreferredSize(cardsize);
            cpuSafe4.setPreferredSize(cardsize);
            hDist.setPreferredSize(cardsize);
            hBattle.setPreferredSize(cardsize);
            hSpeed.setPreferredSize(cardsize);
            hSafe1.setPreferredSize(cardsize);
            hSafe2.setPreferredSize(cardsize);
            hSafe3.setPreferredSize(cardsize);
            hSafe4.setPreferredSize(cardsize);

            setBorder(javax.swing.BorderFactory.createEtchedBorder());

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cpuDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cpuBattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cpuSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cpuMileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hMileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cpuSafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(hSafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(hSafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(hSafe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(hSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(hDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(hBattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(hSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 111, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpuDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpuBattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpuSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cpuMileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(hMileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpuSafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpuSafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpuSafe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpuSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hBattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hSafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hSafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hSafe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
        }
        
        public void updateTableaus() {
            cpuBattle.setIcon(game.getTableauIcon(Game.CPU, Tableau.BATTLE));
            cpuDist.setIcon(game.getTableauIcon(Game.CPU, Tableau.DISTANCE));
            cpuSpeed.setIcon(game.getTableauIcon(Game.CPU, Tableau.SPEED));
            ArrayList<ImageIcon> cpuicons = game.getSafetyIcons(Game.CPU);
            switch (cpuicons.size()) {
                case 4: cpuSafe4.setIcon(cpuicons.get(3));
                case 3: cpuSafe3.setIcon(cpuicons.get(2));
                case 2: cpuSafe2.setIcon(cpuicons.get(1));
                case 1: cpuSafe1.setIcon(cpuicons.get(0)); break;
            }
            
            hBattle.setIcon(game.getTableauIcon(Game.HUMAN, Tableau.BATTLE));
            hDist.setIcon(game.getTableauIcon(Game.HUMAN, Tableau.DISTANCE));
            hSpeed.setIcon(game.getTableauIcon(Game.HUMAN, Tableau.SPEED));
            ArrayList<ImageIcon> hicons = game.getSafetyIcons(Game.HUMAN);
            switch (hicons.size()) {
                case 4: hSafe4.setIcon(hicons.get(3));
                case 3: hSafe3.setIcon(hicons.get(2));
                case 2: hSafe2.setIcon(hicons.get(1));
                case 1: hSafe1.setIcon(hicons.get(0)); break;
            }
            
            cpuMileLbl.setText("CPU Miles: " + game.getMiles(Game.CPU));
            hMileLbl.setText("Human Miles: " + game.getMiles(Game.HUMAN));
        }
        
        private JLabel cpuBattle;
        private JLabel cpuDist;
        private JLabel cpuSafe1;
        private JLabel cpuSafe2;
        private JLabel cpuSafe3;
        private JLabel cpuSafe4;
        private JLabel cpuSpeed;
        private JLabel hBattle;
        private JLabel hDist;
        private JLabel hSafe1;
        private JLabel hSafe2;
        private JLabel hSafe3;
        private JLabel hSafe4;
        private JLabel hSpeed;
        private JLabel cpuMileLbl;
        private JLabel hMileLbl;
    }
}
