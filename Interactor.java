import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Interactor here.
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public abstract class Interactor extends Actor
{
    protected Button enterInteractor;
    protected Label label;
    
    public Interactor(){
        
    }
    
    /**
     * The effect displayed while hovering this interactor
     */
    public abstract void onHover();
    
    /**
     * The method responsible for entering the interactor once the "enterInteractor
     */
    public abstract void onClick();
    
    
}
