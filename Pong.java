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
        super.act();
        if (actCounter % 100 == 0){
            setLocation(getX(), getY() + 5);
        } else if (actCounter % 100 == 50){
            setLocation(getX(), getY() - 5);
        }
    }
    public void onClick(){
        
    }
    
    public void onHover(){
        if (isTouching(Cursor.class)){
            getImage().scale(40, 50);
        }
        else {
            getImage().scale(40, 50);
        }
    }
}
