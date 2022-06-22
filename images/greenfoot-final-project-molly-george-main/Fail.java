import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fail here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Fail extends NewLabelClass
{
    public static boolean click;
    
    public Fail()
    {
        setImage(new GreenfootImage("toMap1.png"));
    }
    
    public void act()
    {
        click = Greenfoot.mouseClicked(this);
    }
}
