import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private final static int WIDTH = 1000, HEIGHT = 700;
    private Grid[][] grids;

    private int actCounter, test;
    public MyWorld()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        // Allow infinite grid to ensure flexibility. However, ensure that objects can not go outside easily
        super(WIDTH, HEIGHT, 1, false); 
        grids = new Grid[WIDTH / 50 + 2][HEIGHT / 50 + 2]; // Add 2 grids on each axis for buffer space
        Player bunny = new Player(1);
        addObject(bunny, 100, 100);
        
        setPaintOrder(Entity.class, Grid.class);
        for (int i = 0; i < WIDTH / 50 + 2; i++){
            for (int j = 0; j < HEIGHT / 50 + 2; j++){
                Grid cur = new Grid(new GreenfootImage("Water" + ((i + j) % 4 + 1) + ".png") , i * 50, j * 50);
                cur.setType(Grid.GridType.WATER);
                grids[i][j] = cur;
                addObject(grids[i][j], i * 50 - 25, j * 50 - 25);
            }
        }
    }
    
    public void act(){
        // Call the wave effect every 50 acts
        if (actCounter % 50 == 0) waveEffect();
        
        actCounter ++;
    }
    
    public void waveEffect(){
    
        
        for (int i = 0; i < WIDTH / 50 + 2; i++){
            
            for (int j = 0; j < HEIGHT / 50 + 2; j++){
                if (grids[i][j].getType() != Grid.GridType.WATER) continue;
                int sign = test == 0 ? 1 : - 1;
                int add = (j % 2 == 0 ? 3 : -2) * sign;
                grids[i][j].setLocation(grids[i][j].getX() + add, j * 50 -25);
            }
        }
        test ^= 1;
        
    }
    
}
