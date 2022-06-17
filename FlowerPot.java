import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlowerPot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlowerPot extends Decoration
{
    public FlowerPot(){
        super(new GreenfootImage("FlowerPot.png"), false);
        getImage().scale(30, 40);
    }
}
