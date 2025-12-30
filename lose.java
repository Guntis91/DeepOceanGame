import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;
/**
 * Write a description of class MyWorld here.
 * class provides a visual representation of the game over screen and displays the final score
 * achieved by the player, allowing them to see their performance at the end of the game.
 * @author Guntis Subrovskis 
 * @version 1.0
 */
public class lose extends World{ 
    private int score;// The score passed to the lose screen
    private ScoreBoard scoreboard;// Reference to the game's scoreboard
     public lose(int score){ 
        super(800, 800, 1);// Create a world with dimensions 800x800 and a cell size of 1
        prepare(score);// Call the prepare method to set up the lose screen
    }
    private void prepare(int score) {
        GreenfootImage text = new GreenfootImage("Score: " + score, 30, Color.RED, null);// add the score display in the lose screen
        getBackground().drawImage(text, getWidth() / 2 - text.getWidth() / 2, getHeight() / 2 - text.getHeight() / 2);
    }
}




