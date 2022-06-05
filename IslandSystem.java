import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IslandSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IslandSystem extends World
{
public final static int WIDTH = 1000, HEIGHT = 700;

    private Grid[][] grids;

    private int actCounter, test;
    private Island island;
    private MapBorder boo;
    private boolean moving;
    /**
     * Constructor for objects of class IslandSystem.
     * 
     */
    public IslandSystem()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false); 
    }
    public void setMovingState(boolean state){
        moving = state;
    }
    /**
     * This method changes the border state of the grid 
     */
    public void displayGrid(int x, int y, boolean activate){
        if (activate) grids[x][y].activate();
        else grids[x][y].deactivate();
    }
}
