import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * transition screen 2
 * 
 * @author Molly Wu && George Lu 
 * @version June 2022
 */
public class Transition2 extends World
{

    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition2()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        
        setBackground(new GreenfootImage("forestfallingimage.jpg"));
        
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
        NextLabel2 nextLabel2 = new NextLabel2();
        addObject(nextLabel2, 730, 430);
    }
}
