import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnergyBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyBall extends Projectile
{
    /**
     * Act - do whatever the EnergyBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (p > 3 || life < 0){
        death();
    } else {
        move(6);
        passEdge();
        collide();
    }    
}
public void collide(){
    if (isTouching(ForceField.class)){
        life -= 50;
    }
    if (isTouching(Shooter.class)){
        life--;
    }
    if (isTouching(Ultra.class)){
        life -= 2;
    }
}
}