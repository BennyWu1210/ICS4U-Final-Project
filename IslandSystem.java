import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IslandSystem here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IslandSystem extends World {
    public final static int WIDTH = 1000, HEIGHT = 700;

    protected Grid[][] grids;
    protected int actCounter, test;
    protected Island island;
    protected Player player;
    protected boolean moving;
    protected Character gifBunny;

    /**
     * Constructor for objects of class IslandSystem.
     * 
     */
    public IslandSystem() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false);
        setPaintOrder(Cursor.class, Entity.class, Interactor.class, Label.class, Messages.class, Border.class,
                Bridge.class, Island.class, Grid.class);
        grids = new Grid[WIDTH / 50 + 2][HEIGHT / 50 + 2]; // Add 2 grids on each axis for buffer space

        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        // Allow infinite grid to ensure flexibility. However, ensure that objects can
        // not go outside easily

        for (int i = 0; i < WIDTH / 50 + 2; i++) {
            for (int j = 0; j < HEIGHT / 50 + 2; j++) {
                Grid cur = new Grid(new GreenfootImage("Water" + ((i + j) % 4 + 1) + ".png"), i * 50, j * 50);
                cur.setType(Grid.GridType.WATER);
                grids[i][j] = cur;
                addObject(grids[i][j], i * 50 - 25, j * 50 - 25);
            }
        }
         gifBunny = new Character();
        addObject(gifBunny, 60, 60);
        addObject(new Cursor(), 100, 100);
    }

    /**
     * Update the state of the player (whether or not it is moving)
     */
    public void setMovingState(boolean state) {
        moving = state;
    }

    /**
     * Get the state of the player (whether or not it is moving)
     */
    public boolean getMovingState() {
        return moving;
    }

    /**
     * This method implements the wave effects arround the island
     */
    public void waveEffect() {

        for (int i = 0; i < WIDTH / 50 + 2; i++) {

            for (int j = 0; j < HEIGHT / 50 + 2; j++) {
                if (grids[i][j].getType() != Grid.GridType.WATER || (i >= 7 && i <= 13 && j >= 6 && j <= 8))
                    continue;
                int sign = test == 0 ? 1 : -1;
                int add = (j % 2 == 0 ? 3 : -2) * sign;
                grids[i][j].setLocation(grids[i][j].getX() + add, j * 50 - 25);
            }
        }
        test ^= 1;

    }

    /**
     * This method changes the border state of the grid
     */
    public void displayGrid(int x, int y, boolean activate) {
        if (activate)
            grids[x][y].activate();
        else
            grids[x][y].deactivate();
    }

    /**
     * Set the initial spawning location of the player
     */
    public void spawn(int x, int y) {
        player.setLocation(x, y);
    }
}
