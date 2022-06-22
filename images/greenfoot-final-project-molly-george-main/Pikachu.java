import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for pikachu
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pikachu extends Characters
{
    public static int pikachuX;
    public static int pikachuY;
    public static int pHP = 65;
    public static int damage = 4;
    public static int speed = 4;
    public static boolean live = true;
    private SimpleTimer timer = new SimpleTimer();
    private GreenfootImage[] faceRight = new GreenfootImage[7];
    private GreenfootImage[] faceLeft = new GreenfootImage[7];
    private int stepCheck = 0;
    public static boolean upGrade = false;
    
    
    
    public Pikachu()
    {
        pHP = 65;
        setImage(new GreenfootImage("pikachu.png"));
        for(int i = 1; i <= faceRight.length; i++){
            faceRight[i - 1] = new GreenfootImage("p" + (i ) + ".png");
            
            
            faceLeft[i - 1] =new GreenfootImage("p" + (i ) + ".png");
            faceLeft[i - 1].mirrorHorizontally();
            setImage(faceLeft[0]);
            
            timer.mark();
        }
    }
    
    
    public void act()
    {
        pikachuX = getX();
        pikachuY = getY();
        
        play();
        
        
        
    }
    
    //This let the player to control the Pikachu
    public void play()
    {
        if(live == true)
        {
            movementA(pikachuX, pikachuY, speed);
            removeTouching(EnemyAttack.class);
            if(isTouching(EeveeAttack.class))
            {
                Pikachu.pHP -= 6;
            }
            removeTouching(EeveeAttack.class);
            if(isTouching(RowletAttack.class))
            {
                speed = 0;
            }
            else
            {
                speed = 4;
            }
            removeTouching(BulbasaurAttack.class);
            if(isTouching(FennekinAttack.class))
            {
                pHP -= 5;
                removeTouching(FennekinAttack.class);
            }
            if(isTouching(NinetalesAttack.class))
            {
                pHP -= 8;
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
        if(pHP <= 0)
        {
            live = false;
            pHP = 0;
        }
    }
    
    
}
