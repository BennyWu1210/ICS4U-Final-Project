import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IslandRight here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IslandRight extends IslandSystem {

    private int actCounter, test;
    private IslandSystem previousIsland;

    private Sign pianoSign;
    private TextBoard pianoBoard;
    private BillBoard pianoBillBoard;
    private Label pianoText[] = new Label[3];
    private Label spaceContinue[] = new Label[3];
    private boolean isPressed;
    private int pianoOrder = 0;
    private PianoGame pianoWorld;
    private Piano piano;
    
    private Puzzle puzzle;
    private Sign puzzleSign;
    private PuzzleGame puzzleWorld;
    private TextBoard puzzleBoard;
    private BillBoard puzzleBillBoard;
    private Label puzzleText[] = new Label[3];
    private Label puzzleContinue[] = new Label[3];
    private int puzzleOrder = 0;

    /**
     * Constructor for objects of class IslandRight.
     * 
     */
    public IslandRight(IslandSystem previousIsland) {
        super();
        // Allow infinite grid to ensure flexibility. However, ensure that objects can
        // not go outside easily
        this.previousIsland = previousIsland;
        pianoWorld = new PianoGame(this);
        puzzleWorld = new PuzzleGame(this);

        drawBorder();

        // testing mouse cursor
        island = new Island(1);
        addObject(island, 500, 350);
        player = new Player(1, this);
        addObject(player, 5, 471);

        Bridge miB = new Bridge(2);
        addObject(miB, 48, 471);

        Bridge miB2 = new Bridge(2);
        addObject(miB2, 116, 471);
        
        Bridge rB = new Bridge(3);
        addObject(rB, 181, 471);

        piano = new Piano();
        addObject(piano, 495, 176);

        pianoBillBoard = new BillBoard();
        addObject(pianoBillBoard, 448, 175);

        pianoSign = new Sign();
        pianoBoard = new TextBoard(800, 300);
        pianoText[0] = new Label("Welcome to the piano game!", 40);
        pianoText[1] = new Label("In this game, fell free to try out different\n songs you like!", 40);
        pianoText[2] = new Label("Press Space to play!", 55);
        
        puzzle = new Puzzle();
        addObject(puzzle, 275,277);
        puzzleBillBoard = new BillBoard();
        addObject(puzzleBillBoard, 319, 277);

        puzzleSign = new Sign();
        puzzleBoard = new TextBoard(800, 300);
        puzzleText[0] = new Label("Welcome to the puzzle game!", 40);
        puzzleText[1] = new Label("In this game, Try to assemble the pictures!", 40);
        puzzleText[2] = new Label("Press Space to play!", 55);

        spaceContinue[0] = new Label("Press Space to continue...", 25);
        spaceContinue[1] = spaceContinue[0];
        spaceContinue[2] = new Label("", 0);

        addPlants();
        
        
    }

    public void act() {
        // Call the wave effect every 50 acts
        if (player.getX() < -50) {
            returnPreviousIsland();
        }
        if (actCounter % 50 == 0)
            waveEffect();

        Border.show = !moving;
        actCounter++;
        interact();
    }

    public void addPlants(){
        addObject(new Mushroom(), 750, 420);
        
        addObject(new Trunk(), 600, 250);
        
        addObject(new BushTree(), 730, 350);
        addObject(new BushTree(), 750, 390);
       
        addObject(new Rock(), 688, 385);
        addObject(new Rock(), 600, 535);
        addObject(new Rock(), 700, 220);
        
        addObject(new Tree(cursor), 575, 485);
        addObject(new Tree(cursor), 655, 430);
        addObject(new Tree(cursor), 320, 405);
    }
    
    public void interact() {
        if (player.getDist(pianoBillBoard) <= 70) {
            addObject(pianoSign, 450, 140);

            if ((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) && !isPressed) {

                if (pianoOrder > 0 && pianoOrder < 4) {
                    removeObject(pianoText[pianoOrder - 1]);
                    removeObject(spaceContinue[pianoOrder - 1]);
                }
                if (pianoOrder == 3) {
                    removeObject(pianoBoard);
                    pianoOrder = 0;
                    Greenfoot.setWorld(pianoWorld);
                } else {

                    addObject(pianoBoard, 500, 550);
                    addObject(pianoText[pianoOrder], 502, 489);
                    addObject(spaceContinue[pianoOrder], 708, 637);

                    isPressed = true;
                    pianoOrder++;

                }

            }
            if (!Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter") && isPressed) {
                isPressed = false;
            }
        } else {
            removeObject(pianoSign);
        }
        
        if (player.getDist(puzzleBillBoard) <= 70) {
            addObject(puzzleSign, 318, 244);

            if ((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) && !isPressed) {

                if (puzzleOrder > 0 && puzzleOrder < 4) {
                    removeObject(puzzleText[puzzleOrder - 1]);
                    removeObject(spaceContinue[puzzleOrder - 1]);
                }
                if (puzzleOrder == 3) {
                    removeObject(puzzleBoard);
                    puzzleOrder = 0;
                    Greenfoot.setWorld(puzzleWorld);
                } else {

                    addObject(puzzleBoard, 500, 550);
                    addObject(puzzleText[puzzleOrder], 502, 489);
                    addObject(spaceContinue[puzzleOrder], 708, 637);

                    isPressed = true;
                    puzzleOrder++;

                }

            }
            if (!Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter") && isPressed) {
                isPressed = false;
            }
        } else {
            removeObject(puzzleSign);
        }
    }

    public void keyPressed() {
        if (Greenfoot.isKeyDown("space") && !isPressed) {

            isPressed = true;
        }
        if (!Greenfoot.isKeyDown("space") && isPressed) {

            isPressed = false;
        }

    }
    public void returnToIslandRight(){
        getCoin().gainCoin(19 + (int)(Math.random() * 18));
        Greenfoot.setWorld(this);
    }
    public void returnPreviousIsland() {
        Greenfoot.setWorld(previousIsland);
        previousIsland.spawn(950, 470);
        previousIsland.addObject(coin, 150, 60);
    }

    public void drawBorder() {
        InvisibleBorder I1 = new InvisibleBorder(800, 10);
        addObject(I1, 476, 565);
        InvisibleBorder I2 = new InvisibleBorder(10, 70);
        addObject(I2, 628, 545);
        InvisibleBorder I3 = new InvisibleBorder(90, 10);
        addObject(I3, 673, 513);
        InvisibleBorder I4 = new InvisibleBorder(10, 250);
        addObject(I4, 804, 357);
        InvisibleBorder I19 = new InvisibleBorder(10, 60);
        addObject(I19, 694, 485);
        InvisibleBorder I20 = new InvisibleBorder(200, 10);
        addObject(I20, 790, 460);
        InvisibleBorder I5 = new InvisibleBorder(150, 10);
        addObject(I5, 809, 243);
        InvisibleBorder I6 = new InvisibleBorder(10, 60);
        addObject(I6, 739, 210);
        InvisibleBorder I7 = new InvisibleBorder(150, 10);
        addObject(I7, 693, 187);
        InvisibleBorder I8 = new InvisibleBorder(10, 200);
        addObject(I8, 624, 82);
        InvisibleBorder I9 = new InvisibleBorder(300, 10);
        addObject(I9, 530, 133);
        InvisibleBorder I10 = new InvisibleBorder(10, 58);
        addObject(I10, 383, 162);
        InvisibleBorder I11 = new InvisibleBorder(30, 10);
        addObject(I11, 362, 186);
        InvisibleBorder I12 = new InvisibleBorder(10, 58);
        addObject(I12, 343, 216);
        InvisibleBorder I13 = new InvisibleBorder(400, 10);
        addObject(I13, 139, 240);
        InvisibleBorder I14 = new InvisibleBorder(10, 250);
        addObject(I14, 239, 174);
        InvisibleBorder I15 = new InvisibleBorder(60, 10);
        addObject(I15, 208, 295);
        InvisibleBorder I16 = new InvisibleBorder(10, 300);
        addObject(I16, 198, 277);
        InvisibleBorder I17 = new InvisibleBorder(300, 10);
        addObject(I17, 304, 511);
        InvisibleBorder I18 = new InvisibleBorder(10, 190);
        addObject(I18, 449, 610);
        InvisibleBorder I30 = new InvisibleBorder(300, 10);
        addObject(I30, 50, 422);
        InvisibleBorder I31 = new InvisibleBorder(300, 10);
        addObject(I31, 54, 511);

    }
}
