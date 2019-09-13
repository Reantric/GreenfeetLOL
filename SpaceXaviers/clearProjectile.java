import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class clearProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clearProjectile extends Tank
{
    /**
     * Act - do whatever the clearProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(User.class)){
            getWorld().removeObjects(getWorld().getObjects(Bullet.class));
            getWorld().removeObjects(getWorld().getObjects(EnergyBall.class));
        }
    }    
    
}
