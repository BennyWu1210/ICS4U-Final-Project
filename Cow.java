import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cow extends Pet
{
    private int totalMoveAct, moveAct, dirX, dirY, moving, idx;
    public Cow(){
        images = new GreenfootImage[5][2];
        for (int i = 0; i <= 4; i++){
            images[i][0] = new GreenfootImage("cow" + i + ".png");
            images[i][1] = new GreenfootImage("cow" + i + ".png");
            images[i][1].mirrorHorizontally();
            
            images[i][0].scale(45, 30);
            images[i][1].scale(45, 30);
        }
        totalMoveAct = moveAct = 35 + (int)(Math.random() * 110);
        dirX = 1;
        dirY = 1;
        setImage(images[0][dirX]);
    }
    
    public void act(){
        if (moveAct <= 0){
            totalMoveAct = 35 + (int)(Math.random() * 110);
            
            int calc = Greenfoot.getRandomNumber(3);
            dirX = Greenfoot.getRandomNumber(2) == 0 ? 1 : -1;
            moving = Greenfoot.getRandomNumber(2) == 0 ? 1 : -1;
            
            animate();
            if (moving == 1){
                if (calc == 0) dirY = 1;
                else if (calc == 1) dirY = -1;
                else dirY = 0;
                
                if (getY() >= 600) dirY = -1;
                else if (getY() <= 320) dirY = 1;
                if (getX() <= 250) dirX = 1;
                else if (getX() >= 780) dirX = -1;
            }
            else if (moving == -1){
                idx = 0;
                totalMoveAct /= 2.2;
                setImage(images[0][dirX == 1 ? 0 : 1]);
            }
            moveAct = totalMoveAct;
            
        }
        moveAct --;
        
        if ((totalMoveAct - moveAct ) % 8 == 0 && moving == 1){
            animate();
        }
        
        if (moveAct % 2 == 0 && moving == 1){
            setLocation(getX() + dirX, getY() + dirY);
        }
        
    }
    
    
    /**
     * This method will update the sprite pictures when the user press the corresponding keys
     * @param animat, this is the GreenfoorImage array that is stored the direction images
     * @param idx, this is the index for this method to update the images with
     * @return  this will update the index of
     */
    public int animate(){
        idx = idx % 4 + 1;
        setImage(images[idx][dirX == 1 ? 0 : 1]);
        
        return idx;
    }
}
