import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Decoration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decoration extends Actor
{
    protected boolean canInteract;
    public Decoration(GreenfootImage plantImage, boolean canInteract){
        setImage(plantImage);
        this.canInteract = canInteract;
    }
}
