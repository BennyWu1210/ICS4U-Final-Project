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
    private String file;
    public Puzzle(){
        GreenfootImage puzzle = new GreenfootImage("puzzle.png");
        puzzle.scale(45,45);
        setImage(puzzle);
        
    }
    public void act()
    {
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
            getImage().scale(55, 55);
        }
        else {
            getImage().scale(45, 45);
        }
    }
}
