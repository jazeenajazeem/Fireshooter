import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //added Backgroud music as "run-vine-sound-effect.mp3" from non copyright music audio file
    GreenfootSound sounds = new GreenfootSound("run-vine-sound-effect.mp3");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;

    //Spawn speed will be faster if you lower value of spawnSpeed, If increase the value slower.
    //Spawn speed is declared to 30 to increase the speed of the spawn.
    int spawnSpeed = 30;
    int randomSpawn;
    //
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton=new WeaponButton(counter);
    SuperPower superPower=new SuperPower();
    public MyWorld()
    {    
        //Created a new world with 400X600 with cell size of 1X1 pixels
        super(1000, 800, 1);
        mainPlayer=new Player(weaponButton,superPower);
        addObject(mainPlayer, getWidth()/2,getHeight()/2);
        addObject(counter, 130, 100);
        addObject(healthbar, mainPlayer.getX()-5, mainPlayer.getY()-60);
        addObject(weaponButton,900,100);
        addObject(superPower,mainPlayer.getX()+10,mainPlayer.getY()-80);
    }
    public Player getPlayer()
    {
        return mainPlayer;
    }
    
    public void act()
    {
        // Add sound
        sounds.play();
        count++;
        if(count % 600 == 0)
        {
            spawnSpeed--;
        }
        while(Greenfoot.isKeyDown("p")){
        Greenfoot.delay(1);
        }
        spawnEnemies(); 
    }
    
    public void spawnEnemies()
    {
        if(count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0 : addObject(new Enemy(mainPlayer,counter),0,0);break;
                case 1 : addObject (new Enemy(mainPlayer,counter),getWidth()/2,0);break;
                case 2 : addObject (new Enemy(mainPlayer,counter),getWidth(),0);break;
                case 3 : addObject (new Enemy(mainPlayer,counter),0,getHeight()/2);break;
                case 4 : addObject (new Enemy(mainPlayer,counter),getWidth(),getHeight()/2);break;
                case 5 : addObject (new Enemy(mainPlayer,counter),0,getHeight());break;
                case 6 : addObject (new Enemy(mainPlayer,counter),getWidth()/2,getHeight());break;
                case 7 : addObject (new Enemy(mainPlayer,counter),getWidth(),getHeight());break;
            
            } 
    }
   
}

}


