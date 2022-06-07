import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PianoGame extends World
{
    String [] whiteKeyNames = {"q","w","e","r","t","y","u","i","o","p","[","]"};
    String [] whiteFileNames = {"3Dol", "3Re", "3Mi", "3Fa", "3Sol", "3La", "3Si", "4Dol", "4Re", "4Mi","4Fa", "4Sol" };
    
    String [] blackKeyNames = {"2","3","","5","6","7","","9","0","","="};
    String [] blackFileNames = {"3Dol#", "3Re#","", "3Fa#", "3Sol#","3La#", "", "4Dol#", "4Re#","", "4Fa#"};
    private IslandRight islandRight;
    /**
     * Constructor for objects of class Piano.
     * 
     */
    public PianoGame(IslandRight islandRight)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        this.islandRight=islandRight;
        for(int i=0;i<12;i++){
            PianoKey whiteKey = new PianoKey(whiteKeyNames[i],whiteFileNames[i]+".wav", "whiteUp.png", "whiteDown.png");
            addObject(whiteKey, 54+i*63 , 200); 
            Label label = new Label(whiteKeyNames[i],40);
            addObject(label, 54+i*63 , 280);  
        }
        for(int i=0;i<blackKeyNames.length;i++){
            if(blackFileNames[i] != ""){
                
                PianoKey blackKey = new PianoKey(blackKeyNames[i],blackFileNames[i]+".wav", "blackUp.png", "blackDown.png");
                addObject(blackKey, 86+i*63 , 156); 
                Label label = new Label(blackKeyNames[i],30);
                addObject(label, 86+i*63 , 150); 
            }
        }
        BackButton back = new BackButton(this);
        addObject(back, 73,435);
    }
    public void returnIslandRight(){
        Greenfoot.setWorld(islandRight);
    }
}
