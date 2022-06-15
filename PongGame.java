import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongGame  extends World
{
    int dx = 10;
    int dy = 0;
    Bar player = new Bar();
    Computer computer = new Computer();
    Ball ball = new Ball();
    Score1 s1 = new Score1();
    Score2 s2 = new Score2();
    GreenfootImage read1 = new GreenfootImage(100,30);
    GreenfootImage read2 = new GreenfootImage(100,30);
    int p = 0;
    int c = 0;
    String pScore = String.valueOf(p);
    String cScore = String.valueOf(c);
    private IslandRight islandRight;
    
    public PongGame(IslandRight islandRight)
    {    
        super(550, 400, 1);
        this.islandRight=islandRight;
        setBackground(new GreenfootImage("court.jpg"));
        addObject(player, 50, getHeight()/2);
        addObject(computer, getWidth()-50 , getHeight()/2);
        addObject(ball, getWidth()/2, getHeight()/2);
        read1.drawString(pScore,2,20);
        s1.setImage(read1);
        addObject(s1,getWidth()/4,50);
        read2.drawString(cScore, 2, 20);
        s2.setImage(read2);
        addObject(s2,(getWidth()/4)*3,50);
        Greenfoot.setSpeed(45);
        
        
    }
    public void act(){
        
        if(Greenfoot.isKeyDown("up")){
            player.setLocation(player.getX(), player.getY() - 5);
        }
        if(Greenfoot.isKeyDown("down")){
            player.setLocation(player.getX(), player.getY() + 5);
        }
        ball.setLocation(ball.getX() + dx, ball.getY() + dy);
        if(ball.getY() < computer.getY() + 5 && ball.getY() > computer.getY() - 5){
            computer.setLocation(computer.getX(), ball.getY());
        }
        else{
            if(ball.getY() > computer.getY()){
                computer.setLocation(computer.getX(),computer.getY() + 5);
            }
            else{
                computer.setLocation(computer.getX(),computer.getY() - 5);
            }
        }
        if(ball.getY() >= computer.getY() - 25 && ball.getY() <= computer.getY() + 25 && ball.getX() + dx >= computer.getX()){
            dx = -dx;
            dy = (ball.getY() - computer.getY())/2;
            Greenfoot.playSound("beep.wav");
        }
        if(ball.getY() >= player.getY() - 25 && ball.getY() <= player.getY() + 25 && ball.getX() + dx <= player.getX()){
            dx = -dx;
            dy = (ball.getY() - player.getY())/2;
            Greenfoot.playSound("beep.wav");
        }
        if(ball.getY() <= 5){
            ball.setLocation(ball.getX(),6);
            dy = - dy;
        }
        if(ball.getY() >= this.getHeight() - 5 ){
            ball.setLocation(ball.getX(),this.getHeight() -6);
            dy = -dy;
        }
        else if(ball.getX() <= 5 || ball.getX() >= this.getWidth() -5){
                if(ball.getX() <= 5){
                c++;
                cScore = String.valueOf(c);
                read2.clear();
                read2.drawString(cScore,2,20);
                s2.setImage(read2);
            }
            else if( ball.getX() >= this.getWidth() -5){
                p++;
                pScore = String.valueOf(p);
                read1.clear();
                read1.drawString(pScore,2,20);
                s1.setImage(read1);
            }
            ball.setLocation(getWidth()/2, getHeight()/2);
            player.setLocation(50, getHeight()/2);
            computer.setLocation(getWidth()-50 , getHeight()/2);
            dy = 0;
            
                
        }
    }
}
