import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ocean here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ocean extends World
{
    /**
     * Constructor for objects of class ocean.
     * 
     */
    public ocean()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,500,1);
        addHeroShip();
        for(int i=1;i<=10;i++)
        {
            if(i<=5)
            {
                addEnemyShip("BLACK");
            }
            else
            {
                addEnemyShip("BLUE");  
            }
        }
        prepare();
    }

    public void addHeroShip()
    {
        int shipX=Greenfoot.getRandomNumber(400);
        int shipY=Greenfoot.getRandomNumber(470);
        addObject(new HeroShip(5),shipX,shipY);
    }

    public void addEnemyShip(String color)
    {
        while(true)
        {
            int shipX=Greenfoot.getRandomNumber(999);
            int shipY=Greenfoot.getRandomNumber(499);
            int speed=Greenfoot.getRandomNumber(5);
            if(shipX>=500 && shipY<=999)
            {
                if(speed!=0 && color.equals("BLACK"))
                {
                    addObject(new EnemyShip(speed),shipX,shipY);
                    break;
                }
                else if(speed!=0 && color.equals("BLUE"))
                {
                    addObject(new EnemyShip(speed,"BLUE"),shipX,shipY);
                    break;
                }
            }
        }
    }

    public void act()
    {
        displayScore();
    }

    public void displayScore()
    {
        showText("Score:"+HeroShip.score,81,42);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}

