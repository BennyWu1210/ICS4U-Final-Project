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
        rect.setTransparency(0);
        setImage(rect);
    }
    public void act()
    {
        int explore=15;
        follow();
        if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left")){
            setLocation(getX()-explore, getY()+explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right")){
            setLocation(getX()+explore, getY()+explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("up")&& Greenfoot.isKeyDown("left")){
            setLocation(getX()-explore, getY()-explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                stop=false;
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("up")&& Greenfoot.isKeyDown("left")){
            setLocation(getX()+explore, getY()-explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-explore);
            if(touchBorder()){
                p.setSpeed(0);
            }else{
                p.setSpeed(3);
            }
        }else if (Greenfoot.isKeyDown("left")){
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
        if(isTouching(InvisibleBorder.class)){
            return true;
        }else{
            return false;
        }
        
    }
}
