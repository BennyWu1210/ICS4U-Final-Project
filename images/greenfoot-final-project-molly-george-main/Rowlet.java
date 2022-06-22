import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class for Rowlet
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rowlet extends Characters
{
    public static int rowletX;
    public static int rowletY;
    public static int rHP = 60;
    GreenfootSound ds = new GreenfootSound("damage.wav");
    
    public Rowlet()
    {
        rHP = 60;
        setImage(new GreenfootImage("Rowlet.png"));
    }
    
    //This act method let Rowlet do what a enemy should do
    public void act()
    {
        int RowletX = getX();
        int RowletY = getY();
        
        if(isTouching(NormalAttack.class))
        {
            ds.play();
            removeTouching(NormalAttack.class);
        }

    }
    
    
    
}
