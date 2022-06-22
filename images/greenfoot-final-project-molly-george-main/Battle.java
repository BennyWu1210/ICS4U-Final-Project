import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world for the fighting, player will encounter enemy pokemons in this world and will beat them to win.
 * 
 * @author George && Molly
 * @version June 19
 */
public class Battle extends World
{
    //This will create all the 8 pokemons needed for this game
    public Pikachu p = new Pikachu();
    public Charmander c = new Charmander();
    public Bulbasaur b = new Bulbasaur();
    public Eevee e = new Eevee();
    public Rowlet r = new Rowlet();
    public Fennekin f = new Fennekin();
    public Torchic t = new Torchic();
    public Ninetales n = new Ninetales();
    
    //This will decide which world the player will be throw in.
    public static int count = 1;
    
    
    //This is use to check the HP of current character and check if they are live or not.
    public int hp1;
    public int hp2;
    public int hp3;
    public int hp4;
    
    //This is the array sotre character's x and y cordinate.
    private int[] cordinate = new int[8];
    
    //This will crate an array of timer, those timer will be used to help the enmy to attack in approiate time and help with animation.
    private SimpleTimer[] timerArray = new SimpleTimer[13];
    
    //This is the array for the all the label shows the HP of a character.
    private Label[] labelArray = new Label[8];
    
    //Use to help the Fennekin to attack
    public boolean isThereFire = false; // To detect if there is any fire on the map
    public FennekinAttack fa = new FennekinAttack();
    public FennekinAttack fa1 = new FennekinAttack();
    public FennekinAttack fa2 = new FennekinAttack();
    
    public static int coins = 0;
    
    //initlaze the general information
    public GeneralInformation g = new GeneralInformation();
    
