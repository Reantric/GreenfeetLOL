import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Linux here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Linux extends Enemy
{
    public int x = 0;
    private SimpleTimer timer = new SimpleTimer();
    private int n = 100;
    private int life = 800;
    public Linux(){
        GreenfootImage image = getImage();
        image.scale(150, 150);
        setImage(image);
    }
    /**
     * Act - do whatever the Linux wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (life < 0){
            getWorld().removeObject(this);
        } else {
        creepyTurn();
        passEdge();
        death();
    }
    }
    public void creepyTurn(){
        setLocation(getExactX()+2,getExactY()-2);
        x+=3;
        setRotation(x);
        shoot();
    }
    public void shoot(){
        boolean r = ((Space) getWorld()).level > 22;
        Bullet Red = new Bullet(true,9,r);
        Red.setRotation(getRotation());
        if (timer.elapse() > n){
            getWorld().addObject(Red, getX(), getY());
            timer.mark();
    }
}
public void death(){
    if (isTouching(Shooter.class)){
        life--;
    }
    if (isTouching(Ultra.class)){
        life -= 10;
    }
}
}
