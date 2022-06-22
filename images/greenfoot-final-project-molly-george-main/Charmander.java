import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charmander here.
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Charmander extends Characters
{
    public int CharmanderX;
    public int CharmanderY;
    public static int cHP = 65;
    public static int damage = 4;
    public static int speed = 4;
    public static boolean live = true;
    private SimpleTimer timer = new SimpleTimer();
    private GreenfootImage[] faceRight = new GreenfootImage[6];
    private GreenfootImage[] faceLeft = new GreenfootImage[6];
    private int stepCheck = 0;
    public static boolean upGrade = false;
    
    public Charmander()
    {
        cHP = 65;
        setImage(new GreenfootImage("Charmander.png"));
        for(int i = 1; i <= faceRight.length; i++){
            faceRight[i - 1] = new GreenfootImage("c" + (i ) + ".png");
            
            faceLeft[i - 1] = new GreenfootImage("c" + (i ) + ".png");
            faceLeft[i - 1].mirrorHorizontally();
            setImage(faceLeft[0]);
            
            timer.mark();
        }
    }
    
    public void act()
    {
        int CharmanderX = getX();
        int CharmanderY = getY();
        
        play();
        
    }
    
    //This method meant to let charmander control by the player
    public void play()
    {
        if(live == true)
        {
            movementB(CharmanderX,CharmanderY, speed);
            removeTouching(EnemyAttack.class);
            if(isTouching(EeveeAttack.class))
            {
                Charmander.cHP -= 6;
            }
            if(isTouching(RowletAttack.class))
            {
                speed = 0;
            }
            else
            {
                speed = 4;
            }
            removeTouching(EeveeAttack.class);
            removeTouching(BulbasaurAttack.class);
            if(isTouching(FennekinAttack.class))
            {
                cHP -= 5;
                removeTouching(FennekinAttack.class);
            }
            if(isTouching(NinetalesAttack.class))
            {
                cHP -= 8;
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
                stepCheck %= 6;
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                setImage(faceRight[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            else if(Greenfoot.isKeyDown("up"))
            {
                setImage(faceRight[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                setImage(faceRight[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down"))
            {
                setImage(faceLeft[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down"))
            {
                setImage(faceRight[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up"))
            {
                setImage(faceRight[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up"))
            {
                setImage(faceLeft[stepCheck]);
                stepCheck++;
                stepCheck %= 6;
            }
            
            timer.mark();
        }
        if(cHP <= 0)
        {
            live = false;
            cHP = 0;
        }
    }
    
    
}
