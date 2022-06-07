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

    protected Grid[][] grids;
    protected int actCounter, test;
    protected Island island;
    protected Player player;
 
    protected boolean moving;
    /**
     * Constructor for objects of class IslandSystem.
     * 
     */
    public IslandSystem()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false); 
        setPaintOrder(Cursor.class,Label.class,Messages.class, Border.class, Entity.class, Bridge.class, Interactor.class,Island.class, Grid.class);
        grids = new Grid[WIDTH / 50 + 2][HEIGHT / 50 + 2]; // Add 2 grids on each axis for buffer space
    }
    
    public void setMovingState(boolean state){
        moving = state;
    }
    
    public boolean getMovingState(){
        return moving;
    }
    
    public void waveEffect(){
    
        
        for (int i = 0; i < WIDTH / 50 + 2; i++){
            
            for (int j = 0; j < HEIGHT / 50 + 2; j++){
                if (grids[i][j].getType() != Grid.GridType.WATER) continue;
                int sign = test == 0 ? 1 : - 1;
                int add = (j % 2 == 0 ? 3 : -2) * sign;
                grids[i][j].setLocation(grids[i][j].getX() + add, j * 50 - 25);
            }
        }
        test ^= 1;
        
    }
    
    
    /**
     * This method changes the border state of the grid 
     */
    public void displayGrid(int x, int y, boolean activate){
        if (activate) grids[x][y].activate();
        else grids[x][y].deactivate();
    }
    
    /**
     * Set the initial spawning location of the player
     */
    public void spawn(int x, int y){
        player.setLocation(x, y);
    }
}
