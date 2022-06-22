import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyAttack here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class EnemyAttack extends Damage
{
    /**
     * Act - do whatever the EnemyAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public EnemyAttack(GreenfootImage image)
    {
        setImage(image);
    }
    
    public void act()
    {
        move(6);
        damage();
    }
    
    public void damage()
    {
        if(isTouching(Pikachu.class))
        {
            Pikachu.pHP -= 3;
        }
        if(isTouching(Charmander.class))
        {
            Charmander.cHP -= 3;
        }
        if(Torchic.enemy != true && isTouching(Torchic.class))
        {
            Torchic.tHP -= 3;
        }
        if(Bulbasaur.enemy != true && isTouching(Bulbasaur.class))
        {
            Bulbasaur.bHP -= 3;
        }
    }
}
