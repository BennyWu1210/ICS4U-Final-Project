import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Button extends Actor
{
      protected GreenfootImage[] images = new GreenfootImage[2];
    private GreenfootSound[] clickSound;
    private int clickSoundIndex;
    
    //Create a play click sound method
    public void clicksSound(){
        //set up and initalize for the sound preparation
        clickSoundIndex=0;
        clickSound=new GreenfootSound [20];
        for(int i=0;i<clickSound.length;i++){
            clickSound[i]=new GreenfootSound("Click.wav");
        }
        
        //output
        clickSound[clickSoundIndex].setVolume(80);
        clickSound[clickSoundIndex].play();
        clickSoundIndex++;
        if(clickSoundIndex>clickSound.length-1){
            clickSoundIndex=0;
        }
    }
    

    // Stores the initial image and the image when hovered 
    public abstract void onClick(Cursor c);
    public abstract void onHover(Cursor c);
    
}
