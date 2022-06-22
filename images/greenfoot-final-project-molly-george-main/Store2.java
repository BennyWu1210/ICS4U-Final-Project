import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Store2 here.
 * the store before second level
 * 
 * @author George Lu && Molly Wu 
 * @version June 2022
 */
public class Store2 extends World
{
    BulbLogo2 b = new BulbLogo2();
    PikachuLogo p = new PikachuLogo();
    CharmanderLogo c = new CharmanderLogo();
    
    UpGrade u1 = new UpGrade();
    UpGrade u2 = new UpGrade();
    UpGrade u3 = new UpGrade();
    ToMap t = new ToMap();
    private Label coin = new Label(Battle.coins, 30);
    
    /**
     * Constructor for objects of class Store2.
     * 
     */
    public Store2()
    {    
        super(900, 506, 1); 
        
        setBackground("Store.png");
        addObject(p,135,125);

        addObject(c,440,125);

        addObject(b,135,360);

        addObject(u1,135,230);

        addObject(u2,440,230);

        addObject(u3,135,470);
        
        addObject(t, 750, 400);
        
        addObject(coin, 725, 200);
        
        GeneralInformation.character[0] = "Pikachu";
        
        GeneralInformation.character[1] = "Charmander";
        
        Pikachu.pHP = 65;
        Charmander.cHP = 65;
        Bulbasaur.bHP = 50;
        Pikachu.live = true;
        Charmander.live = true;
        Bulbasaur.live = true;
    }
    
    public void act()
    {
        
        if(Greenfoot.mouseClicked(p))
        {
            GeneralInformation.character[0] = "Pikachu";
        }
        if(Greenfoot.mouseClicked(b))
        {
            GeneralInformation.character[0] = "Bulbasaur";
            Bulbasaur.enemy = false;
        }
        if(Greenfoot.mouseClicked(c))
        {
            GeneralInformation.character[1] = "Charmander";
        }
        
        
        
        upGrade();  
        
        coin.setValue(Battle.coins);
        //slect more than two will overwrite the second one

        if(t.click == true)
        {
            Load2 b = new Load2();
            Greenfoot.setWorld(b);
        }
    }
    
    public void upGrade()
    {
        if(Greenfoot.mouseClicked(u1))
        {
            if(Battle.coins > 0)
            {
                Pikachu.pHP += 10;
                Pikachu.damage = 5;
                Pikachu.upGrade = true;
                Battle.coins -= 10;
            }
            
        }
        if(Greenfoot.mouseClicked(u2))
        {
            if(Battle.coins > 0)
            {
                Charmander.cHP += 10;
                Charmander.damage = 5;
                Charmander.upGrade = true;
                Battle.coins -= 10;
            }
        }
        if(Greenfoot.mouseClicked(u3))
        {
            if(Battle.coins > 0)
            {
                Bulbasaur.bHP += 10;
                Bulbasaur.damage = 5;
                Bulbasaur.upGrade = true;
                Battle.coins -= 10;
            }
        }
    }
}
