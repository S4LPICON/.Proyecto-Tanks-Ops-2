import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fuego extends Proyectil
{
    private static final int VELOCIDAD_DEFAULT = 25;
    
    public Fuego() {
        super(VELOCIDAD_DEFAULT, 3, "Proyectiles/Perdigon/");
    }

    //el fuego no explota
    public void explotar() { }
    
    
    public void act() {
        super.act();
    }
}
