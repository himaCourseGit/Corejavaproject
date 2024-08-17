import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
  public int hitShipCount=0;
  public Bomb()
  {
     reduceActorSize(); 
  }
  public void act()
  {
    move(8);
    removeBomb();
  }
  public void reduceActorSize()
  {
      GreenfootImage imgbomb=getImage();
      int nW=imgbomb.getWidth()/2;
      int nH=imgbomb.getHeight()/2;
      imgbomb.scale(nW,nH);
  }
  public  void removeBomb()
  {
      if(hitShipCount==1||isAtEdge())
      {
          World world=getWorld();
          world.removeObject(this);
      }
  } 
}
