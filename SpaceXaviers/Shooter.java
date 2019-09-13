
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends Projectile
{
    public Shooter(){
        GreenfootImage scale = getImage();
        //blahblahblah
    }

    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (life <= 0){
            death();
        } else {
            collide();
            movement();
            edgeCheck();
        }
    }    

    public void movement(){
        move(10);
    }

    public void collide(){
        int r = ((Space) getWorld()).level;
        if (isTouching(Bullet.class)){
            if (r > 9){
                life += (r-9);
            }
            life -= 50;
        }
        if (isTouching(Teddy.class)){
            life -= 100;
        }
        if (isTouching(Eye.class)){
            life -= 100;
        }
        if (isTouching(Linux.class)){
            life -= 100;
        }
        if (isTouching(EnergyBall.class)){
            life -= 100;
        }
    }
}
