import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitBox extends Actor
{
    /**
     * Act - do whatever the HitBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Player p;
    private boolean stop;
    private GreenfootImage rect;
    public HitBox(Player p){
        this.p=p;
        rect = new GreenfootImage(45, 45);
        rect.fillRect(5,0,50,50);
        rect.scale(20,45);
        rect.setTransparency(100);
        setImage(rect);
    }
    public void act()
    {
        int explore=15;
        follow();
        if (Greenfoot.isKeyDown("down")){
            rect.scale(20,45);
            setImage(rect);
            setLocation(getX(), getY()+explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("up")){
            rect.scale(20,45);
            setImage(rect);
            setLocation(getX(), getY()-explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("left")){
            rect.scale(20,45);
            setImage(rect);
            setLocation(getX()-explore, getY());
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                stop=false;
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+explore, getY());
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }
        
    }
    public boolean getStop(){
        return stop;
    }
    public void follow(){
        setLocation(p.getX(), p.getY());
    }
    
    /**
     * This method check whether the player touch the border or not
     * @return boolean value about whether touch the side or not
     */
    public boolean touchBorder(){
        if(isTouching(MapBorder.class)){
            return true;
        }else{
            return false;
        }
        
    }
}
