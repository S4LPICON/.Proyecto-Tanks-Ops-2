import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro extends Extra
{
    public Carro(int angle){
        GreenfootImage nimage = new GreenfootImage("Extra/car.png"); // Cargar una imagen
        nimage.scale(151, 57); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.turn(angle);
    }
}
