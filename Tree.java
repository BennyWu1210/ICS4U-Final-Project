import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Decoration
{
    private int actCounter, actDuration;
    private boolean hasFruit;
    private Cursor cursor;
    public Tree(Cursor cursor){
        super(new GreenfootImage("Tree1_empty.png"), true);
        this.cursor = cursor;
        getImage().scale(75, 100);
        actDuration = (int)(120 * Math.random()) + 300;
    }
    
    public void act(){
        super.act();
        
        onClick();
        if (actCounter == actDuration){
            actCounter = 0;
            actDuration = Integer.MAX_VALUE;
            setImage("Tree1_fruit.png");
            hasFruit = true;
        }
        actCounter ++;
        
    }
    
    public void onClick(){
        if (hasFruit && cursor.isClicked(this)){
            actDuration = (int)(120 * Math.random()) + 300;
            hasFruit = false;
            setImage("Tree1_empty.png");
            getImage().scale(75, 100);
            ((IslandSystem)getWorld()).getCoin().gainCoin((int)(Math.random() * 7) + 3);
            
        }
    }
}
