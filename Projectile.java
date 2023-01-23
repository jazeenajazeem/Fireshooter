import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Create Projectile sub class
public class Projectile extends Actor
{
    
    // Create Projectile Projectline Colour: RED
    public Projectile()
    {
        setImage(new GreenfootImage(10,2));
        getImage().setColor(Color.RED);
        getImage().fillRect(0,0,10,2);
    }
    public void act()
    {
        //move the Projectile , used Greenfoot.PlaySound:"pistol-shot.mp3" form free music store with no copyrights.
        move(10);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            //apply  the shooting sound 
            Greenfoot.playSound("pistol-shot.mp3");
        }
    }
    
}
