import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * startscreen for level 3
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Load3 extends World
{
    TransitionStartLabel g = new TransitionStartLabel();
    /**
     * Constructor for objects of class Load3.
     * 
     */
    public Load3()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        setBackground(new GreenfootImage("transitionlevel3.jpg"));
        g.clicki = false;
        
        addObject(g,450,400);
    }
    
    public void act()
    {
        if(TransitionStartLabel.clicki == true)
        {
            Battle b = new Battle();
            Greenfoot.setWorld(b);
        }
    }
}
