import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reparador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reparador extends Construccion
{
    public Reparador(){
        GreenfootImage nimage = new GreenfootImage("Extra/3.png"); // Cargar una imagen
        nimage.scale(215, 116); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
    }
}
