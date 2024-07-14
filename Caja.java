import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caja extends Extra
{
    public Caja(){
        GreenfootImage nimage = new GreenfootImage("Extra/box.png"); // Cargar una imagen
        nimage.scale(60, 60); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
    }
}
