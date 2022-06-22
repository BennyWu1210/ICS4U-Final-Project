import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLabel2 here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class NextLabel2 extends NewLabelClass
{
    
    public NextLabel2()
    {
        setImage(new GreenfootImage("Next.png"));
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            IntroScreen introScreen = new IntroScreen();
            Greenfoot.setWorld(introScreen);
        }
    }
}
