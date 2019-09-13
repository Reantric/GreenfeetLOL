import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Mover
{
    public int life = 100;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }
    public void edgeCheck(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public void death(){
            getWorld().removeObject(this);
    }
}
