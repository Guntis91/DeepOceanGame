import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * MyWorld manages the game environment, including the placement of actors, 
 * handling player input, and updating the game state. It keeps track 
 * of the score, increments it when attackers are removed, and increases 
 * the speed as the player progresses. The world contains a cannon actor 
 * that the player controls. Players are prompted to enter their name at 
 * the start of the game. The class provides methods to reset the game and 
 * update the score.
 * @author Guntis Subrovskis 
 * @version 1.0
 */
public class MyWorld extends World{
    private ScoreBoard scoreboard;// Declare a ScoreBoard variable
    private int counter = 0;// set a counter variable with 0 
    private int speed = 2; //set a speed variable with 2
    private int actorsKilled = 0; // set an actorsKilled variable with 0
    private String playerName = "";// set a playerName variable as an empty string
    private int score;// Declare a score variable
    public MyWorld(){    
        super(800, 800, 1);  // Call the superclass constructor with specified world dimensions
        scoreboard = new ScoreBoard();  // Create a new ScoreBoard instance and assign it to the scoreboard variable
        addObject(scoreboard, 100, 20);  // Add the scoreboard to the world at the specified position
        prepare();  // Call the prepare() method to set the world
        resetGame();
        while (playerName.equals("")) {  // Start a loop that continues until a player name is entered
            playerName = Greenfoot.ask("Please enter your name: ");  // Prompt the user to enter their name and assign it to the playerName variable
        }
    }   
    public void act() {    
        counter++;// Increment the counter by 1
        if (counter == 100)// Check if the counter value is equal to 100 
        { 
            addActor();// add an actor every 100 acts (approximately 2 seconds)
            counter = 0;// Reset the counter to 0
        }
    }
    private void addActor() 
    {
        attackers actor = new attackers();
        int edge = Greenfoot.getRandomNumber(4);
        int x, y;
            if (edge == 0) { // Top edge
                x = Greenfoot.getRandomNumber(getWidth());
                y = 0;} 
            else if (edge == 1) { // Right edge
                x = getWidth() - 1;
                y = Greenfoot.getRandomNumber(getHeight());} 
            else if (edge == 2) { // Bottom edge
                x = Greenfoot.getRandomNumber(getWidth());
                y = getHeight() - 1;} 
            else { // Left edge
                x = 0;
                y = Greenfoot.getRandomNumber(getHeight());}
        addObject(actor, x, y);// Add the actor to the world at the calculated position
    }
    public void removeObject(Actor actor) {
        if (actor instanceof attackers) {
            scoreboard.addScore(1); // increase score by 1 when an attacker is removed
            actorsKilled++;
        if (actorsKilled % 5 == 0){ // increase speed after every 5 actors killed
            speed++;
            }
        }
        super.removeObject(actor);
    }
    public void resetGame(){
        scoreboard.reset();// Reset the score
    }
    private void prepare(){
        cannon cannon = new cannon(scoreboard);// Create a cannon instance and pass the scoreboard to it
        addObject(cannon, 400, 400);// Add the cannon to the world at the specified position
    }
}