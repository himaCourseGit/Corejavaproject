import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroShip extends ship
{
    private final static int shipReloadTime=30;
    private int delayTime=0;
    public static int score=0;
    public HeroShip(int speed)
    {
        super(speed);
    }
    public void act()
    {
        delayTime++;
        move(speed);
        wrapAround();
        fire();
    }
    public void move(int distance)
    {
        if(Greenfoot.isKeyDown("right"))
        {
            super.move(distance);
        }
        if(Greenfoot.isKeyDown("left"))
        {
           super.move(-distance); 
        }
        if(Greenfoot.isKeyDown("up"))
        {
           setLocation(getX(),getY()-distance); 
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+distance);
        }
    }
    public void wrapAround()
    {
        if(getX()==0)
        {
            setLocation(999,getY());
        }
        if(getX()==999)
        {
            setLocation(0,getY());
        }
        if(getY()==0)
        {
            setLocation(getX(),499);
        }
        if(getY()==0)
        {
            setLocation(getX(),0);
        }
    }
    public void fire()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if(delayTime>=shipReloadTime)
            {
                releaseBomb();
                delayTime=0;
            }
        }
    }
    public void releaseBomb()
    {
        World world=getWorld();
        Bomb bomb=new Bomb();
        world.addObject(bomb,getX(),getY());
    }
}