    //Use to check the direction for the bullet
    public static boolean right;
    public static boolean left;
    public static boolean up;
    public static boolean down;
   
    
    public Battle()
    {    
        //Create the size of this map
        super(900, 506, 1, false); 
        
        //Initlaze the timer array
        for( int i = 0; i < 13; i++)
        {
            timerArray[i] =  new SimpleTimer();
        }
        
        //Initlaze the label array
        labelArray[0] = new Label("PikachuHP: " + Pikachu.pHP, 20);
        labelArray[1] = new Label("Charmander: " + Charmander.cHP, 20);
        labelArray[2] = new Label("Eevee: " + Eevee.eHP, 20);
        labelArray[3] = new Label("RowletHP: " + r.rHP, 20);
        labelArray[4] = new Label("BulbasaurHP: " + b.bHP, 20);
        labelArray[5] = new Label("FennekinHP: " + f.fHP, 20);
        labelArray[6] = new Label("TorchicHP: " + t.tHP, 20);
        labelArray[7] = new Label("NinetalesHP: " + n.nHP, 20);
        
        //Initlaze the cordinate array
        for(int i = 0; i < 8; i++)
        {
            cordinate[i] = 0;
        }
        
        //Initlaze the world of the first level
        if(count == 1)
        {
            Pikachu.live = true;
            Charmander.live = true;
            c.cHP = 65;
            p.pHP = 65;
            
            setBackground(new GreenfootImage("1.png"));

            //Below will place all the needed object for the first level
            addObject(p, 250, 400);
        
            addObject(c, 350, 400);
        
            addObject(e, 250, 150);
            
            addObject(labelArray[0], 800, 50);
            
            addObject(labelArray[1], 800, 80);
            
            addObject(labelArray[2], 100, 50);
            
            addObject(labelArray[3], 100, 80);
            
            addObject(labelArray[4], 100, 110);
            
                             
        
        }
        //Initlaze the world for the second level 
        else if(count == 2)
        {
            setBackground(new GreenfootImage("7.png"));
            
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                addObject(p, 320, 400);
                hp1 = p.pHP;
                addObject(labelArray[0], 800, 100);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                addObject(b, 250, 400);
                hp1 = b.bHP;
                addObject(labelArray[4], 800, 100);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                addObject(c, 350, 400);
                addObject(labelArray[1], 800, 130);
                hp2 = c.cHP;
            }
            
            addObject(f, 250, 150); 
            
            addObject(labelArray[5], 100, 80);
            
            addObject(labelArray[6] , 100, 110);
            
            
        }
        //Initlaze the world for the final level
        else if(count == 3)
        {
            Pikachu.pHP = 65;
            Charmander.cHP = 65;
            Bulbasaur.bHP = 50;
            Torchic.tHP = 45;
            
            addObject(labelArray[7], 100, 80);
            
            addObject(n, 450, 125);
            
            setBackground(new GreenfootImage("9.png"));
        
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                addObject(p, 250, 350);
                addObject(labelArray[0], 800, 100);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                addObject(c, 250, 350);
                addObject(labelArray[1], 800, 130);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                addObject(b, 250, 350);
                addObject(labelArray[4], 800, 100);
            }
            if(GeneralInformation.character[1].equals("Torchic"))
            {
                addObject(t, 250, 350);
                labelArray[6] = new Label("TorchicHP: " + Torchic.tHP, 20);
                addObject(labelArray[6] , 800, 130);
            }
            
            
        }
    }
    
    public void act()
    {
        //This will get the direction for the character to shoot
        direction();
        
        //This will initlaze the character's property
        initlazeCh();
        
        //Get in the first level
        firstBattle();
        
        //Get in the second level
        secondBattle();
        
        //Get in the third level
        thirdBattle();
        
        
        
    }  
    
    //This is the method for the first level, it will add new enemy and change the background as the player beat the current enemy.
    public void firstBattle()
    {
        if(count == 1)
        {
            
            labelArray[0].setValue("PikachuHP: " + Pikachu.pHP);
            labelArray[1].setValue("CharmanderHP: " + Charmander.cHP);
            labelArray[2].setValue("EeveeHP: " + Eevee.eHP);
            labelArray[3].setValue("RowletHP: " + r.rHP);
            labelArray[4].setValue("BulbasaurHP: " + b.bHP);
            
            if(e.eHP > 0)
            {
                eeveeAtt(cordinate[4] - 150, cordinate[5] - 150, new GreenfootImage("EeveeAtt.png"), timerArray[4]);   
                eeveeAtt(cordinate[6] - 150, cordinate[7] - 150, new GreenfootImage("EeveeAtt.png"), timerArray[5]); 
                attack3(e.getX(), e.getY(), new GreenfootImage("plantAtt.png"));
            }
            
            //get to the second battle in first level
            if(e.eHP <= 0)
            {
                setBackground(new GreenfootImage("2.png"));
                removeObject(e);
                addObject(r, 750, 100);
                removeObject(labelArray[2]);
                
                if(r.rHP > 0)
                {
                    attack3(r.getX(), r.getY(), new GreenfootImage("plantAtt.png"));
                    rowletAtt(cordinate[4] - 100, cordinate[5] - 100, new GreenfootImage("RowletAtt.png"), timerArray[2]);
                    rowletAtt(cordinate[6] - 100, cordinate[7] - 100, new GreenfootImage("RowletAtt.png"), timerArray[3]);
                }
            }
            
            //get to the third battle in first level
            if(r.rHP <= 0)
            {
                setBackground(new GreenfootImage("3.png"));
                removeObject(r);
                removeObject(labelArray[3]);
                addObject(b, 150, 100);
                
                if(b.bHP > 0)
                {
                    attack3(b.getX(), b.getY(), new GreenfootImage("plantAtt.png"));
                    bulbasaurAttack(b.getX(), b.getY(), new GreenfootImage("BulbasaurAtt.png"));
                }
            }
            
            //Done first level here, ready to go to the second level
            if(b.bHP <= 0)
            {
                removeObject(b);
                removeObject(labelArray[4]);
                ToMap2 t2 = new ToMap2();
                addObject(t2, 450, 250);
                if(cordinate[4] > 900 || cordinate[6] > 900)
                {
                    Map2 m2 = new Map2();
                    Greenfoot.setWorld(m2);
                    count++;
                    coins += 10;
                }
            }
            
            //Check if the character's HP is greater than 0, if not, restart the game
            if(p.pHP <= 0 && c.cHP <= 0)
            {
                Load1 s1 = new Load1();
                Greenfoot.setWorld(s1);
                Pikachu.live = true;
                Charmander.live = true;
                
            }
        }
    }
    
    //This is the method for the second level, it will also add new enemy and change the background as the player beat the current enemy.
    public void secondBattle()
    {
        if(count == 2)
        {
            //This is to seat the character in team according to player's choice, because now there are 3 pokemons to hoose.
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                hp1 = p.pHP;
                labelArray[0].setValue("PikachuHP: " + Pikachu.pHP);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                hp1 = b.bHP;
                labelArray[4].setValue("BulbasaurHP: " + b.bHP);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                hp2 = c.cHP;
                labelArray[1].setValue("CharmanderHP: " + Charmander.cHP);
            }
            
            //This will initlaze the HP for the enemy more detail
            labelArray[5].setValue("FennekinHP: " + f.fHP);
            labelArray[6].setValue("TorchicHP: " + t.tHP);
            
            if(f.fHP > 0)
            {
                attack3(250, 150,  new GreenfootImage("fireAtt.png"));
                fennekinAtt();
            }
            
            //Go to the second battle in the second level
            if(f.fHP <= 0)
            {
                setBackground(new GreenfootImage("8.png"));
                removeObject(f);
                removeObject(labelArray[5]);
                addObject(t, 750, 100);
                if(t.tHP > 0)
                {
                    attack3(t.getX(), t.getY(),  new GreenfootImage("fireAtt.png"));
                }
            }
            
            //This is to let the player go to the third or the last level
            if(t.tHP <= 0)
            {
                removeObject(labelArray[6] );
                removeObject(t);
                ToMap3 t3 = new ToMap3();
                addObject(t3, 450, 250);
                Map3 s3 = new Map3();
                if(p.pikachuX > 900 || cordinate[6] > 900 || cordinate[0] > 900)
                {
                    Greenfoot.setWorld(s3);
                    count++;
                    coins += 20;
                }
            }
            
            //Check if the character's HP is all 0, if it is, restart
            if(hp1 <= 0 && hp2 <= 0)
            {
                Load2 s2 = new Load2();
                Greenfoot.setWorld(s2);
                Pikachu.live = true;
                Charmander.live = true;
                Bulbasaur.live = true;
                
            }
    
            
        }
    }
    
    
    //This is the method for the third level
    public void thirdBattle()
    {
        if(count == 3)
        {
            
            //Initlaze the HP for ninetales more detail
            labelArray[7].setValue("Ninetales: " + n.nHP);
            if(n.nHP > 0)
            {
                attack3(450, 125,  new GreenfootImage("fireAtt.png"));
                ninetalesAttack(450, 125);
            }
            
            //Again, the player will have 4 pokemons to choose, so this will make sure they select the pokemons they want into their team
            if(GeneralInformation.character[0].equals("Pikachu"))
            {
                hp1 = p.pHP;
                labelArray[0].setValue("PikachuHP: " + Pikachu.pHP);
            }
            if(GeneralInformation.character[0].equals("Bulbasaur"))
            {
                hp1 = b.bHP;
                labelArray[4].setValue("BulbasaurHP: " + b.bHP);
            }
            if(GeneralInformation.character[1].equals("Charmander"))
            {
                hp2 = c.cHP;
                labelArray[1].setValue("CharmanderHP: " + c.cHP);
            }
            if(GeneralInformation.character[1].equals("Torchic"))
            {
                hp2 = t.tHP;
                labelArray[6].setValue("TorchicHP: " + t.tHP);
            }
            
            
            if(n.nHP <= 0)
            {
                removeObject(n);
            }
            
            //Check if the character's HP is 0, if it is, restart the game
            if(hp1 <= 0 && hp2 <= 0)
            {
                Load2 s2 = new Load2();
                Greenfoot.setWorld(s2);
                Pikachu.live = true;
                Charmander.live = true;
                Bulbasaur.live = true;
                Torchic.live = true;
                
            }
            
            //This will let the player to go to the final, or the ending.
            if(n.nHP <= 0)
            {
                removeObject(labelArray[7]);
                removeObject(n);
                
                ToMapFinal tf = new ToMapFinal();
                addObject(tf, 450, 250);
                if(p.pikachuX > 900 || cordinate[6] > 900 || cordinate[0] > 900 || cordinate[2] > 900)
                {
                    ConclusionScreen cs = new ConclusionScreen();
                    Greenfoot.setWorld(cs);
                    
                }
            }
        }
    }
    
    //This will initlaze all the necessary information for the friendly pokemon the player can use, like give them the ability to attack, chnage them from enemy to friendly
    public void initlazeCh()
    {
        if(GeneralInformation.character[0].equals("Pikachu"))
        {
            cordinate[4] = p.getX();
            cordinate[5] = p.getY();
            attack1(cordinate[4], cordinate[5], Pikachu.damage, new GreenfootImage("pikachuatt.png"));
        }
        if(GeneralInformation.character[1].equals("Charmander"))
        {
            cordinate[6] = c.getX();
            cordinate[7] = c.getY();
            attack2(cordinate[6], cordinate[7], Charmander.damage, new GreenfootImage("fireAtt.png"));
        }
        if(GeneralInformation.character[0].equals("Bulbasaur"))
        {
            cordinate[0] = b.getX();
            cordinate[1] = b.getY();
            if(Bulbasaur.enemy != true)
            {
                attack1(cordinate[0], cordinate[1],Bulbasaur.damage, new GreenfootImage("plantAtt.png"));
            }
        }
        if(GeneralInformation.character[1].equals("Torchic"))
        {
            cordinate[2] = t.getX();
            cordinate[3] = t.getY();
            if(Torchic.enemy != true)
            {
                attack2(cordinate[2], cordinate[3], Torchic.damage, new GreenfootImage("fireAtt.png"));
            }
        }
    }
    
    
    //This will check the direction of the current character and will help player to aim and fire the bullet
    public void direction()
    {
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            left = true;
            right = false;
            up = false;
            down = false;
        }
        
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            left = false;
            right = true;
            up = false;
            down = false;
        }
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
        {
            up = true;
            left = false;
            right = false;
            down = false;
        }
        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
        {
            up = false;
            left = false;
            right = false;
            down = true;
        }
        
        if((Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")) || (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")))
        {
            up = true;
            left = true;
            right = false;
            down = false;
        }
        
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s") || (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down")))
        {
            up = false;
            left = true;
            right = false;
            down = true;
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down"))
        {
            up = false;
            left = false;
            right = true;
            down = true;
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up"))
        {
            up = true;
            left = false;
            right = true;
            down = false;;
        }
        
    }
    
    //This is the attack method for Pikachu and Bulbasaur
    public void  attack1(int x, int y,  int damage, GreenfootImage image)
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if(timerArray[0].millisElapsed() > 500)
            {
                NormalAttack a = new NormalAttack(image, damage);
                addObject(a,x,y);
                timerArray[0].mark();
                
            }
        }
    }
    
    //This is the attack method for Charmander and Torchic
    public void attack2(int x, int y,  int damage, GreenfootImage image)
    {
        if(Greenfoot.isKeyDown("r"))
        {
            if(timerArray[0].millisElapsed() > 500)
            {
                NormalAttack a = new NormalAttack(image, damage);
                addObject(a,x,y);
                timerArray[0].mark();
                
            }
        }
    }
    
    //Thsi is the attack method for the enemy
    public void attack3(int x, int y, GreenfootImage image)
    {
        if(timerArray[1].millisElapsed() > 3000)
        {
            for(int i = 1; i < 9; i++)
            {
                EnemyAttack e = new EnemyAttack(image);
                addObject(e,x,y);
                e.setRotation(i * 45);
                timerArray[1].mark();
            }
            
        }
    }
    
    //This is the special attack method for Eevee
    public void eeveeAtt(int x, int y, GreenfootImage image, SimpleTimer timer)
    {
        EeveeAttack ea = new EeveeAttack(image);
        if(timer.millisElapsed() > 6000)
        {
            addObject(ea,x,y);
            timer.mark();
        }
    }

    //This is the special attack method for rowlet
    public void rowletAtt(int x, int y, GreenfootImage image, SimpleTimer timer)
    {
        RowletAttack ra = new RowletAttack(image);
        if(timer.millisElapsed() > 8000)
        {
            addObject(ra, x, y);
            timer.mark();
        }
    }
    
    //This is the special attack method for bulbasaur
    public void bulbasaurAttack(int x, int y, GreenfootImage image)
    {
        if(timerArray[6].millisElapsed() > 5000)
        {
            for(int i = 1; i < 9; i++)
            {
                BulbasaurAttack ba = new BulbasaurAttack(image);
                addObject(ba,x,y);
                ba.setRotation(i * 45);
                timerArray[6].mark();
            }
            
        }
    }
    
    //This is the special attack method for Fennekin
    public void fennekinAtt()
    {
        
        int i = (int)(Math.random()*2)+1;
        int x = (int)(Math.random()*2)+1;
        int y = (int)(Math.random()*2)+1;
        
        
        if(timerArray[7].millisElapsed() > 5000 && !isThereFire)
        {
            addObject(fa,  200, i * 200);
            addObject(fa1, 400, x * 200);
            addObject(fa2, 600, y * 200);
            isThereFire = true; //
            timerArray[7].mark();
        }
        
        else if(timerArray[7].millisElapsed() > 2000 && isThereFire)
        {
            removeObject(fa);
            removeObject(fa1);
            removeObject(fa2);
            isThereFire = false; //
            timerArray[7].mark();
        }
        
        
    }
    
    
    //This is the special attack method for ninetales
    public void ninetalesAttack(int x, int y)
    {
        if(timerArray[11].millisElapsed() > 10000)
        {
            for(int i = 1; i < 7; i++)
            {
                NinetalesAttack ba = new NinetalesAttack();
                addObject(ba,x,y);
                ba.setRotation(i * 60);
                timerArray[11].mark();
            }
            
        }
    }
}