import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Border here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Border extends Grid
{
    public static boolean show = true;
    public Border(int x, int y){
        super(x, y);
    }
    
    /**
     * Act - do whatever the Border wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!show && getWorld().getObjects(Border.class).size() != 0){
            getWorld().removeObjects(getWorld().getObjects(Border.class));
        }
    }
    

}
