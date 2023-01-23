import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number 4 or jan)
 */
//Weapon button sub class is created and is inherited from Actor class
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //this is the weaponButton is  created to upgrade the super power  and add the color.
    //counter creation.
    //storing the counter 
    Counter counter;
    int weaponUpgrade= 1;
    //This is the WeaponButton method 
    public WeaponButton(Counter counter)
    {
       this.counter =counter;
       //weaponButtonImage is setting ...
       setImage(new GreenfootImage("Weapon  \n Upgrade",25, Color.BLACK,new Color(0,0,0,0)));
    }
    public void act()
    { 
        if(Greenfoot.mousePressed(this) && counter.money>149)
        {
           counter.money-=150;
           //create counter money and if score is more than 150 then weaponButton power is autumatically upgraded.
           weaponUpgrade++;
        }
        if(weaponUpgrade>3)
        weaponUpgrade=3;
}
}