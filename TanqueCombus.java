import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TanqueCombus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TanqueCombus extends Construccion
{
    public TanqueCombus(int angle){
        GreenfootImage nimage = new GreenfootImage("Extra/fuelBox.png"); // Cargar una imagen
        nimage.scale(65, 116); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.turn(angle);
    }
}
