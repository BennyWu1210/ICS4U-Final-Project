import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Interactor
{
    public House(){
        setImage("House.png");
        getImage().scale(92, 92);
    }
    
    public void act(){
        onHover();
    }
    
    public void onClick(){
        
    }
    
    public void onHover(){
        if (isTouching(Cursor.class)){
            getImage().scale(115, 115);
        }
        else {
            getImage().scale(92, 92);
        }
    }
}
