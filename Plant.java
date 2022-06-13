import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Plant extends Actor
{
    protected boolean canInteract;
    public Plant(GreenfootImage plantImage, boolean canInteract){
        setImage(plantImage);
        this.canInteract = canInteract;
    }
    
    
}
