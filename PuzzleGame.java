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
    private boolean finished=false;
    private Text congra;
    private BackButton back ;
    private ResetButton reset;
    
    private Cursor cursor;
    /**
     * Constructor for objects of class PuzzleGame.
     * 
     */
    public PuzzleGame(IslandRight islandRight)
    {    
        super(1000,700,1);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.islandRight=islandRight;
        setPaintOrder(Cursor.class,Text.class,PuzzlePiece.class, PuzzlePieceHolder.class);
        PuzzleBorder puzzleBorder = new PuzzleBorder();
        addObject(puzzleBorder, 350,354);
        
        PuzzleHolder holder = new PuzzleHolder();
        addObject(holder, 875,350);
        cursor = new Cursor();
        initialize();
        int idx=0;
        for(int i=0;i<3;i++){
            for(int j=0; j<4;j++){
                PuzzlePieceHolder h = new PuzzlePieceHolder();
                PuzzlePieceTrans p = new PuzzlePieceTrans("tiles00"+idx+".png",100);
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
        
        back = new BackButton(islandRight);
        addObject(back, 66,50);
        
        reset = new ResetButton(this);
        addObject(reset, 616, 50);
        congra = new Text("Congratulation!", 70);
        
    }
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public void act(){
        
        reset.onClick();
        reset.onHover();
        back.onClick();
        back.onHover();
        
       
        
        
        
        for(int i=0;i<12;i++){
            autoFit(i);
        }
        
        for(int i=0;i<12;i++){
            if(!state[i]){
                allTrue=false;
                break;
            }
        }
        if(allTrue){
            addObject(congra, 500, 300);
            allTrue=false;
            finished=true;
            return;
            
        }else if(!allTrue&&!finished){
            allTrue=true;
        }
    }
    public void autoFit(int idx){
        
        if(Math.abs(puzzle[idx].getX() - boxCoord[idx][0]) < 16 && Math.abs(puzzle[idx].getY() - boxCoord[idx][1]) < 16){
            puzzle[idx].setLocation(boxCoord[idx][0],boxCoord[idx][1]);
            state[idx]=true;
            puzzle[idx].setMoveAble();
        }
    }
    
    public void initialize(){
        int idxP = 0;
        for(int i=0;i<12;i++){
            PuzzlePiece p = new PuzzlePiece("tiles00"+i+".png",idxP);
            int x=getRandomNumber(800,975);
            int y=getRandomNumber(25,675);
            puzzle[idxP]=p;
            idxP++;
            addObject(p, x,y);
        }
        
    }
    
    public void restartGame(){
        removeObjects(getObjects(PuzzlePiece.class));
        finished=false;
        for(int i=0;i<12;i++){
            state[i]=false;
        }
        initialize();
    }
}
