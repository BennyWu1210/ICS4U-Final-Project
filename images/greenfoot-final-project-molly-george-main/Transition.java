import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * transition screen 1
 * 
 * @author Molly Wu and George Lu
 * @version June 2022
 */
public class Transition extends World
{

    /**
     * Constructor for objects of class Transition.
     * 
     */
    public Transition()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        
        setBackground(new GreenfootImage("islandfallingtransition.jpg"));
        
        prepare();
    }
    
    public void act()
    {
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the start label and add it to the world.
     */
    private void prepare()
    {
        NextLabel nextLabel = new NextLabel();
        addObject(nextLabel, 730, 430);
    }
}
