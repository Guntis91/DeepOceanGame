import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;
import greenfoot.Actor;
/**
 * Write a description of class attackers here.
 * Represents the attackers in the game.
 * The attackers move towards the center of the world and check for collisions with bullets.
 * The attackers have a randomly selected image from a set of predefined images.
 * The score and name of the attackers can be set and retrieved.
 * @author Guntis Subrovskis 
 * @version 1.0
 */
public class attackers extends Actor{
    private int score;// The score of the attackers
    private String name;// The name of the attackers
    private static final String[] IMAGES = {"fish1.png", "fish2.png", "fish3.png", "turtle2.png"};// Array of image file names
    private GreenfootImage image;// The image of the attackers
public attackers(){
    int index = Greenfoot.getRandomNumber(IMAGES.length);// Select a random index from the IMAGES array
    image = new GreenfootImage(IMAGES[index]);// Create a new GreenfootImage using the selected image filename
    setImage(image);// Set the image as the actor image
    }
public void act() {
    checkCollision();// Check for collisions with bullets
        if (getWorld() == null) {
            return;// If the world is null, exit the method
        }
    int centerX = getWorld().getWidth() / 2;// X-coordinate of the center of the world
    int centerY = getWorld().getHeight() / 2;// Y-coordinate of the center of the world
    int speed = 1; // adjust this value to control the speed
    turnTowards(centerX, centerY);// Turn towards the center of the world
    move(speed);// Move towards the center of the world
    }
public void checkCollision() {
    Actor bullet = getOneIntersectingObject(bullet.class);// Check for a collision with a bullet
        if (bullet != null) {
            getWorld().removeObject(bullet);// Remove the bullet from the world
        if (getWorld() instanceof MyWorld) {
            MyWorld world = (MyWorld) getWorld();// Cast the world to MyWorld type
        }
            getWorld().removeObject(this);// Remove the attacker from the world
    }
}
}