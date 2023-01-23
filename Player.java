import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Create Player sub class
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int time = 0;
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer;
    // Create the Player: Player Colour: RED and BLACK using GreenfootImage and set the image size
    public Player()
    {
     setImage(new GreenfootImage(70,50));
     //Create plarer using Oval shape: Colour: RED,
     getImage().setColor(Color.RED);
     getImage().fillOval(0, 0, 50, 50);
     //Front part of the Player-Colour: BLACK
     getImage().setColor(Color.BLACK);
     getImage().fillRect(50,20,70,10);
    }
    public Player(WeaponButton weaponButton, SuperPower superPower)
    {
     this.superPower = superPower;   
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
        superPowerUsed();
        hitByEnemy();
    }
    public void turnAround()
    {
       if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        //Used w,a,s,d for move the player up, Down, Left and Right
     if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX()-speed,getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY()+speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX()+speed,getY());   
    }
    // null means nothing. But in this case it means if mouse Pressed no place in particular.."anywhere on the screen"
    //add new projectile
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
           projectile.setRotation(getRotation() -10);
           projectile.move(20);
           Projectile projectile2 = new Projectile();
           getWorld().addObject(projectile2, getX(),getY());
           projectile2.setRotation(getRotation() + 10);
           projectile2.move(20);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade== 3){
           Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation() -10);
           projectile.move(20);
           Projectile projectile2 = new Projectile();
           getWorld().addObject(projectile2, getX(),getY());
           projectile2.setRotation(getRotation() +10);
           projectile2.move(20);
           Projectile projectile3 = new Projectile();
           getWorld().addObject(projectile3, getX(),getY());
           projectile3.setRotation(getRotation());
           projectile3.move(20);
        }
        
    }
    public void superPowerUsed()
    {
        if(superPower.superCount >99 && superTimer < 30)
        {
            // Create Projectile for super power upgrade
            Projectile projectile = new Projectile();
           getWorld().addObject(projectile, getX(),getY());
           projectile.setRotation(getRotation() -60);
           projectile.move(20);
           //Create Projectile2 for super power upgrade
           Projectile projectile2 = new Projectile();
           getWorld().addObject(projectile2, getX(),getY());
           projectile2.setRotation(getRotation() +60);
           projectile2.move(20);
           //Create Projectile3 for super power upgrade
           Projectile projectile3 = new Projectile();
           getWorld().addObject(projectile3, getX(),getY());
           projectile3.setRotation(getRotation());
           projectile3.move(20);
           //Create Projectlile1 for super power upgrade
           Projectile projectile1 = new Projectile();
           getWorld().addObject(projectile1, getX(),getY());
           projectile1.setRotation(getRotation() -180);
           projectile1.move(20);
           //Create Projectlile21 for super power upgrade
           Projectile projectile21 = new Projectile();
           getWorld().addObject(projectile21, getX(),getY());
           projectile21.setRotation(getRotation() +120);
           projectile21.move(20);
           //Create Projectlile31 for super power upgrade
           Projectile projectile31 = new Projectile();
           getWorld().addObject(projectile31, getX(),getY());
           projectile31.setRotation(getRotation() - 120);
           projectile31.move(20);
           superTimer++;
        }
        if(superTimer>29)
        {
            superPower.superCount = 0;
            superTimer= 0;
    }
}
    public boolean hitByEnemy()
    {
    //when the enemy class is directly on top of the player the offset is 0,0
    Actor enemy = getOneObjectAtOffset(0,0,Enemy.class);
    if(enemy!=null)
    
    {
       return true; 
    }
    else
    return false;
}
}
