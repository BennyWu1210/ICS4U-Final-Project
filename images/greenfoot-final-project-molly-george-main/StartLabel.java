import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartLabel here.
 * 
 * @author Molly Wu 
 * @version May 2022
 */
public class StartLabel extends NewLabelClass
{
    
    public StartLabel()
    {
        setImage(new GreenfootImage("My First Board (2).jpg"));
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Transition transition = new Transition();
            Greenfoot.setWorld(transition);
        }
    }
}
