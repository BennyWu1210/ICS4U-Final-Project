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
            int curX = (int)((double)x / IslandSystem.WIDTH * 20), curY = (int)((double)y / IslandSystem.HEIGHT * 14);
            if (curX != relativeX || curY != relativeY) {
                if (getWorld().getClass() == IslandSystem.class){
                    ((IslandSystem)getWorld()).displayGrid(curX, curY, true);
                    ((IslandSystem)getWorld()).displayGrid(relativeX, relativeY, false);
                    relativeX = curX; relativeY = curY;
                }
                
            }
            setLocation(x, y);
        }
    }
    
    public boolean isClicked(Actor actor){
        return Greenfoot.mouseClicked(this) && intersects(actor);
    }
    
    public boolean isHovered(Actor actor){
        return Greenfoot.mouseMoved(this) && intersects(actor);
    }
}
