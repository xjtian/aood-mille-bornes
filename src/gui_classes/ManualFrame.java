/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_classes;

import baseclasses.Card;
import baseclasses.Game;
import baseclasses.Tableau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * Version 1.0 of the Mille Bournes game GUI.
 * 
 * @author Jacky Tian
 */
public class ManualFrame extends javax.swing.JFrame {
    
    private Game game;

    /**
     * Creates new form ManualFrame
     */
    public ManualFrame() {
        game = new Game();
        game.drawAllCards();
        String name = JOptionPane.showInputDialog(rootPane, "Your Name?");
        game.setPlayerName(name);
        initComponents();
        
        startGame();
    }
    
    private void save() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        String path = JOptionPane.showInputDialog(this, "Filename to save to?");
        path = path + ".ser";
        
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving game. May be invalid name.", 
                    "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void quit() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            game = null;
            this.dispose();
            System.exit(0);
        }
    }
    
    private void load() {
        FileInputStream fis;
        ObjectInputStream ois;
        
        String path = JOptionPane.showInputDialog(this, "Filename to load?");
        path = path + ".ser";
        
        Game temp;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            temp = (Game) ois.readObject();
            ois.close();
            
            game = temp;
            playingArea.updateTableaus();
            regenIcons();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Name", 
                    "Does Not Exist", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Game Class Not Found.\nContact Administrator.", 
                    "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void restart() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String playername = game.getPlayerName(Game.HUMAN);
            game = new Game();
            game.setPlayerName(playername);
            game.drawAllCards();
            game.drawCard(Game.HUMAN);
            
            playingArea.updateTableaus();
            regenIcons();
        }
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
    
    // <editor-fold defaultstate="collapsed" desc="Layout Methods">
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
        card1 = new CardLabel(0);
        card2 = new CardLabel(1);
        card3 = new CardLabel(2);
        card4 = new CardLabel(3);
        card5 = new CardLabel(4);
        card6 = new CardLabel(5);
        card7 = new CardLabel(6);
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
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
        
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem newgame = new JMenuItem("New Game");
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        
        fileMenu.setText("File");
        fileMenu.add(newgame);
        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(quit);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        resetCards();
        pack();
    }
    // </editor-fold>

    private void makeUserMove(int card) {
        int onceagain;
        try {
            onceagain = game.makeMove(Game.HUMAN, card);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Move!", "Wrong", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        game.drawCard(Game.HUMAN);
        
        regenIcons();
        playingArea.updateTableaus();
        if (onceagain != Game.SAFETY)
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
        int coup = Game.NORMAL;
        
        if (aichoice == -1) {
            game.discard(Game.CPU, new Random().nextInt(6));
        } else {
            try {
                coup = game.makeMove(Game.CPU, aichoice);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Major Logic Error. Exiting.\nSumbit a Ticket", 
                        "Oops", JOptionPane.ERROR_MESSAGE);
                game = null;
                this.dispose();
                System.exit(0);
            }
        }
        playingArea.updateTableaus();
        regenIcons();
        
        switch(coup) {
            case Game.COUP:
                int choice = JOptionPane.showConfirmDialog(this, "Play a Coup Fourre?", "Coup Possible", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    game.playCoupFourre();
                    game.drawCard(Game.HUMAN);
                    playingArea.updateTableaus();
                    regenIcons();
                }
                break;
            case Game.SAFETY:
                playingArea.updateTableaus();
                makeAIMove();
                break;
        }
        checkWin();
    }
    
    private void checkWin() {
        int choice;
        switch (game.isOver()) {
            case Game.CPU:
                choice = JOptionPane.showConfirmDialog(this, "The Computer Wins! Play Again?", "Loser", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    String name = game.getPlayerName(Game.HUMAN);
                    game = new Game();
                    game.drawAllCards();
                    game.setPlayerName(name);
                    game.drawCard(Game.HUMAN);
                    playingArea.updateTableaus();
                    regenIcons();
                } else {
                    this.dispose();
                    System.exit(0);
                }
                break;
            case Game.HUMAN:
                choice = JOptionPane.showConfirmDialog(this, "You Win! Play Again?", "Winner", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    String name = game.getPlayerName(Game.HUMAN);
                    game = new Game();
                    game.drawAllCards();
                    game.setPlayerName(name);
                    game.drawCard(Game.HUMAN);
                    playingArea.updateTableaus();
                    regenIcons();
                } else {
                    this.dispose();
                    System.exit(0);
                }
                break;
        }
    }
    
    private void cardDragged(MouseEvent evt) {
        Point drag = evt.getLocationOnScreen();
        drag.translate(- this.getLocationOnScreen().x, - this.getLocationOnScreen().y);
        evt.getComponent().setLocation(drag);
    }
    
    private void cardReleased(MouseEvent evt) {
        CardLabel which = (CardLabel) evt.getComponent();
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
    
    // GUI components for the form
    private CardLabel card1;
    private CardLabel card2;
    private CardLabel card3;
    private CardLabel card4;
    private CardLabel card5;
    private CardLabel card6;
    private CardLabel card7;
    private PlayingPanel playingArea;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    
    private class CardLabel extends JLabel {
        
        private int number;
        
        public CardLabel(int n) {
            super();
            number = n;
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (game.validateMove(Game.HUMAN, number)) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.RED);
            }
            
            g.drawOval(3, 3, 10, 10);
        }
    }
    
    private class PlayingPanel extends JPanel {

        public PlayingPanel() {
            initComponents();
        }
        
        // <editor-fold defaultstate="collapsed" desc="Initialization Code">
        private void initComponents() {
            cpuDist = new JLabel();
            cpuBattle = new JLabel();
            cpuSpeed = new JLabel();
            cpuSafe1 = new JLabel();
            cpuSafe2 = new JLabel();
            cpuSafe3 = new JLabel();
            cpuSafe4 = new JLabel();
            hDist = new JLabel();
            hBattle = new JLabel();
            hSpeed = new JLabel();
            hSafe1 = new JLabel();
            hSafe2 = new JLabel();
            hSafe3 = new JLabel();
            hSafe4 = new JLabel();
            cpuMileLbl = new JLabel();
            hMileLbl = new JLabel();
            deckLbl = new JLabel();
            discardLbl = new JLabel();
            
            setPreferredSize(new Dimension(385, 410));
            
            Dimension cardSize = new Dimension(50, 69);

            cpuDist.setPreferredSize(cardSize);
            cpuBattle.setPreferredSize(cardSize);
            cpuSpeed.setPreferredSize(cardSize);
            cpuSafe1.setPreferredSize(cardSize);
            cpuSafe2.setPreferredSize(cardSize);
            cpuSafe3.setPreferredSize(cardSize);
            cpuSafe4.setPreferredSize(cardSize);
            hDist.setPreferredSize(cardSize);
            hBattle.setPreferredSize(cardSize);
            hSpeed.setPreferredSize(cardSize);
            hSafe1.setPreferredSize(cardSize);
            hSafe2.setPreferredSize(cardSize);
            hSafe3.setPreferredSize(cardSize);
            hSafe4.setPreferredSize(cardSize);
            discardLbl.setPreferredSize(cardSize);
            
            cpuMileLbl.setText("CPU Miles: " + game.getMiles(Game.CPU));
            hMileLbl.setText(game.getPlayerName(Game.HUMAN) + "'s Miles: " + game.getMiles(Game.HUMAN));
            deckLbl.setText("In Deck: " + game.getDeckSize());

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
                                    .addComponent(hSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cpuSafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deckLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(discardLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 43, Short.MAX_VALUE)))))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
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
                                .addComponent(hSafe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(deckLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(discardLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
        }
        // </editor-fold>
        
        public void updateTableaus() {
            clearIcons();
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
            discardLbl.setIcon(game.getDiscardIcon());
            
            cpuMileLbl.setText("CPU Miles: " + game.getMiles(Game.CPU));
            hMileLbl.setText(game.getPlayerName(Game.HUMAN) + "'s Miles: " + game.getMiles(Game.HUMAN));
            deckLbl.setText("In Deck: " + game.getDeckSize());
        }
        
        private void clearIcons() {
            cpuSafe4.setIcon(null);
            cpuSafe3.setIcon(null);
            cpuSafe2.setIcon(null);
            cpuSafe1.setIcon(null);
            
            hSafe4.setIcon(null);
            hSafe3.setIcon(null);
            hSafe2.setIcon(null);
            hSafe1.setIcon(null);
        }
        
        // GUI components for the panel
        private JLabel cpuBattle;
        private JLabel cpuDist;
        private JLabel cpuSafe1;
        private JLabel cpuSafe2;
        private JLabel cpuSafe3;
        private JLabel cpuSafe4;
        private JLabel cpuSpeed;
        private JLabel deckLbl;
        private JLabel discardLbl;
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
