import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Camion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camion extends Extra
{
    public Camion(int angle){
        GreenfootImage nimage = new GreenfootImage("Extra/car1.png"); // Cargar una imagen
        nimage.scale(151, 57); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.turn(angle);
    }
}
