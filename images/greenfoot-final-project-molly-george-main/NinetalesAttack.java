import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NinetalesAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NinetalesAttack extends Damage
{
    public NinetalesAttack()
    {
        setImage(new GreenfootImage("fireball.png"));
        
    }
    
    public void act()
    {
        move(4);
        
    }
}
