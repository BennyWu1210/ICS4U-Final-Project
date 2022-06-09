import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puzzle extends Interactor
{
    /**
     * Act - do whatever the Puzzle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Puzzle(){
        
    }
    public void act()
    {
        // Add your action code here.
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
