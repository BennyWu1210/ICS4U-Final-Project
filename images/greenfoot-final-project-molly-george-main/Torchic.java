import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Torchic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torchic extends Characters
{
    public static int TorchicX;
    public static int TorchicY;
    public static int tHP = 45;
    public static boolean enemy = true;
    public static int damage = 4;
    public static int speed = 4;
    public static boolean live = true;
    private SimpleTimer timer = new SimpleTimer();
    private GreenfootImage[] faceRight = new GreenfootImage[5];
    private GreenfootImage[] faceLeft = new GreenfootImage[5];
    private int stepCheck = 0;
    public static boolean upGrade = false;
    GreenfootSound ds = new GreenfootSound("damage.wav");
    
    public Torchic()
    {
        tHP = 45;
        setImage(new GreenfootImage("Torchic.png"));
        for(int i = 1; i <= faceRight.length; i++){
            faceRight[i - 1] = new GreenfootImage("t" + (i ) + ".png");
            faceRight[i - 1].mirrorHorizontally();
            
            faceLeft[i - 1] =new GreenfootImage("t" + (i ) + ".png");
            setImage(faceLeft[0]);
            
            timer.mark();
        }
    }
    
    
    public void act()
    {
        int TorchicX = getX();
        int TorchicY = getY();
        
        enemyT();
        
        enemyF();
        
    }
    
    
    public void enemyT()
    {
        if(enemy == true)
        {
            if(isTouching(NormalAttack.class))
            {
                ds.play();
                removeTouching(NormalAttack.class);
            }
            movementC(TorchicX, TorchicY);
        }
    }
    
    public void enemyF()
    {
        if(enemy != true)
        {
            if(live == true)
            {
                movementB(TorchicX, TorchicY, speed);
                
                removeTouching(EnemyAttack.class);
                
                
                if(isTouching(NinetalesAttack.class))
                {
                    tHP -= 8;
                    removeTouching(NinetalesAttack.class);
                }
                if(timer.millisElapsed() < 100)
                {
                    return;
                }
                    
                if(Greenfoot.isKeyDown("left"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                else if(Greenfoot.isKeyDown("right"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                else if(Greenfoot.isKeyDown("up"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                else if(Greenfoot.isKeyDown("down"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up"))
                {
                    setImage(faceRight[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up"))
                {
                    setImage(faceLeft[stepCheck]);
                    stepCheck++;
                    stepCheck %= 5;
                }
                
                timer.mark();
            }
            if(tHP <= 0)
            {
                live = false;
                tHP = 0;
            }
            
            
        }
    }
}
