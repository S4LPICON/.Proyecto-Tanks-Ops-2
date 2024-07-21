import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottonPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botton extends HUID
{
    private String action;
    
    public Botton(String img, String action){
        GreenfootImage nimage = new GreenfootImage(img); // Cargar una imagen
        nimage.scale(170, 60); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        this.action = action;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            performAction();
        }
    }
    
    private void performAction() {
        if (action.equals("play")) {
            // Acción para el botón de empezar el juego
            GameControl.iniciar();
        } else if (action.equals("controls")) {
            // Acción para el botón de controls
            Greenfoot.setWorld(new controles());
        } else if (action.equals("back")) {
            // Acción para el botón de volver
            Greenfoot.setWorld(new GameControl());
        }else if (action.equals("quit")) {
            // Acción para el botón de salir
            Greenfoot.stop();
        }
    }
}
