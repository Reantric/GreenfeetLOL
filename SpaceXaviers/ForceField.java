import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForceField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceField extends Tank
{
    public int hp = 1000; 
    public ForceField(){
        GreenfootImage image = getImage();
        image.scale(160, 160);
        setImage(image);
    }

    /**
     * Act - do whatever the ForceField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        TextShow bendy = new TextShow("Forcefield hp: " + hp);
     if (hp <= 0 || isAtEdge()){
            getWorld().removeObject(this);
        } else {
            delete();
            if (hp > 10){
                getImage().setTransparency(hp/4);
            }
            if (hp > 0){
                getWorld().addObject(bendy, 80, 65);
                }
            if (isTouching(User.class)){
                follow();
            }
            getWorld().removeObject(bendy);
        }
    }  

    public void follow(){
        Space space = (Space) getWorld();
        int hX = space.userX();
        int hY = space.userY();
        setLocation(hX,hY);
    }

    public void delete(){
        if (isTouching(Bullet.class)){
            hp-=2;
        }
        if (isTouching(Teddy.class)){
            hp -= 10;
        }
        if (isTouching(Eye.class) && isTouching(User.class)){
            hp -= 20;
        }
        if (isTouching(God.class)){
            getWorld().showText("What have you done?!", getX(), getY()-150);
            hp -= 10000;
        }
        if (isTouching(EnergyBall.class)){
            hp -= 200;
        }
        if (isTouching(Linux.class) && isTouching(User.class)){
            hp -= 50;
        }
    }
}
