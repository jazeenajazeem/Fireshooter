import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    //This where health bar is created and displayed on the screem the health bar is rectangle and the health is set to red
    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        
    }
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        //sets the health bar location
        setLocation(myWorld.getPlayer().getX()-5, myWorld.getPlayer().getY()-50);
        loseHealth();
    }
    public void loseHealth()
    {
        //access the World with get player
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        //if - get player from my world (returns main player), hit by enemy is true will mean health--
        if(myWorld.getPlayer().hitByEnemy())
        {
            health--;
        }
        //displays once lost showing time in seconds how long you survived
        //if health is less than or = 0 then you lose
        if(health<=0)
        {
          getWorld().showText("You Lose! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds ",getWorld().getWidth()/2, getWorld().getHeight()/2);
          //Greenfoot.stop means to stop the game once you lost and the lost screen is displayed
          Greenfoot.stop();
        }
}
}
