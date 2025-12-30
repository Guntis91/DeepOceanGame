import greenfoot.*;
import greenfoot.Actor;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class bullet here.
 * The bullet has an image associated with it, 
 * which is scaled to a smaller size. When the bullet
 * acts, it moves forward at a speed of 5 units. If the 
 * bullet reaches the edge of the world or hits the target (attackers), 
 * it is removed from the game.
 * class resposible of the behavior and appearance of a bullet in the game.
 * @author Guntis Subrovskis 
 * @version 1.0
 */
public class bullet extends Mover{
    private GreenfootImage myImage;// Declare a private variable to hold the bullet image
    public bullet() {
        myImage = getImage();// Get the bullet image
        myImage.scale(myImage.getWidth() / 30, myImage.getHeight() / 30);// Scale the image to a smaller size
        setImage(myImage); // Set the scaled image as the bullet image
    }
    public void act(){
        move(5.0);// Move the bullet 5.0 units forward
        if (isAtEdge()) { 
        getWorld().removeObject(this);// Remove the bullet from the world
        }
    }
}