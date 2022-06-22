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
    /**
     * Act - do whatever the PuzzlePiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void followMouse(Cursor c){
        //MouseInfo mouse = Greenfoot.getMouseInfo();
        if(c.isDragged(this)&&!moveable){
            setLocation(c.getX(), c.getY());
            
        }
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
