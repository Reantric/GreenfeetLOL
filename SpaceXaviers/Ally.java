import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ally here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ally extends Mover
{
    public int life = 10;
    GreenfootSound lifeLost = new GreenfootSound("LostLife.mp3");
    public Ally(){
    }
    /**
     * Act - do whatever the Ally wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    } 
    public void hit(){
        if (isTouching(Bullet.class)){
            life--;
            lifeLost.setVolume(40);
            lifeLost.play();
            getWorld().removeObjects(getWorld().getObjects(Projectile.class));
        }
    }
    public boolean die(){
        return (life < 0);
    }

}
