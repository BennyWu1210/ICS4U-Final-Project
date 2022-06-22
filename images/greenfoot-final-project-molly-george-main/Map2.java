import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The map for the player to go to the second level
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Map2 extends World
{
    TorchicLogo t = new TorchicLogo();
    /**
     * Constructor for objects of class Map2.
     * 
     */
    public Map2()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        setBackground("pokemon map 1.jpg");
        addObject(t, 450, 180);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(t))
        {
            Store2 s2 = new Store2();
            Greenfoot.setWorld(s2);
        }
    }
}
