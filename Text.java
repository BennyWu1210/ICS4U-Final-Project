import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Messages
{
    private SimpleTimer timer = new SimpleTimer();
    private int time;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text(String text, int font){
        setImage(new GreenfootImage(text, font, Color.BLACK, null));
        time=0;
    }
    public void act()
    {
        time++;
        if(time>200){
            
            getWorld().removeObject(this);
            time=0;
        }
    }
     public void onClick(){
        
    }
    
    public void onHover(){
        
    }

}
