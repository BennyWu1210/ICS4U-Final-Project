import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitlePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class TitlePage.
     * 
     */
    private MainIsland mworld;
    public TitlePage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        //set the background
        GreenfootImage background = new GreenfootImage("Background.png");
        background.scale(1000,700);
        setBackground(background);
        
        //add object to the class
        PlayButton play = new PlayButton(this);
        addObject(play, 391,314);
        Label title1 = new Label("Benny's", 50);
        Label title2 = new Label("Playground", 50);
        addObject(title1, 300,180);
        addObject(title2, 295,238);
    }
    
    /**
     * Set the world to mainisland world
     */
    public void startGame(){
        Greenfoot.setWorld(new MainIsland());
    }
}
