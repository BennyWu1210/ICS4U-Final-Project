import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PuzzleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuzzleGame extends World
{
    private int [][]boxCoord=new int [12][2];
    private boolean [] state = new boolean[12];
    private PuzzlePiece []puzzle = new PuzzlePiece [12];
    private boolean allTrue = true;
    private IslandRight islandRight;
    /**
     * Constructor for objects of class PuzzleGame.
     * 
     */
    public PuzzleGame(IslandRight islandRight)
    {    
        super(1000,700,1);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.islandRight=islandRight;
        setPaintOrder(Label.class,PuzzlePiece.class, PuzzlePieceHolder.class);
        PuzzleBorder puzzleBorder = new PuzzleBorder();
        addObject(puzzleBorder, 350,354);
        
        PuzzleHolder holder = new PuzzleHolder();
        addObject(holder, 875,350);

        
        int idxP = 0;
        for(int i=0;i<12;i++){
            PuzzlePiece p = new PuzzlePiece("tile00"+i+".png",idxP);
            int x=getRandomNumber(800,975);
            int y=getRandomNumber(25,675);
            puzzle[idxP]=p;
            idxP++;
            addObject(p, x,y);
        }
        int idx=0;
        for(int i=0;i<3;i++){
            for(int j=0; j<4;j++){
                PuzzlePieceHolder h = new PuzzlePieceHolder();
                PuzzlePieceTrans p = new PuzzlePieceTrans("tile00"+idx+".png",100);
                p.setTrans();
                p.setMoveAble();
                int x=150*j+125;
                int y=150*i+203;
                boxCoord[idx][0]=x;
                boxCoord[idx][1]=y;
                addObject(h, x, y);
                addObject(p,x,y);
                idx++;
            }
        }
        BackButton back = new BackButton(islandRight);
        addObject(back, 66,50);
    }
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    public void act(){
        for(int i=0;i<12;i++){
            autoFit(i);
        }
        
        for(int i=0;i<12;i++){
            if(!state[i]){
                allTrue=false;
            }
        }
        if(allTrue){
            Label congra = new Label("Congratulation!", 70);
            addObject(congra, 500, 300);
        }else{
            allTrue=true;
        }
    }
    public void autoFit(int idx){
       
        
        if(Math.abs(puzzle[idx].getX() - boxCoord[idx][0]) < 10 && Math.abs(puzzle[idx].getY() - boxCoord[idx][1]) < 10){
            puzzle[idx].setLocation(boxCoord[idx][0],boxCoord[idx][1]);
            state[idx]=true;
            puzzle[idx].setMoveAble();
        }
    }

}
