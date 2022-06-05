import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainIsland extends IslandSystem
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public final static int WIDTH = 1000, HEIGHT = 700;
    private Grid[][] grids;

    private int actCounter, test;
    private Island island;
    private MapBorder boo;
    private boolean moving;
    public MainIsland()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        // Allow infinite grid to ensure flexibility. However, ensure that objects can not go outside easily
        grids = new Grid[WIDTH / 50 + 2][HEIGHT / 50 + 2]; // Add 2 grids on each axis for buffer space
        
        setPaintOrder(Cursor.class, Border.class, Entity.class, Island.class, Grid.class);
        for (int i = 0; i < WIDTH / 50 + 2; i++){
            for (int j = 0; j < HEIGHT / 50 + 2; j++){
                Grid cur = new Grid(new GreenfootImage("Water" + ((i + j) % 4 + 1) + ".png") , i * 50, j * 50);
                cur.setType(Grid.GridType.WATER);
                grids[i][j] = cur;
                addObject(grids[i][j], i * 50 - 25, j * 50 - 25);
            }
        }
        
        
        // testing mouse cursor
        addObject(new Cursor(), 100, 100);
         
        drawBorder();
        island = new Island(0);
        addObject(island, 525, 375);
        Player bunny = new Player(1);
        addObject(bunny, 300, 300);
    }
    
    public void act(){
        // Call the wave effect every 50 acts
        if (actCounter % 50 == 0) waveEffect();
        
        Border.show = !moving;     
        actCounter ++;
        
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
    
    public void setMovingState(boolean state){
        moving = state;
    }
    
    /**
     * This method draws the border for the main island
     */
    public void drawBorder(){
        MapBorder b1 = new MapBorder("b1");
        addObject(b1, 478, 627);
        MapBorder b2 = new MapBorder("b2");
        addObject(b2, 925, 598);
        MapBorder b3 = new MapBorder("b3");
        addObject(b3, 977, 453);
        MapBorder b4 = new MapBorder("b4");
        addObject(b4, 897, 291);
        MapBorder b5 = new MapBorder("b5");
        addObject(b5, 784, 195);
        MapBorder b6 = new MapBorder("b6");
        addObject(b6, 659, 120);
        MapBorder b7 = new MapBorder("b7");
        addObject(b7, 570, 148);
        MapBorder b9 = new MapBorder("b9");
        addObject(b9, 365, 204);
        MapBorder b10 = new MapBorder("b10");
        addObject(b10, 160, 293);
        MapBorder b11 = new MapBorder("b11");
        addObject(b11, 115, 414);
        MapBorder b12 = new MapBorder("b12");
        addObject(b12, 71, 430);
        MapBorder b13 = new MapBorder("b13");
        addObject(b13, 65, 547);
    }
  
}
