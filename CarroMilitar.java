import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarroMilitar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarroMilitar extends Extra
{
    public CarroMilitar(int angle){
        GreenfootImage nimage = new GreenfootImage("Extra/military.png"); // Cargar una imagen
        nimage.scale(136,61); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.turn(angle);
    }
}
