import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Store3 here.
 * the store before final level
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Store3 extends World
{
    BulbLogo2 b = new BulbLogo2();
    PikachuLogo p = new PikachuLogo();
    CharmanderLogo c = new CharmanderLogo();
    TorchicLogo2 t = new TorchicLogo2();
    UpGrade u1 = new UpGrade();
    UpGrade u2 = new UpGrade();
    UpGrade u3 = new UpGrade();
    UpGrade u4 = new UpGrade();
    ToMap t1 = new ToMap();
    private Label coin = new Label(Battle.coins, 30);

    private Label tofinalLevel = new Label("click here go to final level",30);
    /**
     * Constructor for objects of class Store3.
     * 
     */
    public Store3()
    {    
        super(900, 506, 1); 
        
        setBackground("Store.png");
        
        addObject(p,135,125);

        addObject(c,440,125);

        addObject(b,135,360);
        
        addObject(t,440,360);

        if(Pikachu.upGrade == false)
        {
            addObject(u1,135,230);
        }
        
        if(Charmander.upGrade == false)
        {
            addObject(u2,440,230);
        }
        
        if(Bulbasaur.upGrade == false)
        {
            addObject(u3,135,470);
        }
        
        if(Torchic.upGrade == false)
        {
            addObject(u4,440,470);
        }
        
        
        addObject(t1, 750, 400);
        
        addObject(coin, 725, 200);

        Pikachu.pHP = 65;
        Charmander.cHP = 65;
        Bulbasaur.bHP = 50;
        Torchic.tHP = 45;
        GeneralInformation.character[0] = "Pikachu";
        
        GeneralInformation.character[1] = "Charmander";
    }

    public void act()
    {
        upGrade();
        coin.setValue(Battle.coins);
        
        if(Greenfoot.mouseClicked(p))
        {
            GeneralInformation.character[0] = "Pikachu";
        }
        if(Greenfoot.mouseClicked(b))
        {
            GeneralInformation.character[0] = "Bulbasaur";
            Bulbasaur.enemy = false;
        }
        if(Greenfoot.mouseClicked(t))
        {
            GeneralInformation.character[1] = "Torchic";
            Torchic.enemy = false;
        }
        if(Greenfoot.mouseClicked(c))
        {
            GeneralInformation.character[1] = "Charmander";
        }
        //slect more than two will overwrite the second one

        
        if(t1.click == true)
        {
            Load3 b = new Load3();
            Greenfoot.setWorld(b);
        }
    }
    
    public void upGrade()
    {
        if(Greenfoot.mouseClicked(u1))
        {
            if(Battle.coins > 0)
            {
                Pikachu.pHP = 75;
                Pikachu.damage = 5;
                Pikachu.upGrade = true;
                Battle.coins -= 10;
            } 
        }
        if(Greenfoot.mouseClicked(u2))
        {
            if(Battle.coins > 0)
            {
                Charmander.cHP = 75;
                Charmander.damage = 5;
                Charmander.upGrade = true;
                Battle.coins -= 10;
            }
        }
        if(Greenfoot.mouseClicked(u3))
        {
            if(Battle.coins > 0)
            {
                Bulbasaur.bHP = 75;
                Bulbasaur.damage = 5;
                Bulbasaur.upGrade = true;
                Battle.coins -= 10;
            }
        }
        if(Greenfoot.mouseClicked(u4))
        {
            if(Battle.coins > 0)
            {
                Torchic.tHP = 55;
                Torchic.damage = 5;
                Torchic.upGrade = true;
                Battle.coins -= 10;
            } 
        }
    }
    
}
