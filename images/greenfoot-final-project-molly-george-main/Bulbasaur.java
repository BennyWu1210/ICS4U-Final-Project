import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bulbasaur here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Bulbasaur extends Characters
{
    public static int bulbasaurX;
    public static int bulbasaurY;
    public static int bHP = 50;
    public static boolean enemy = true;
    public static int damage = 4;
    public static int speed = 4;
    public static boolean live = true;
    private SimpleTimer timer = new SimpleTimer();
    private GreenfootImage[] faceRight = new GreenfootImage[7];
    private GreenfootImage[] faceLeft = new GreenfootImage[7];
    private int stepCheck = 0;
    public static boolean upGrade = false;
    GreenfootSound ds = new GreenfootSound("damage.wav");
    
    public Bulbasaur()
    {
        bHP = 50;
        setImage(new GreenfootImage("bulbasaur.png"));
        for(int i = 1; i <= faceRight.length; i++){
            faceRight[i - 1] = new GreenfootImage("b" + (i ) + ".png");
            faceRight[i - 1].mirrorHorizontally();
            
            faceLeft[i - 1] =new GreenfootImage("b" + (i ) + ".png");
            setImage(faceLeft[0]);
            
            timer.mark();
        }
    }
    
    public void act()
    {
        int bulbasaurX = getX();
        int bulbasaurY = getY();
        
        enemyT();
        
        enemyF();
        
    }
    
    //This method will make Bulbasaur do what an enemy shoudl do
    public void enemyT()
    {
        if(enemy == true)
        {
            if(isTouching(NormalAttack.class))
            {
                ds.play();
                removeTouching(NormalAttack.class);
            }
            
            movementC(bulbasaurX, bulbasaurY);
        }
    }
    
    //This is the method to make bulbasaur do what the player tell it to do, as it is friendly now
    public void enemyF()
    {
        if(enemy != true)
        {
            if(live == true)
            {
                movementA(bulbasaurX, bulbasaurY, speed);
                removeTouching(EnemyAttack.class);
                if(isTouching(FennekinAttack.class))
                {
                    bHP -= 5;
                    removeTouching(FennekinAttack.class);
                }
                if(isTouching(NinetalesAttack.class))
                {
                    bHP -= 8;
                    removeTouching(NinetalesAttack.class);
                }
                if(timer.millisElapsed() < 100)
                {
                    return;
                }
                    
                if(Greenfoot.isKeyDown("a"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                else if(Greenfoot.isKeyDown("d"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                else if(Greenfoot.isKeyDown("w"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                else if(Greenfoot.isKeyDown("s"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 7;
                }
                
                timer.mark();
            }
            if(bHP <= 0)
            {
                live = false;
                bHP = 0;
            }
            
        }
    }

}
