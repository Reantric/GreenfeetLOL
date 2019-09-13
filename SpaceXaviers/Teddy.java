import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teddy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teddy extends Enemy
{
    private SimpleTimer timer = new SimpleTimer();
    public int reload = 1000;
    private boolean reloadCheck = true;
    private int dmg = 40;
    private boolean lock = false;
    private boolean eb = false;
    private boolean mm = false;
    public Teddy(int rage){
        if (rage == 1){
            GreenfootImage image = getImage();
            image.scale(150, 150);
            setImage(image);
            reload = 600;
            dmg = 7;
            mm = true;
        } else if (rage == 2){
            GreenfootImage image = getImage();
            image.scale(250, 250);
            setImage(image);
            reload = 4000;
            life = 1500;
            dmg = 1;
            eb = true;
        }
    }

    /**
     * Act - do whatever the Teddy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (die()){
            getWorld().removeObject(this);
        } else {
            if (mm){
                setLocation(getX(),getY()+2);
            }
            passEdge();
            hit();
            creepyTurn();
            aimShoot();
        }
    }   

    public void creepyTurn(){
        Space space = (Space) getWorld();
        int userX = space.userX();
        int userY = space.userY();
        double x = Math.atan2(userX,userY);
        turnTowards(userX,userY);
    }

    public void aimShoot(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Bullet Red = new Bullet(true,7,lock);
        Bullet Red2 = new Bullet(false,7,lock);
        EnergyBall Goku = new EnergyBall();
        int r = ((Space) getWorld()).level;
        if (r > 11){
            lock = true;
        }
        if (r % 8 == 0 && reloadCheck){
            reload -= 20;
            reloadCheck = false;
        } else if (r % 8 != 0){
            reloadCheck = true;
        }
        if (timer.elapse() > reload)
        {
            if (eb){
                getWorld().addObject(Goku, getX(), getY());
                Goku.setRotation(getRotation());
            } else {
                if (r > 8){
                    getWorld().addObject(Red2, getX(),getY());
                    Red2.setRotation(getRotation());
                }
                getWorld().addObject(Red, getX(),getY());
                Red.setRotation(getRotation());
            }
                timer.mark(); // Reset the timer
        }
    }

    public void hit(){
        if (isTouching(Shooter.class)){
            life -= dmg;
        }
        if (isTouching(Ultra.class)){
            life -= 8*dmg;
        }
    }
}
