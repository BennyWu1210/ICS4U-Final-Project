import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalAttack here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class NormalAttack extends Damage
{
    public int damage1;
    
    
    public NormalAttack(GreenfootImage image, int damage)
    {
        setImage(image);
        damage1 = damage;
        if(Battle.right == true)
        {
            setRotation(0);
        }
        if(Battle.left == true)
        {
            setRotation(180);
        }
        if(Battle.up == true)
        {
            setRotation(270);
        }
        if(Battle.down == true)
        {
            setRotation(90);
        }
        if(Battle.up && Battle.left)
        {
            setRotation(225);
        }
        if(Battle.down && Battle.left)
        {
            setRotation(135);
        }
        if(Battle.down && Battle.right)
        {
            setRotation(45);
        }
        if(Battle.up && Battle.right)
        {
            setRotation(315);
        }
        
    }
    
    
    public void act()
    {
        move(4);
        damage();
        if(isTouching(EeveeAttack.class))
        {
            removeTouching(EeveeAttack.class);
        }
        if(isTouching(RowletAttack.class))
        {
            removeTouching(RowletAttack.class);
        }
        
    }
    
    public void damage()
    {
        
        if(isTouching(Eevee.class))
        {
            Eevee.eHP -= damage1;
        }
        if(isTouching(Fennekin.class))
        {
            Fennekin.fHP -= damage1;
        }
        if(isTouching(Ninetales.class))
        {
            Ninetales.nHP -= damage1;
        }
        if(isTouching(Rowlet.class))
        {
            Rowlet.rHP -= damage1;
        }
        if(isTouching(Bulbasaur.class) && Bulbasaur.enemy == true)
        {
            Bulbasaur.bHP -= damage1;
        }
        if(isTouching(Torchic.class) && Torchic.enemy == true)
        {
            Torchic.tHP -= damage1;
        }
    }
    
    
    
    
}
