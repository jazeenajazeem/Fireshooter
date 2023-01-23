import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//MyWorld class updated
public class MyWorld extends World
{
    //added Backgroud music as "run-vine-sound-effect.mp3" from non copyright music audio file
    GreenfootSound sounds = new GreenfootSound("run-vine-sound-effect.mp3");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //intialised count to zero
    int count = 0;
    //Spawnspeed will be faster if you lower value of spawnSpeed, If increase the value slower.
    //Spawnspeed at 30 to increase the spawn speed.
    int spawnSpeed = 30;
    int randomSpawn;
    //onstructor created 
    public Player mainPlayer = new Player();
    //created counter so counter can be accessed outside of world
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton=new WeaponButton(counter);
    SuperPower superPower=new SuperPower();
    public MyWorld()
    {    
    
        super(1000, 800, 1);
        //main player is created and becomes it's own instance of new player
        mainPlayer=new Player(weaponButton,superPower);
        //we have created our player
        addObject(mainPlayer, getWidth()/2,getHeight()/2);
        //counter is placed on side so users can see enemies coming through the counter
        addObject(counter, 130, 100);
        addObject(healthbar, mainPlayer.getX()-5, mainPlayer.getY()-60);
        addObject(weaponButton,900,100);
        addObject(superPower,mainPlayer.getX()+10,mainPlayer.getY()-80);
    }
    public Player getPlayer()
    {
        //I created this method, where I created a main player object return type, getting the player from World class
        return mainPlayer;
    }
    
    public void act()
    {
        // Add sound
        sounds.play();
        //count will change the count
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
        //8 locations where the spawn enemies get added in the world and they will randomly go through all of these spawns
        //Added a switch with 8 cases as there will be 8 locations the enemies will be randomly coming 
        
        if(count % spawnSpeed == 0)
        {
            //it gets a random number whenever it gets to spawn and assigns the location case 0 through case 7
            //everytime we count and we have a new spawn everytime we count, we set random spawn equal to another greenfoot.getrandom number eight
            randomSpawn = Greenfoot.getRandomNumber(8);
            // switch is if, randomSpawn is variable, and each cases are condition and commands
            switch(randomSpawn){
                //if randomspawn== 0, it will add object enemy and put the enemy to 0,0 location (x, y value)
                //break is added to exit the case
                case 0 : addObject(new Enemy(mainPlayer,counter),0,0);break; 
                // if random spawn==1, we add enemy at this location, half of the width of the world and 0 for height.
                case 1 : addObject (new Enemy(mainPlayer,counter),getWidth()/2,0);break;
                case 2 : addObject (new Enemy(mainPlayer,counter),getWidth(),0);break;
                // if random spawn==3, we add enemy at this location, half of the height and entire width.
                case 3 : addObject (new Enemy(mainPlayer,counter),0,getHeight()/2);break;
                case 4 : addObject (new Enemy(mainPlayer,counter),getWidth(),getHeight()/2);break;
                case 5 : addObject (new Enemy(mainPlayer,counter),0,getHeight());break;
                case 6 : addObject (new Enemy(mainPlayer,counter),getWidth()/2,getHeight());break;
                case 7 : addObject (new Enemy(mainPlayer,counter),getWidth(),getHeight());break;
            
            } 
    }
   
}

}


