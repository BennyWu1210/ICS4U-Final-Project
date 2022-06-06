import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvisibleBorder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvisibleBorder extends Actor
{
    /**
     * Act - do whatever the InvisibleBorder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int width;
    private int height;
    
    private GreenfootImage rect;

  
    public InvisibleBorder(int width, int height){
        this.width=width;
        this.height=height;
        rect = new GreenfootImage(width, height);
        rect.fillRect(0,0,width,height);
        rect.setTransparency(0);
        setImage(rect);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
