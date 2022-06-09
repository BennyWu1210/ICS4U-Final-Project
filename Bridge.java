import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bridge extends Actor
{
    /**
     * Act - do whatever the Bridge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage bri;
    
    public Bridge(int choice){
        //used to set up the bridge set up
        if(choice==1){
            bri = new GreenfootImage("EndBridge.png");
            bri.mirrorHorizontally();
            
            setImage(bri);
        }else if(choice ==2){
            bri = new GreenfootImage("MiddleBridge.png");
            setImage(bri);
        }else if(choice==3){
            bri = new GreenfootImage("EndBridge.png");
            setImage(bri);
        }
                
    }
    public void act()
    {
        // Add your action code here.
    }
}
