import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eye extends Enemy
{
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer timer2 = new SimpleTimer();
    private int n = 1200;
    public int life = 150;
    private boolean lock = false;
    public Eye(int level){
        GreenfootImage image = getImage();
        image.scale(150, 150);
        setImage(image);
        System.out.println(level);
        switch(level){
            case 1: life = 120;
                    break;
                    
            case 2: life = 150;
                    break;
            case 3: life = 400;
                    break;
                    
            default: life = 10;
                     break;
        }
    }

    /**
     * Act - do whatever the Eye wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (life < 0){
            getWorld().removeObject(this);
        } else {
            moveRandom();
            reload();
            reinforce();
            int random = Greenfoot.getRandomNumber(100)+156;
            getImage().setTransparency(random);
            death();
            passEdge();
        }
    }

    public void moveRandom(){
        move(Greenfoot.getRandomNumber(40)-20);
    }

    public void reload(){
        int r = ((Space) getWorld()).level;
        if (r > 11 && r < 17 || r > 19){
            lock = true;
        }
        Bullet bullet = new Bullet(true,10,lock);
        Bullet bullet2 = new Bullet(true,10,lock);
        Bullet bullet3 = new Bullet(true,10,lock);
        Bullet bullet4 = new Bullet(true,10,lock);
        Bullet bullet5 = new Bullet(true,10,lock);
        Bullet bullet6 = new Bullet(true,10,lock);
        Bullet bullet7 = new Bullet(true,10,lock);
        Bullet bullet8 = new Bullet(true,10,lock);
        Bullet bullet9 = new Bullet(true,10,lock);
        Bullet bullet10 = new Bullet(true,10,lock);
        Bullet bullet11 = new Bullet(true,10,lock);
        Bullet bullet12 = new Bullet(true,10,lock);
        if (timer.elapse() > n){
            getWorld().addObject(bullet,getX()-6,getY());
            bullet.setRotation(0);
            getWorld().addObject(bullet2,getX()-6,getY());
            bullet2.setRotation(30);
            getWorld().addObject(bullet3,getX()-6,getY());
            bullet3.setRotation(-30);
            getWorld().addObject(bullet4,getX()-6,getY());
            bullet4.setRotation(60);
            getWorld().addObject(bullet5,getX()-6,getY());
            bullet5.setRotation(-60);
            getWorld().addObject(bullet6,getX()-6,getY());
            bullet6.setRotation(-180);
            getWorld().addObject(bullet7,getX()-6,getY());
            bullet7.setRotation(-150);
            getWorld().addObject(bullet8,getX()-6,getY());
            bullet8.setRotation(-120);
            getWorld().addObject(bullet9,getX()-6,getY());
            bullet9.setRotation(90);
            getWorld().addObject(bullet10,getX()-6,getY());
            bullet10.setRotation(-90);
            getWorld().addObject(bullet11,getX()-6,getY());
            bullet11.setRotation(120);
            getWorld().addObject(bullet12,getX()-6,getY());
            bullet12.setRotation(150);
            timer.mark();
        }
        if (survival()){
            n = 600;
            if (timer.elapse() > n){
                getWorld().addObject(bullet,getX()-6,getY());
                bullet.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet2,getX()-6,getY());
                bullet2.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet3,getX()-6,getY());
                bullet3.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet4,getX()-6,getY());
                bullet4.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet5,getX()-6,getY());
                bullet5.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet6,getX()-6,getY());
                bullet6.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet7,getX()-6,getY());
                bullet7.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet8,getX()-6,getY());
                bullet8.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet9,getX()-6,getY());
                bullet9.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet10,getX()-6,getY());
                bullet10.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet11,getX()-6,getY());
                bullet11.setRotation(Greenfoot.getRandomNumber(359));
                getWorld().addObject(bullet12,getX()-6,getY());
                bullet12.setRotation(Greenfoot.getRandomNumber(359));
                timer.mark();
            }
        }
    }

    public void reinforce(){
        int rand = Greenfoot.getRandomNumber(2)-1;
        Space space = (Space) getWorld();
        if (timer2.elapse() > 8*n){
            if (rand != 0){
            getWorld().addObject(new Teddy(0), space.userX() + rand*240, space.userY());
        }
        timer2.mark();
    }
    }

    public void death(){
        if (isTouching(Shooter.class)){
            life --;
        }
        if (isTouching(EnergyBall.class)){
            life -= 50;
        }
        if (isTouching(Ultra.class)){
            life -= 30;
        }
    }

    public boolean survival(){
        return life < 20;
    }
   
}
