import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperPower here.
 * add SUPER POWER_LIMIT method
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPower extends Actor
{
    /**
     * Act - do whatever the SuperPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // SUPER POWER LIMIT is  constant and set to 100
    //superCount starts from 0
    final int SUPER_POWER_LIMIT =100;
    int superCount;
    int count;
    public SuperPower()
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        //set the image  and color of SUPER_POWER_LIMIT
        getImage().drawRect(0,0,SUPER_POWER_LIMIT +1,11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1,superCount,10);
        
    }
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1,superCount,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        //set the location
        setLocation(myWorld.getPlayer().getX()+10 , myWorld.getPlayer().getY()-80);
        useSuper();
    }
    public  void useSuper()
    {
        count++;
        if(count % 5==0)
        {
           superCount++;
        }
       
    }
}
