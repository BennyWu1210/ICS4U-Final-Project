import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piano extends Interactor
{

    
    public Piano(){
        GreenfootImage piano = new GreenfootImage("Piano.png");
        piano.scale(45, 35);
        setImage(piano);
    }
   
    public void act(){
        super.act();
        if (actCounter % 100 == 0){
            setLocation(getX(), getY() + 5);
        } else if (actCounter % 100 == 50){
            setLocation(getX(), getY() - 5);
        }
    }
    
    public void onClick(){
        
    }
    
    public void onHover(){
        if (isTouching(Cursor.class)){
            getImage().scale(54, 42);
        }
        else {
            getImage().scale(45, 35);
        }
    }
}
