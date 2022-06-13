import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Plant
{
    private int actCounter, actDuration;
    private boolean hasFruit;
    public Tree(){
        super(new GreenfootImage("Tree1_empty.png"), true);
        actDuration = (int)(120 * Math.random()) + 300;
    }
    
    public void act(){
        super.act();
        
        if (actCounter == actDuration){
            actCounter = 0;
            actDuration = Integer.MAX_VALUE;
            setImage("Tree1_fruit.png");
            hasFruit = true;
        }
        actCounter ++;
    }
    
    public void onClick(){
        if (hasFruit && Greenfoot.mouseClicked(this)){
            actDuration = (int)(120 * Math.random()) + 300;
            hasFruit = false;
            setImage("Tree1_empty.png");
        }
    }
}
