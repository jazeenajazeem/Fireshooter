import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    //lower the animate speed for faster animation
    int animateSpeed = 5;
    int count;
    public Zombie()
    {
     setImage("survivor-idle_handgun_16.png");
     getImage().scale(80,80);
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
    }
    //animate our zombie
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
        move(1);
        turnTowards(getWorld().getWidth()/2,getWorld().getHeight()/2);
        
    }
}
