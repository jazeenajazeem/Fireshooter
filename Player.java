import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    public Player()
    {
     setImage(new GreenfootImage(70,50));
     getImage().setColor(Color.RED);
     getImage().fillOval(0, 0, 50, 50);
     getImage().setColor(Color.BLACK);
     getImage().fillRect(50,20,70,10);
    }
    public void act()
    {
        turnAround();
        moveAround();
        fireProjectile();
    }
    public void turnAround()
    {
       if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
     if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX()-speed,getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY()+speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX()+speed,getY());   
    }
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null)){
           Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation());
    }
    }
}
