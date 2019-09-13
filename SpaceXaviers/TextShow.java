import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teddy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextShow extends Actor
{
    public TextShow(String txt)
{
    // an image with the text of the String txt, size 20, black text color and transparent background
    // refer to the documentation for more information about this constructor
    GreenfootImage g = new GreenfootImage(txt, 40, Color.MAGENTA, null);
    setImage(g);
}

    /**
     * Act - do whatever the Teddy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }   

    
}
