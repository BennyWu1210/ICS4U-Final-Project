import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitButton extends Button
{
    private MainIsland page;
    private GreenfootImage[] images = new GreenfootImage[2];
    /**
     * This set the default value for the back button.
     * 
     * @param page  The Modifier world to follow around
     */
    public ExitButton(MainIsland page)
    {
        initBackButton();//initialize the button
        this.page=page;//initialize the page
    }
   
    /**
     * Initializing the back button image
     */
    public void initBackButton()
    {
        images[0] = new GreenfootImage("exitDark.jpg"); 
        images[1] = new GreenfootImage("exitLight.png"); 
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
            //Switch to the Island right world page
            page.returnToMainIsland();
            getWorld().removeObject(this);
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
