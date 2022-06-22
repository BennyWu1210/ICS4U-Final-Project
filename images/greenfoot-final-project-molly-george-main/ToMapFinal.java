import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToMapFinal here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class ToMapFinal extends NewLabelClass
{
    public static boolean click;
    
    public ToMapFinal()
    {
        setImage(new GreenfootImage("Tomapfinal.png"));
    }
    
    public void act()
    {
        click = Greenfoot.mouseClicked(this);
    }
}
