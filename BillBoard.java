import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BillBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BillBoard extends Interactor
{
    /**
     * Act - do whatever the BillBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Sign sign;
    
    public BillBoard(){
        setImage("BillBoard.png");
        getImage().scale(35, 35);
    }
 
    public void onClick(){
        
    }
    
    public void onHover(){
        if (isTouching(Cursor.class)){
            getImage().scale(45, 45);
        }
        else {
            getImage().scale(35, 35);
        }
    }
    
 
    
}
