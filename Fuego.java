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
        //setImage("Proyectiles/fuego.png");  // Asegúrate de tener una imagen de bala llamada "bala.png"
    }

    //IMPORTANTE ANIMACION DE CUANTO CHOCA CON UN ENEMIGO O CONSTRUCCION
    public void explotar() {
        // Iniciar la animación de explosión
        //exploting = true;
    }
    
    
    public void act() {
        super.act();
        // Aquí puedes agregar más comportamientos específicos para la bala si es necesario
    }
}
