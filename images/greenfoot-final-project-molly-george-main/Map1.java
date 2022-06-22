import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be the place for the player to choose the level they go to, in
 * this case, it is the first level.
 * 
 * @George Lu && Molly Wu 
 * @version June 2022
 */
public class Map1 extends World
{
    BulbLogo b = new BulbLogo();
    /**
     * Constructor for objects of class Map1.
     * 
     */
    public Map1()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        setBackground("pokemon map 1.jpg");
        
        addObject(b, 180, 270);
    }
    
    
    
    public void act()
    {
        if(Greenfoot.mouseClicked(b))
        {
            Store1 store = new Store1();
            Greenfoot.setWorld(store);
        }
    }
}
