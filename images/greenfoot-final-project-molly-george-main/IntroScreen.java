import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Introscreen here.
 * 
 * @author Molly Wu and George Lu
 * @version June 2022
 */
public class IntroScreen extends World
{
    GreenfootImage image;
    Dialogue dialogue;
    NextButton nextButton = new NextButton();
    
    /**
     * Constructor for objects of class Introscreen.
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 900x506 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 
        
        setBackground(new GreenfootImage("intropageee.jpg"));
        
        dialogue = new Dialogue();
        addObject(dialogue, 300, 50);
        
        
        addObject(nextButton, 730, 430);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(nextButton))
        {
            dialogue.ifNextButtonClicked = true;
            if(dialogue.idx == 5)
            {
                Instructions instructions = new Instructions();
                Greenfoot.setWorld(instructions);
            }
        }
        
    }
}
