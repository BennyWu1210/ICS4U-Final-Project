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
    private GreenfootImage[] bunnyFront = new GreenfootImage[4];
    private GreenfootImage[] bunnyBack = new GreenfootImage[4]; 
    private GreenfootImage[] bunnyLeft = new GreenfootImage[4]; 
    private GreenfootImage[] bunnyRight = new GreenfootImage[4]; 
    private int [] imageIdx = new int[4];
    
    //Use a timer to control the movement of the sprite
    SimpleTimer animation = new SimpleTimer();
    public Player(){
        for(int i=0;i<4;i++){//initialize all four direction movements
            bunnyFront[i] = new GreenfootImage("front"+i+".png");
            bunnyBack[i] = new GreenfootImage("back"+i+".png");
            bunnyLeft[i] = new GreenfootImage("left"+i+".png");
            bunnyRight[i] = new GreenfootImage("right"+i+".png");
            bunnyFront[i].scale(100,100);
            bunnyBack[i].scale(100,100);
            bunnyLeft[i].scale(100,100);
            bunnyRight[i].scale(100,100);
        }
        setImage(bunnyFront[0]);//set the begining pictures
    }
    
    /**
     * This method will update the sprite pictures when the user press the corresponding keys
     * @param animat, this is the GreenfoorImage array that is stored the direction images
     * @param idx, this is the index for this method to update the images with
     * @return  this will update the index of
     */
    public int animate(GreenfootImage[] animat, int idx){
        if(animation.millisElapsed()<150){
            return idx;
        }
        animation.mark();
        setImage(animat[idx]);
        idx= (idx+1)%4;
        return idx;
    }
    
    
    public void act()
    {
        //this will update the location for the player when they press the key
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-2);
            imageIdx[1]=animate(bunnyBack, imageIdx[1]);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+2);
            imageIdx[0]=animate(bunnyFront, imageIdx[0]);
        }
        
        if(Greenfoot.isKeyDown("left")){
            move(-2);
            imageIdx[2]=animate(bunnyLeft, imageIdx[2]);
        }
        
        if(Greenfoot.isKeyDown("right")){
            move(2);
            imageIdx[3]=animate(bunnyRight, imageIdx[3]);
        }
        
        
    }
}
