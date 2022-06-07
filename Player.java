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
    private int walkAct, walkType = -1, prevWalkType = -1;
    private int speed=3;
    private boolean stop;
    private HitBox hitBoxLeft;
    private HitBox hitBoxRight;
    private HitBox hitBoxUp;
    private HitBox hitBoxDown;
    private World island;
    public Player(int direction, World island){
        this.island=island;
        // Initialize necessary data structures
        movements = new GreenfootImage[4][4];
        keyState = new int[4];
        imageIdx = new int[4];
        
        hitBoxLeft = new HitBox(this);
        hitBoxRight = new HitBox(this);
        hitBoxUp = new HitBox(this);
        hitBoxDown = new HitBox(this);
        
        
        for(int i = 0; i < 4; i++){//initialize all four direction movements
            movements[0][i] = new GreenfootImage("front" + i + ".png");
            movements[1][i] = new GreenfootImage("back" + i + ".png");
            movements[2][i] = new GreenfootImage("left" + i + ".png");
            movements[3][i] = new GreenfootImage("right" + i +".png");
            
            //set to appropriate size
            int scale = 50;
            movements[0][i].scale(scale-5,scale);
            movements[1][i].scale(scale-5,scale);
            movements[2][i].scale(scale-15,scale);
            movements[3][i].scale(scale-15,scale);
           
        }
        movements[3][0].scale(40,50);
        setImage(movements[direction][0]);//set the begining pictures
    }

    public void addedToWorld(World w){
        w.addObject(hitBoxLeft, getX(), getY());
        w.addObject(hitBoxRight, getX(), getY());
        w.addObject(hitBoxUp, getX(), getY());
        w.addObject(hitBoxDown, getX(), getY());
    }
    
    public boolean touchBillBoard(){
        return  isTouching(BillBoard.class);
            
            
        
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
        setImage(animate[idx + 1]);
        idx = (idx + 1) % 3;
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
        int explore=10;
        if (walkType != -1 && Greenfoot.isKeyDown(dir[walkType])) walkType = -1;
        if (Greenfoot.isKeyDown("down")){
            
            hitBoxDown.setLocation(getX(), getY() + explore);
            
            if(hitBoxDown.getBack()){
                //hitBox.setLocation(getX(), getY());
            }else{
                setLocation(getX(), getY() + speed);
                moved = true;
            
            if (keyState[0] == 0 && walkType != -1 || walkType == -1){
                keyState[0] = 1;
                walkType = prevWalkType = 0;
            }
            }
            
            
            if (walkType == 0) imageIdx[0] = animate(movements[0], imageIdx[0]);
        } else {
            if (walkType == 0) {
                imageIdx[walkType] = 0;
                walkType = -1;
            }
            keyState[0] = 0;
        }
        
        if (Greenfoot.isKeyDown("up")){
            hitBoxUp.setLocation(getX(), getY() - explore);
            if(hitBoxUp.getBack()){
                //hitBox.setLocation(getX(), getY() );
            }else{
                setLocation(getX(), getY() - speed);
           
                moved = true;
            
                if (keyState[1] == 0 && walkType != -1 || walkType == -1){
                    keyState[1] = 1;
                    walkType = prevWalkType = 1;
                }
            }
            if (walkType == 1) imageIdx[1] = animate(movements[1], imageIdx[1]);
        } else {
            if (walkType == 1) {
                imageIdx[walkType] = 0;
                walkType = -1;
            }
            keyState[1] = 0;
        }
        
        if (Greenfoot.isKeyDown("left")){
            hitBoxLeft.setLocation(getX()-explore, getY());
            if(hitBoxLeft.getBack()){
                //hitBox.setLocation(getX(), getY());
            }else{
           
                move(-speed);
                //if the character touch the border, bouce back
                
                moved = true;
                
                if (keyState[2] == 0 && walkType != -1 || walkType == -1){
                    keyState[2] = 1;
                    walkType = prevWalkType = 2;
                }
            }
            if (walkType == 2) imageIdx[2] = animate(movements[2], imageIdx[2]);

        } else {
            if (walkType == 2) {
                imageIdx[walkType] = 0;
                walkType = -1;
            }
            keyState[2] = 0;
        }
        
        if (Greenfoot.isKeyDown("right")){
            hitBoxRight.setLocation(getX()+explore, getY());
            if(hitBoxRight.getBack()){
                //hitBox.setLocation(getX(), getY());
            }else{
            move(speed);
            //if the character touch the border, bouce back
            
            moved = true;
            if (keyState[3] == 0 && walkType != -1 || walkType == -1){
                keyState[3] = prevWalkType = 3;
                walkType = 3;
            }
        }
            if (walkType == 3) imageIdx[3] = animate(movements[3], imageIdx[3]);
        } else {
            if (walkType == 3) {
                imageIdx[walkType] = 0;
                walkType = -1;
            }
            keyState[3] = 0;
        }
       
        if (!moved && prevWalkType != -1) {
            setImage(movements[prevWalkType][0]);
            imageIdx[prevWalkType] = 0;
            walkType = -1;
        }
        if (moved){
            ((IslandSystem)getWorld()).setMovingState(true);
        } else ((IslandSystem)getWorld()).setMovingState(false);
        
    }
    
    public void setSpeed(int x){
        speed=x;
    }
    
    public void setStop(boolean value){
        stop=value;
    }
    
    
}