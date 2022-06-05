import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor extends Actor
{
    /**
     * Act - do whatever the Cursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int relativeX = 0, relativeY = 0;
    public Cursor(){
        getImage().scale(30, 30);
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            int x = mouse.getX(), y = mouse.getY();
            int curX = (int)((double)x / MyWorld.WIDTH * 20), curY = (int)((double)y / MyWorld.HEIGHT * 14);
            if (curX != relativeX || curY != relativeY) {
                
                ((MyWorld)getWorld()).displayGrid(curX, curY, true);
                ((MyWorld)getWorld()).displayGrid(relativeX, relativeY, false);
                relativeX = curX; relativeY = curY;
            }
            setLocation(x, y);
        }
        
        
    }
}
