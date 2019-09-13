import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectile
{
    public boolean dir;
    public int s;
    private int dmg = 100;
    private boolean t = false;
    private SimpleTimer timer = new SimpleTimer();
    public Bullet(boolean Direction,int speed,boolean target){
        dir = Direction;
        s = speed;
        t = target;
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
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
        int r = ((Space) getWorld()).level;
        if (dir){
            if (t){
                if (timer.elapse() > 400){
                dmg = 60;
                Space space = (Space) getWorld();
                int userX = space.userX();
                int userY = space.userY();
                double x = Math.atan2(userX,userY);
                turnTowards(userX,userY);
                }
            }
            move(s);
        } else {
            move(-s);
        }
    }
    public void collide(){
        if (isTouching(Shooter.class)){
            life -= dmg;
        }
        if (isTouching(ForceField.class)){
            life -= 100;
        }
        if (isTouching(Ultra.class)){
            life -= 100;
        }
    }
}
