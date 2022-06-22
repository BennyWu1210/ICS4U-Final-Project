import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends World
{

    /**
     * Constructor for objects of class ShopWorld.
     * 
     */
    
    private MainIsland mainIsland;
    public ShopWorld(MainIsland mainIsland)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        this.mainIsland=mainIsland;
        
    }
}
