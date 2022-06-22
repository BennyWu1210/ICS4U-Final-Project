import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulbasaurAttack here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class BulbasaurAttack extends Damage
{
    /**
     * Act - do whatever the BulbasaurAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BulbasaurAttack(GreenfootImage image)
    {
        setImage(image);
        
    }
    
    public void act()
    {
        move(4);
        if(isTouching(Pikachu.class))
        {
            Pikachu.pHP -= 4;
        }
        if(isTouching(Charmander.class))
        {
            Charmander.cHP -= 4;
        }
    }
}
