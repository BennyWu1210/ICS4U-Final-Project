import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sunflower extends Decoration
{
    public Sunflower(){
        super(new GreenfootImage("Sunflower.png"), false);
        getImage().scale(25, 50);
    }
}
