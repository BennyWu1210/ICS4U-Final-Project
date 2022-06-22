import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    private TitlePage page;
    /**
     * This set the default value for the back button.
     * 
     * @param page  The Modifier world to follow around
     */
    public PlayButton(TitlePage page)
    {
        super();
        initBackButton();//initialize the button
        this.page = page;
        images[0].scale(150, 63);
        images[1].scale(150, 63);
    }

    /**
     * Initializing the back button image
     */
    public void initBackButton()
    {
        images[0] = new GreenfootImage("playDark.png"); 
        images[1] = new GreenfootImage("playLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick(Cursor cursor)
    {
        if (cursor.isClicked(this)){
            //Switch to the Title page
            clicksSound();
            page.startGame();
        }
        
    }

    /**
     * Check if mouse hovers on this button
     */
    public void onHover(Cursor cursor)
    {
        if (intersects(cursor))
        {
            setImage(images[1]); //Light
        }
        else
        {
            setImage(images[0]); //Dark
        }

    }

}
