import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is used for testing as of now (will make it invisible in the future)
 * The "Grid" could contain houses, NPCs, crops, items, etc.
 * 50 * 50
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public class Grid extends Actor
{
    
    private int x, y;
    public Grid(int x, int y){
        GreenfootImage sq = new GreenfootImage("Square.png");
        sq.scale(50, 50);
        setImage(sq);
        
    }
    
    /**
     * Act - do whatever the Grid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
