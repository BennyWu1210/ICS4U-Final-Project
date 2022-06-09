import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PuzzlePieceTrans here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuzzlePieceTrans extends GameTool
{
    private String file;
    private boolean moveable;
    private int idx;
    private int [][]boxCoord=new int [12][2];
    private GreenfootImage puzzle ;

    public PuzzlePieceTrans(String file,int idx){
        this.idx=idx;
         puzzle = new GreenfootImage(file);
        puzzle.scale(150,150);
        
        setImage(puzzle);
    }
    /**
     * Act - do whatever the PuzzlePieceTrans wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    
        followMouse();
    
    }
    
    public void followMouse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseDragged(this)&&!moveable){
            setLocation(mouse.getX(), mouse.getY());
            
        }
    }
    
    public void setMoveAble(){
        moveable=true;
    }
    
    public boolean touchPuzzle(){
        if(isTouching(PuzzlePieceTrans.class)){
            return true;
        }
        return false;
    }
    
    public void setTrans(){
        puzzle.setTransparency(30);
    }
    
    
        
}
