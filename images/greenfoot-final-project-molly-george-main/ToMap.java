import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToMap here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class ToMap extends NewLabelClass
{
    public boolean click;
    
    public ToMap()
    {
        setImage(new GreenfootImage("toMap.png"));
    }
    
    public void act()
    {
        click  = Greenfoot.mouseClicked(this);
    }
}
