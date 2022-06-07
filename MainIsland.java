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
    private int actCounter, test;
    private Island island;
    private IslandRight islandRight;
    
    public MainIsland()
    {    
        
        // testing mouse cursor
        
        drawBorder();
        island = new Island(0);
        addObject(island, 525, 375);
        player = new Player(1,this);
        addObject(player, 350, 300);
        
        Bridge bri = new Bridge(1);
        addObject(bri, 967,471);
        
        // for testing
        addObject(new House(), 300, 250);
        
        
        // addObject(h1, 298,300);
    }
    
    public void act(){
        // Call the wave effect every 50 acts
        if(player.getX()>1050){
            openIslandRight();
        }
        
        if (actCounter % 50 == 0) waveEffect();
        
        Border.show = !moving;     
        actCounter ++;
        
    }
    public void openIslandRight(){
        Greenfoot.setWorld(new IslandRight(this));
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
        InvisibleBorder I1 = new InvisibleBorder(800,10);
        addObject(I1, 478, 615);
        InvisibleBorder I2 = new InvisibleBorder(10,70);
        addObject(I2, 870, 591);
        InvisibleBorder I3 = new InvisibleBorder(90,10);
        addObject(I3, 920, 561);
        InvisibleBorder I4 = new InvisibleBorder(10,250);
        addObject(I4, 963, 631);
        InvisibleBorder I19 = new InvisibleBorder(10,250);
        addObject(I19, 963, 310);
        InvisibleBorder I20 = new InvisibleBorder(70,10);
        addObject(I20, 1000, 510);
        InvisibleBorder I21 = new InvisibleBorder(70,10);
        addObject(I21, 1000, 434);
        InvisibleBorder I5 = new InvisibleBorder(150,10);
        addObject(I5, 882, 331);
        InvisibleBorder I6 = new InvisibleBorder(10,60);
        addObject(I6, 813, 300);
        InvisibleBorder I7 = new InvisibleBorder(50,10);
        addObject(I7, 788, 270);
        InvisibleBorder I8 = new InvisibleBorder(10,200);
        addObject(I8, 770, 170);
        InvisibleBorder I9 = new InvisibleBorder(200,10);
        addObject(I9, 666, 136);
        InvisibleBorder I10 = new InvisibleBorder(10,48);
        addObject(I10, 585, 165);
        InvisibleBorder I11 = new InvisibleBorder(30,10);
        addObject(I11, 564, 183);
        InvisibleBorder I12 = new InvisibleBorder(10,48);
        addObject(I12, 542, 200);
        InvisibleBorder I13 = new InvisibleBorder(400,10);
        addObject(I13, 341, 218);
        InvisibleBorder I14 = new InvisibleBorder(10,250);
        addObject(I14, 178, 310);
        InvisibleBorder I15 = new InvisibleBorder(60,10);
        addObject(I15, 143, 434);
        InvisibleBorder I16 = new InvisibleBorder(10,70);
        addObject(I16, 116, 457);
        InvisibleBorder I17 = new InvisibleBorder(60,10);
        addObject(I17, 84, 488);
        InvisibleBorder I18 = new InvisibleBorder(10,190);
        addObject(I18, 86, 522);
        /**
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
        */
    }
    
    /**
     * Set the initial spawning location of the player
     */
    public void spawn(int x, int y){
        player.setLocation(x, y);
    }
  
}
