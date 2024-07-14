import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Metal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Metal extends Extra
{
    public Metal(int angle){
        GreenfootImage nimage = new GreenfootImage("Extra/metal.png"); // Cargar una imagen
        nimage.scale(187, 100); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.turn(angle);
    }
}
