import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PuzzlePiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuzzlePiece extends GameTool
{
    private String file;
    private boolean moveable;
    private int idx;
    private int [][]boxCoord=new int [12][2];
    private GreenfootImage puzzle ;

    public PuzzlePiece(String file,int idx){
        this.idx=idx;
         puzzle = new GreenfootImage(file);
        puzzle.scale(150,150);
        setImage(puzzle);
    }
    public void act(){
        followMouse();
    }

    public boolean followMouse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseDragged(this)&&!moveable){
            setLocation(mouse.getX(), mouse.getY());
            return true;
        }
        return false;
    }
    
    public void setMoveAble(){
        moveable=true;
    }
    
    public boolean touchPuzzle(){
        if(isTouching(PuzzlePiece.class)){
            return true;
        }
        return false;
    }
    
    public void setTrans(){
        puzzle.setTransparency(30);
    }
    
    
        
}
