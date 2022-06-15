import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Decoration
{
    public Rock(){
        super(new GreenfootImage("Rock.png"), false);
        getImage().scale(24, 18);
    }
}
