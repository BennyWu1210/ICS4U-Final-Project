import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBoard extends Messages
{
    private int width;
    private int height;
    public TextBoard(int width, int height){
        this.width=width;
        this.height=height;
        GreenfootImage image= new GreenfootImage("TextBoard.png");
        image.scale(width,height);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
