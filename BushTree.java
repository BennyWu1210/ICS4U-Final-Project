import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BushTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BushTree extends Decoration
{
    public BushTree(){
        super(new GreenfootImage("Bush_tree.png"), false);
        getImage().scale(45, 90);
    }
}
