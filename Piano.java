import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piano extends Interactor
{
    /**
     * Act - do whatever the Piano wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Piano(){
        GreenfootImage piano = new GreenfootImage("Piano.png");
        piano.scale(40, 30);
        setImage(piano);
    }
    public void act()
    {
        // Add your action code here.
    }
    
    public void onClick(){
        
    }
    
    public void onHover(){
        
    }
}
