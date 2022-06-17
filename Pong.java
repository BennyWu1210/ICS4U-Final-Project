import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pong here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pong extends Interactor
{
    /**
     * Act - do whatever the Pong wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pong(){
        setImage(new GreenfootImage("ping.png"));
    }
    public void act()
    {
        // Add your action code here.
    }
    public void onClick(){
        
    }
    
    public void onHover(){
        if (isTouching(Cursor.class)){
            getImage().scale(55, 55);
        }
        else {
            getImage().scale(45, 45);
        }
    }
}
