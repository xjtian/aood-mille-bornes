package text_interface;

import baseclasses.Game;
import java.util.Scanner;

/**
 *
 * @author Jacky Tian
 */
public final class GameTextUI {
    
    private Game g;
    private Scanner s;
    
    public GameTextUI() {
        g = new Game();
        s = new Scanner(System.in);
        this.startGameLoop();
    }
    
    public void startGameLoop() {
        //  This method should be the Game Loop. If you don't know what that 
        //  means, look it up on google.
    }
    
    public static void main(String[] args) {
        //  You can use this to test how you've implemented the draw method for 
        //  Game, or you can begin to create the game UI. Your call. Read the 
        //  specs very carefully if you choose the latter.
        
        //  Code below is if you choose to work on the text UI, but only after 
        //  you've correctly implemented all of the 0-arg draw() methods.
        GameTextUI game = new GameTextUI();
        game.startGameLoop();
        
        //  Otherwise use this
        Game g2 = new Game();
    }
}
