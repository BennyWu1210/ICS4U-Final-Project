import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Decoration
{
    public Mushroom(){
        super(new GreenfootImage("Mushroom.png"), false);
        getImage().scale(50, 50);
    }
}
