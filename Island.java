import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island extends Actor
{
    public Island(int choice){
        if(choice==0){
            setImage("Map.png");
            getImage().scale(870, 470);
        }
        if(choice==1){
            setImage("IslandRight.png");
            getImage().scale(600, 430);
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
