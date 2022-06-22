import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for Fennekin
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Fennekin extends Characters
{
    public static int fennekinX;
    public static int fennekinY;
    public static int fHP = 45;
    GreenfootSound ds = new GreenfootSound("damage.wav");
    
    public Fennekin()
    {
        fHP = 45;
        setImage(new GreenfootImage("Fennekin.png"));
    }
    
    //This act method let Fennekin do what a enemy should do
    public void act()
    {
        int FennekinX = getX();
        int FennekinY = getY();
        if(isTouching(NormalAttack.class))
        {
            ds.play();
            removeTouching(NormalAttack.class);
        }
    }
    
    
}
