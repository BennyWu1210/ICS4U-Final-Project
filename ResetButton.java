import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResetButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResetButton extends Button
{
    private GreenfootImage[] images = new GreenfootImage[2];
    private PuzzleGame page;
    /**
     * This set the default value for the back button.
     * 
     * @param page  The Modifier world to follow around
     */
    public ResetButton(PuzzleGame page)
    {
        initBackButton();//initialize the button
        this.page=page;
    }
    
    /**
     * Initializing the back button image
     */
    public void initBackButton()
    {
        images[0] = new GreenfootImage("resetDark.png"); 
        images[1] = new GreenfootImage("resetLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick(Cursor c)
    {
        if(c.isClicked(this))
        {
            clicksSound();
            page.restartGame();
        
        }
    }

    /**
     * Check if mouse hovers on this button
     */
    public void onHover(Cursor c)
    {
        if (intersects(c))
        {
            setImage(images[1]); //Light
        }
        else 
        {
            setImage(images[0]); //Dark
        }

    }
    
    
}
