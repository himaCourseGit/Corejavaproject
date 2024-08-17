import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip extends ship
{
    private String color="BLACK";
    public EnemyShip(int speed)
    {
        super(speed);
        reduceShipSize();
    }
    public EnemyShip(int speed,String color)
    {
        super(speed);
        this.color=color;
        setImage("BlueEnemy.png.png");
        reduceShipSize();
    }
    public void act()
    {
        if(color.equals("Black"))
        {
            bounceHorizontally();
        }
        if(color.equals("BLUE"))
        {
            bounceVertically();
        }
        checkCollision();
    }
    public void reduceShipSize()
    {
        GreenfootImage enemyShipImage=getImage();
        int newWidth=enemyShipImage.getWidth()/10;
        int newHeight=enemyShipImage.getHeight()/10;
        enemyShipImage.scale(newWidth,newHeight);
    }
    public void bounceHorizontally()
    {
       move(speed);
       if(getX()<=500)
       {
          speed=4; 
       }
       if(getX()==999)
       {
           speed=-4;
       }
    }
    public void bounceVertically()
    {
        setLocation(getX(),getY()+speed);
        {
        if(getY()==499)
            {
                speed=-4;
            }
        if(getY()==0)
        {
            speed=+4;
        }
    }
    }
     public void checkCollision()
    {
            Bomb bomb=(Bomb)getOneIntersectingObject(Bomb.class);
            if(bomb!=null)
            {
                World world=getWorld();
                world.removeObject(this);
                //score
                bomb.hitShipCount++;
                HeroShip.score++;
            }
    }
}
