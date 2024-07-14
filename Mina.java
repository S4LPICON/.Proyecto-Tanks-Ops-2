import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mina extends Proyectil
{
    private int frame = 0; // Contador de frames
    private int explosionIndex = 0; // Índice de la imagen de la explosión
    private boolean exploting = false; // Flag para saber si está explotando
    
    public Mina(){
        super(1);
        setImage("Proyectiles/mina.png"); //la imagen de la mina cmo tal
    }
    
    public void act() {
        if (exploting) {
            playExplosionAnimation();
        } else {
            // Comprobar si la mina está tocando a algún actor que no sea una instancia de "Mira"
            if (isTouching(Actor.class)) {
                Actor actor = getOneIntersectingObject(Actor.class);
                if (!(actor instanceof Mira)&& !(actor instanceof Arma)) { // primera condicion anterior: actor != null && 
                    explotar();
                    
                }
            }
        }
    }

    public void explotar() {
        // Iniciar la animación de explosión
        exploting = true;
    }

    private void playExplosionAnimation() {
        // Cambiar la imagen cada ciertos frames para la animación
        if (frame % 3 == 0) { // Cambia la imagen cada  frames (ajusta según necesites)
            if (explosionIndex < 12) {
                setImage("Proyectiles/Explosion/" + (explosionIndex + 1) + ".png");
                explosionIndex++;
            } else {
                getWorld().removeObject(this); // Eliminar la mina del mundo al finalizar la animación
            }
        }
        frame++;
    }
}
