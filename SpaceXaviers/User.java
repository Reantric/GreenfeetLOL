
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Ally
{
    private SimpleTimer timer = new SimpleTimer();
    public int n = 400;
    private boolean reloadCheck = true;
    private GreenfootSound end = new GreenfootSound("GameOver.mp3");
    public User(){
        end.setVolume(50);
        GreenfootImage image = getImage();
            image.scale(75,75);
            setImage(image);
    }
    /**
     * Act - do whatever the User wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().showText("Lives: " + life, 57,45);
        if (die()){
            end.play();
            Greenfoot.stop();
        } else {
            movement();
            aimShoot();
            passEdge();
            hit();
        }
    }   

    public void movement(){
        if (Greenfoot.isKeyDown("w")){
            setLocation(getExactX(),getExactY()-1600/n);
        }
        if (Greenfoot.isKeyDown("a")){
            setLocation(getExactX()-1600/n,getExactY());
        }
        if (Greenfoot.isKeyDown("s")){
            setLocation(getExactX(),getExactY()+1600/n);
        }
        if (Greenfoot.isKeyDown("d")){
            setLocation(getExactX()+1600/n,getExactY());
        }
    }

    public void aimShoot(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Shooter Blue = new Shooter();
        Ultra Power = new Ultra();
        int x = 0;
        int y = 0;
        int r = ((Space) getWorld()).level;
        if (mouse != null){
            x = mouse.getX();
            y = mouse.getY();
        } 
        turnTowards(x,y);
        if (r % 5 == 0 && reloadCheck){
            n -= 50;
            reloadCheck = false;
        } else if (r % 5 != 0){
            reloadCheck = true;
        }
        if (timer.elapse() > n)
        {
            if (r > 16){
            getWorld().addObject(Power, getX(),getY());
        } else {
            getWorld().addObject(Blue, getX(),getY());
        }
            if (r > 8){
                if (r > 22){
                Ultra gor = new Ultra();
                getWorld().addObject(gor,getX(),getY());
                gor.setRotation(getRotation()+20);
                } else {
                Shooter bullet2 = new Shooter();
                getWorld().addObject(bullet2,getX(),getY());
                bullet2.setRotation(getRotation()+20);
            }
            }
            if (r > 16){
                Shooter bullet3 = new Shooter();
                getWorld().addObject(bullet3, getX(),getY());
                bullet3.setRotation(getRotation()-20);
            }
            Blue.setRotation(getRotation());
            Power.setRotation(getRotation());
            timer.mark(); // Reset the timer
        } 
    }
}