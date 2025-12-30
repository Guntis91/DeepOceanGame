import greenfoot.*; // Import Greenfoot classes for the game framework
import greenfoot.Actor; // Import Greenfoot Actor class for actors in the game
import java.awt.Color; // Import Java Color class for color manipulation
/**
 * Write a description of class ScoreBoard here.
 * class is responsible for keeping track of the 
 * player's score in a game. It provides methods to 
 * add points to the score, retrieve the current score 
 * value, and reset the score to zero. The class also updates 
 * the visual representation of the score on the screen.
 * @author Guntis Subrovskis 
 * @version 1.0
 */
public class ScoreBoard extends Actor {
    private static int score = 0;// Declare and set a static variable to hold the score
public ScoreBoard() {
    updateImage();// Call the updateImage() method to set the initial image of the scoreboard
    }
public void addScore(int points) {
    score += points; // Add the given points to the score
    updateImage(); // Call the updateImage() method to update the image of the scoreboard
    }
public void reset() {
    score = 0; // Reset the score to 0
    updateImage(); // Call the updateImage() method to update the image of the scoreboard
    }
public static int getScore() {
    return score;// Return the current score value
    }
private void updateImage() {
    setImage(new GreenfootImage("Score: " + score, 30, greenfoot.Color.WHITE,new greenfoot.Color(0, 0, 0, 0)));// Set the image of the scoreboard with the score value, text size, and color
    }
}
