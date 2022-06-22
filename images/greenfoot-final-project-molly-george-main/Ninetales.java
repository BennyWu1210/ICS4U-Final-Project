import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ninetales here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Ninetales extends Characters
{
    public static int ninetalesX;
    public static int ninetalesY;
    public static int nHP = 60;
    GreenfootSound ds = new GreenfootSound("damage.wav");
    
    public Ninetales()
    {
        nHP = 60;
        setImage(new GreenfootImage("Ninetales.png"));
    }
    
    //This class let ninetales do what enemy should do
    public void act()
    {
        int NinetalesX = getX();
        int NinetalesY = getY();
        if(isTouching(NormalAttack.class))
        {
            ds.play();
            removeTouching(NormalAttack.class);
        }
    }
    
    
}
