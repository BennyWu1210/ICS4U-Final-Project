import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //front=0, back=1, left=2, right=3
    //Set up the sprite movement
    private GreenfootImage[][] movements;
    private int [] imageIdx, keyState;
    static private String[] dir = {"down", "up", "left", "right"};
    
    
    // Use an act counter to control the movement
    private int walkAct, walkType = -1;
    public Player(int direction){
        // Initialize necessary data structures
        movements = new GreenfootImage[4][4];
        keyState = new int[4];
        imageIdx = new int[4];
        
        
        for(int i = 0; i < 4; i++){//initialize all four direction movements
            movements[0][i] = new GreenfootImage("front" + i + ".png");
            movements[1][i] = new GreenfootImage("back" + i + ".png");
            movements[2][i] = new GreenfootImage("left" + i + ".png");
            movements[3][i] = new GreenfootImage("right" + i +".png");
            
            movements[0][i].scale(160,160);
            movements[1][i].scale(160,160);
            movements[2][i].scale(160,160);
            movements[3][i].scale(160,160);
  
            
        }
        setImage(movements[direction][0]);//set the begining pictures
    }
    
    /**
     * This method will update the sprite pictures when the user press the corresponding keys
     * @param animat, this is the GreenfoorImage array that is stored the direction images
     * @param idx, this is the index for this method to update the images with
     * @return  this will update the index of
     */
    public int animate(GreenfootImage[] animate, int idx){
        if(walkAct < 8){
            return idx;
        }
        walkAct = 0;
        setImage(animate[idx]);
        idx = (idx + 1) % 4;
        return idx;
    }
    
    
    public void act()
    {
        walkAct ++;
        move();
    }
    
    /**
     * This methods is responsible for the movement logic of the player, it determines 
     * which direction is should go and update the image correspondingly.
     */
    public void move(){
        //this will update the location for the player when they press the key
        boolean moved = false;
        
        if (walkType != -1 && Greenfoot.isKeyDown(dir[walkType])) walkType = -1;
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+2);
            moved = true;
            
            if (keyState[0] == 0 && walkType != -1 || walkType == -1){
                keyState[0] = 1;
                walkType = 0;
            }
            
            if (walkType == 0) imageIdx[0] = animate(movements[0], imageIdx[0]);
        } else {
            if (walkType == 0) walkType = -1;
            keyState[0] = 0;
        }
        
        if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-2);
            moved = true;
            
            if (keyState[1] == 0 && walkType != -1 || walkType == -1){
                keyState[1] = 1;
                walkType = 1;
            }
            
            if (walkType == 1) imageIdx[1] = animate(movements[1], imageIdx[1]);
        } else {
            if (walkType == 1) walkType = -1;
            keyState[1] = 0;
        }
        
        if (Greenfoot.isKeyDown("left")){
            move(-2);
            moved = true;
            
            if (keyState[2] == 0 && walkType != -1 || walkType == -1){
                System.out.println("HI");
                keyState[2] = 1;
                walkType = 2;
            }
            
            if (walkType == 2) imageIdx[2] = animate(movements[2], imageIdx[2]);

        } else {
            if (walkType == 2) walkType = -1;
            keyState[2] = 0;
        }
        
        if (Greenfoot.isKeyDown("right")){
            move(2);
            
            moved = true;
            if (keyState[3] == 0 && walkType != -1 || walkType == -1){
                keyState[3] = 1;
                walkType = 3;
            }
            
            if (walkType == 3) imageIdx[3] = animate(movements[3], imageIdx[3]);
        } else {
            if (walkType == 3) walkType = -1;
            keyState[3] = 0;
        }
   
        if (!moved && walkType != -1) {
            setImage(movements[walkType][0]);
            imageIdx[walkType] = 0;
            walkType = -1;
        }
        
    }
    
    /**
     * This methods determine the direction this particular entity (player) should be facing
     
    public int getWalkingDir(){
        
    }
    */
    
}
