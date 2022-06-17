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

    private boolean isPressed;
    private PongGame pong;
    private Sign pongSign;
    private PuzzleGame pongWorld;
    private TextBoard pongBoard;
    private BillBoard pongBillBoard;
    private Label pongText[] = new Label[3];
    private Label pongContinue[] = new Label[3];
    private int pongOrder = 0;
    public MainIsland()
    {

        // testing mouse cursor

        drawBorder();
        island = new Island(0);
        addObject(island, 525, 375);
        player = new Player(1,this);
        addObject(player, 268, 323);

        Bridge bri = new Bridge(1);
        addObject(bri, 967,471);

        // add a house object
        addObject(new House(), 300, 250);
        
        // add plants
        addPlants();
        
        pong= new PongGame(this);
        Pong ping = new Pong();
        addObject(ping, 924, 370);
        
        pongBillBoard = new BillBoard();
        addObject(pongBillBoard,883,370);
        
        pongSign = new Sign();
        pongBoard = new TextBoard(800, 300);
        pongText[0] = new Label("Welcome to the ping pong game!", 40);
        pongText[1] = new Label("Get five points to beat the computer!", 40);
        pongText[2] = new Label("Press Space to play!", 55);

        pongContinue[0] = new Label("Press Space to continue...", 25);
        pongContinue[1] = pongContinue[0];
        pongContinue[2] = new Label("", 0);
    }

    public void act(){
        // Call the wave effect every 50 acts
        if(player.getX()>1020){
            openIslandRight();
        }

        if (actCounter % 50 == 0) waveEffect();

        Border.show = !moving;
        actCounter ++;
        interact();
    }

    public void returnToMainIsland(){
        Greenfoot.setWorld(this);
        pong.removeTextD();
        pong.reset();
    }
    public void addPlants(){
        // add a tree object (testing)
        addObject(new Tree(), 300, 530);
        addObject(new Tree(), 400, 530);
        
        addObject(new BushTree(), 380, 250);
        addObject(new BushTree(), 440, 250);
        addObject(new BushTree(), 500, 250);
        
        addObject(new BushTree(), 700, 160);
        addObject(new BushTree(), 730, 180);
        
        addObject(new Trunk(), 680, 200);
        addObject(new Trunk(), 720, 250);
        addObject(new Trunk(), 340, 570);
        
        addObject(new Rock(), 690, 225);
        addObject(new Rock(), 620, 160);
        addObject(new Rock(), 790, 570);
        addObject(new Rock(), 840, 580);
        
        
        addObject(new Mushroom(), 680, 280);
        addObject(new Mushroom(), 180, 483);
        
        
        addObject(new Sunflower(), 220, 260);
        addObject(new Sunflower(), 220, 290);
        addObject(new Sunflower(), 220, 320);
        addObject(new Sunflower(), 220, 350);
        addObject(new Sunflower(), 360, 570);
        
        addObject(new FlowerPot(), 830, 540);
    }
    
    public void interact() {
        if (player.isTouching(pongBillBoard)) {
            addObject(pongSign, 883, 338);

            if ((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) && !isPressed) {

                if (pongOrder > 0 && pongOrder < 4) {
                    removeObject(pongText[pongOrder - 1]);
                    removeObject(pongContinue[pongOrder - 1]);
                }
                if (pongOrder == 3) {
                    removeObject(pongBoard);
                    pongOrder = 0;
                    pong.setPlay();
                    Greenfoot.setWorld(pong);
                } else {

                    addObject(pongBoard, 500, 550);
                    addObject(pongText[pongOrder], 502, 489);
                    addObject(pongContinue[pongOrder], 708, 637);

                    isPressed = true;
                    pongOrder++;

                }

            }
            if (!Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter") && isPressed) {
                isPressed = false;
            }
        } else {
            removeObject(pongSign);
        }
    }
    /**
     * Enter the right island
     */
    public void openIslandRight(){
        Greenfoot.setWorld(new IslandRight(this));
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


}
