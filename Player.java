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
    int time = 0;
    WeaponButton weaponButton;
    public Player()
    {
     setImage(new GreenfootImage(70,50));
     getImage().setColor(Color.RED);
     getImage().fillOval(0, 0, 50, 50);
     getImage().setColor(Color.BLACK);
     getImage().fillRect(50,20,70,10);
    }
    public Player(WeaponButton weaponButton)
    {
     this.weaponButton=weaponButton;
     setImage(new GreenfootImage(70,50));
     getImage().setColor(Color.RED);
     getImage().fillOval(0, 0, 50, 50);
     getImage().setColor(Color.BLACK);
     getImage().fillRect(50,20,70,10);
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        hitByZombie();
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
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1){
           Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation());
           projectile.move(25);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2){
           Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation() -5);
           projectile.move(20);
           Projectile projectile2 = new Projectile();
           getWorld().addObject(projectile2, getX(),getY());
           projectile2.setRotation(getRotation() + 5);
           projectile2.move(5);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade== 3){
           Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation() -5);
           projectile.move(20);
           Projectile projectile2 = new Projectile();
           getWorld().addObject(projectile2, getX(),getY());
           projectile2.setRotation(getRotation() +5);
           projectile2.move(5);
           Projectile projectile3 = new Projectile();
           getWorld().addObject(projectile3, getX(),getY());
           projectile3.setRotation(getRotation());
           projectile3.move(5);
        }
        
    }
    public boolean hitByZombie()
    {
    Actor zombie = getOneObjectAtOffset(0,0,Zombie.class);
    if(zombie!=null)
    
    {
       return true; 
    }
    else
    return false;
}
}
