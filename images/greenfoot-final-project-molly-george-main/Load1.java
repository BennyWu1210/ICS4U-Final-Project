import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * a start screen for level 1
 * 
 * @author George Lu && Molly Wu
 * @version June 2022
 */
public class Load1 extends World
{
    TransitionStartLabel g = new TransitionStartLabel();
    /**
     * Constructor for objects of class Load1.
     * 
     */
    public Load1()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        
        setBackground(new GreenfootImage("transitionlevel1.jpg"));
        g.clicki = false;
        
        addObject(g,450,410);
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
