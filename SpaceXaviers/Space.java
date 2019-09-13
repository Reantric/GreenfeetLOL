 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    public int level = 0;
    public User Hero = new User();
    public int r = 0;
    GreenfootSound main = new GreenfootSound("main.mp3");
    GreenfootSound waveClear = new GreenfootSound("WaveClear.mp3");
    GreenfootSound Boss = new GreenfootSound("Boss.mp3");
    /**
     * Constructor for objects of class Space.
     * 
     */ 
    public Space()
    {    
        super(1500, 850, 1);
        addObject(Hero, 40, getHeight()-90);
        main.setVolume(50);
        waveClear.setVolume(52);
        Boss.setVolume(45);
        main.playLoop();
    }

    public void act(){
        r++;
        populate();
        showText("Level: " + level,40,20);
    }

    public void populate(){
        if (levelUp()){
            level++;
            waveClear.play();
            if (level < 8){
                for (int i = 0; i < level; i++){
                    addObject(new Teddy(0), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }

            } else if (level == 8){
                main.stop();
                Boss.playLoop();
                addObject(new Eye(1), 750,850/2);
            } else if (level > 8 && level < 12){
                Boss.stop();
                main.play();
                for (int i = 0; i < (level - 4); i++){
                    addObject(new Teddy(0), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }
            } else if (level > 11 && level < 16){
                for (int i = 0; i < (level - 11); i++){
                    addObject(new Teddy(1), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }
            } else if (level == 16){
                main.stop();
                Boss.playLoop();
                addObject(new Eye(2), psX(), psY());
                addObject(new ForceField(), psX() +100, psY() - 100);
                addObject(new TextShow("You might need some help defeating this enemy. Pick up the magenta forcefield."), 732, 760);
                Greenfoot.delay(300);
                removeObjects(getObjects(TextShow.class));
            }
            else if (level == 17){
                for (int i = 0; i < 6; i++){
                    addObject(new Teddy(1), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }
                addObject(new Linux(), 1000,350);
                Greenfoot.delay(100);
            }
            else if (level == 18){
                for (int i = 0; i < 8; i++){
                    addObject(new Teddy(1), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }
                addObject(new Linux(), psX(),psY());
                addObject(new Eye(2), psX()+500, psY());
                addObject(new Eye(2), psX()+400, psY()-200);
                Greenfoot.delay(100);
            }
            else if (level == 19){
                Boss.stop();
                main.playLoop();
                addObject(new Linux(), psX(),psY());
                addObject(new Linux(), psX()+690,psY()-320);
            } else if (level == 20){
                for (int i = 0; i  < 4; i++){
                    addObject(new Eye(3), psX(), psY());
                }
                addObject(new Linux(), psX(), psY());
                addObject(new ForceField(), getWidth()/2, userY());
            }
            else if (level == 21){
               addObject(new Teddy(2), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
            }
            else if (level == 22){
                addObject(new Teddy(2), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                addObject(new Teddy(2), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                addObject(new Linux(), psX(), psY());
                addObject(new Eye(3), psX(), psY());
                for (int i = 0; i < 5; i++){
                    addObject(new Teddy(1), Greenfoot.getRandomNumber(getWidth()/4)+3*getWidth()/4,Greenfoot.getRandomNumber(getHeight()-30)+30);
                }
            } else if (level == 23){
                addObject(new Linux(), 50,50);
            }

        }
    }

    public boolean levelUp(){
        return getObjects(Enemy.class).size() == 0;
    }

    public int userX(){
        return Hero.getX();
    }

    public int userY(){
        return Hero.getY();
    }

    public int psX(){
        int x = getWidth() - userX();
        if (x < 250){
            x = -1*Greenfoot.getRandomNumber(x) + 250;
        }
        if (x > getWidth() - 250){
            x = Greenfoot.getRandomNumber(x) - 250;
        }
        return x;
    }

    public int psY(){
        int y = getHeight() - userY();
        if (y < 250){
            y = Greenfoot.getRandomNumber(y) + 250;
        }
        if (y > getHeight() - 250){
            y = Greenfoot.getRandomNumber(y) - 250;
        } 
        return y;
    }
}

