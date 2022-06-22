import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransitionStartLabel here.
 * a label to start a new level of game on transition screen
 * Molly Wu
 * June 2022
 */
public class TransitionStartLabel extends Actor
{
    public static boolean clicki;
    
    public TransitionStartLabel()
    {
        setImage(new GreenfootImage("startlabel.png"));
    }
    
    /**
     * Act - do whatever the TransitionStartLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        clicki = Greenfoot.mouseClicked(this);
    }
}
