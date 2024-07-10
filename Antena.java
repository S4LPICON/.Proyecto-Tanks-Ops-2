import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Antena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Antena extends Construccion
{
    /**
     * Act - do whatever the Antena wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Antena(){
        setImage("Construcciones/antena.png");
    }
    
    public void act()
    {
        // Add your action code here.
        //ComprobarColisiones();
        if(isTouching(Tanque.class)){
            
        }
    }
    
    public void openMenu(){
        
    }
}
