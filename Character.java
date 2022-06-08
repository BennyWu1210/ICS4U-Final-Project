import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Entity
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] bunnyFront = new GreenfootImage[4];
    private SimpleTimer timer = new SimpleTimer();
    public Character(){
         for(int i=0;i<4;i++){
             bunnyFront[i] = new GreenfootImage("front" + i + ".png");
             bunnyFront[i].scale(65,70);
        }
        setImage(bunnyFront[0]);
    }
    public void act()
    {
        animated();
    }
    int idx=0;
    public void animated(){
        if(timer.millisElapsed()<300){
            return;
        }
        timer.mark();
        setImage(bunnyFront[idx]);
        idx = (idx+1)%4;
    }
}
