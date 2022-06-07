import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    private PianoGame page;
    private GreenfootImage[] images = new GreenfootImage[2];
    /**
     * This set the default value for the back button.
     * 
     * @param page  The Modifier world to follow around
     */
    public BackButton(PianoGame page)
    {
        initBackButton();//initialize the button
        this.page=page;//initialize the page
    }
    public void act(){
        onClick();
        onHover();
    }
    /**
     * Initializing the back button image
     */
    public void initBackButton()
    {
        images[0] = new GreenfootImage("backButtonDark.png"); 
        images[1] = new GreenfootImage("backButtonLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the Title page
            page.returnIslandRight();
        }
    }

    /**
     * Check if mouse hovers on this button
     */
    public void onHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(images[1]); //Light
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(images[0]); //Dark
        }

    }
}
