import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class cannon here.
 * class provides functionality for rotating the cannon, shooting bullets, 
 * and checking for game over conditions when the cannon intersects with attackers.
 * @author Guntis Subrovskis
 * @version 1.0
 */
public class cannon extends Actor{
    private GreenfootImage myImage;// Stores the image of the cannon
    private ScoreBoard scoreboard;// Reference to the game scoreboard
public cannon(ScoreBoard scoreboard) {
    this.scoreboard = scoreboard;// Assigns the scoreboard passed as a parameter to the instance variable
    myImage = getImage();// Retrieves the default image of the cannon
    myImage.scale(myImage.getWidth() / 6, myImage.getHeight() / 6);// Scales down the image to one-sixth of its original size
    setImage(myImage);// Sets the scaled image as the actor image
    }
public void act(){
    if (Greenfoot.isKeyDown("left")) {
        setRotation(getRotation() - 5);// Rotate the cannon to the left by 5 degrees
        } 
    if (Greenfoot.isKeyDown("right")) {
        setRotation(getRotation() + 5);// Rotate the cannon to the right by 5 degrees
        }
    if ("space".equals(Greenfoot.getKey())){
        fire();// Make the cannon shoot when the spacebar is pressed   
        }
    checkGameOver();// Check if the cannon intersects with any attackers and make game over
    }
private void fire(){
    bullet bullet = new bullet();// Create a new instance of the bullet class
    getWorld().addObject(bullet, getX(), getY());// Add the bullet to the world at the cannon position
    bullet.setRotation(getRotation());// Set the bullet rotation to match the cannon rotation
    bullet.move(20);// Move the bullet 20 units forward in its current direction
    }
public void checkGameOver() {
    attackers attackers = (attackers) getOneIntersectingObject(attackers.class);// Check if the cannon intersects with any attackers
        if (attackers != null) {
            getWorld().removeObject(this); // Remove the cannon from the world
            Greenfoot.setWorld(new lose(scoreboard.getScore())); // Display the lose screen and pass the current score to it
            }
}
}