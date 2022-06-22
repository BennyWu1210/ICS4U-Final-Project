import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends GameTool
{
    private GreenfootImage[] images = new GreenfootImage[6];
    private int ticks, idx, coins;
    private Label coinLabel;
    public Coin(){
        
        for (int i = 0; i < 6; i++){
            images[i] = new GreenfootImage("Coin-" + (i + 1) + " (dragged).tiff");
        }
        
        setImage(images[idx]);
        coinLabel = new Label(coins, 50);
    }
    
    public void addedToWorld(World w){
        w.addObject(coinLabel, getX() + 60, getY());
    }
    
    public void act()
    {
        ticks ++;
        if (ticks % 10 == 0){
            idx = (idx + 1) % images.length;
            setImage(images[idx]);
        }
        
    }
    
    public void gainCoin(int c){
        coins += c;
        coinLabel.setValue(coins);
        new GreenfootSound("Coin_Sound.mp3").play();
    }
}
