import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PianoKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PianoKey extends Actor
{
    private String key;
    private String sound;
    private String up;
    private String down;
    private boolean isPressed;
    /**
     * Act - do whatever the PianoKey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PianoKey(String key, String sound, String up, String down){
        setImage(up);
        this.key=key;
        this.sound=sound;
        this.up=up;
        this.down=down;
    }
    public void act()
    {
        keyPressed();
    }
   
    public void keyPressed(){
        if(Greenfoot.isKeyDown(key)&&!isPressed){
            setImage(down);
            playSound();
            isPressed=true;
        }
        if(!Greenfoot.isKeyDown(key)&&isPressed){
            setImage(up);
            isPressed=false;
        }
    }
    
    public void playSound(){
        Greenfoot.playSound(sound);
    }
}
