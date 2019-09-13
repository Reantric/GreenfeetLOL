import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ultra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ultra extends Projectile
{
    /**
     * Act - do whatever the Ultra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (p > 1 || life < 0){
            death();
        } else {
        passEdge();
        movement();
        collide();
    }
    }    
    public void movement(){
        int r = ((Space) getWorld()).level;
        if (r > 22){
            move(10);
        } else {
        move(7);
    }
    }
    public void collide(){
        int r = ((Space) getWorld()).level;
        if (isTouching(Bullet.class)){
            life -= 10;
        }
        if (isTouching(Teddy.class)){
            life -= 50;
        }
        if (isTouching(Eye.class)){
            life -= 100;
        }
        if (isTouching(Linux.class)){
            life -= 100;
        }
        if (isTouching(EnergyBall.class)){
            if (r > 22){
                life -= 90;
            } else {
            life -= 100;
        }
        }
    }
}
