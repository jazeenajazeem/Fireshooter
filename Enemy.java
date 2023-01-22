import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    //lower the animate speed for faster animation
    int animateSpeed = 5;
    int count;
    int health = 2;
    Player player;
    //stored the counter so enemies can see throughout the class instead of the constructor
    Counter counter;
    //in the Enemy class, there is the player and counter to access and read information
    public Enemy(Player mainPlayer,Counter counter)
    {
     this.counter = counter;
     player = mainPlayer;
     setImage("survivor-idle_handgun_16.png");
     getImage().scale(80,80);
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    //animate our Enemy: used animated enemy with 16 images.
    //if count divisible to animate speed is remainder 0 and if image is less than 16, then set to image
    public void animate()
    {
        if(count % animateSpeed ==0)
        {
            if(animateImage > 16){
                animateImage = 0;
            }
            setImage("survivor-move_handgun_"+animateImage + ".png");
            animateImage++;
            getImage().scale(80,80);
        }
    }
    public void moveAround()
    {
        //this will turn towards the player
        move(1);
        turnTowards(player.getX(),player.getY());        
    }
    // projectiles hit the enemies, enemies get hit, if you get hit by projctile, removes enemies object
    //lose health so it can get stronger and maker the game more intense
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        // here I created a reference to the projectile and created and referenced the actor class to using 'getoneintersectingobject'.
        //checking to see if any object is intersecting th enemy class, if its not equal to nothing then health-- and remove object, and the referenced project tile we want to remove.
        if(projectile != null)
        {
            //when enemies get hit by projectile it lose health
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0)
        {
            //count.score- this accesses the counter class and add to the score variable in the counter class
            //score will go up by 1
            counter.score++;
            //money(cash) will go up by 5
            counter.money+=5;
            getWorld().removeObject(this);
        }
    }
        
    
}
