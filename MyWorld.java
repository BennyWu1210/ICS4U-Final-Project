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
    public MyWorld()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        Player bunny = new Player(1);
        addObject(bunny, 100, 100);
        
        setPaintOrder(Entity.class, Grid.class);
        for (int i = 0; i < WIDTH / 50; i++){
            for (int j = 0; j < HEIGHT / 50; j++){
                addObject(new Grid(i * 50, j * 50), i * 50 + 25, j * 50 + 25);
            }
        }
    }
    
}
