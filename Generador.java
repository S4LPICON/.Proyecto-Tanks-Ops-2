import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Generador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Generador extends Extra
{
    public Generador(){
        setImage("Extra/generador.png");
    }
    public void act()
    {
        // Add your action code here.
        verifColisPlayer();
    }
    
    
    public void verifColisPlayer(){
        
        if( isTouching(Tanque.class)) {
        Actor colisionado = getOneIntersectingObject(Tanque.class);
        
        
        if (colisionado != null) {
            int dx = getX() - colisionado.getX();
            int dy = getY() - colisionado.getY();
            
            int retroceso = 15; // Distancia fija de retroceso
            
            // Determinar la dirección de la colisión
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    // Colisión desde la izquierda
                    System.out.println("Colisiono generador iz");
                } else {
                    // Colisión desde la derecha
                    System.out.println("Colisiono generador derecha");
                }
            } else {
                if (dy > 0) {
                    // Colisión desde arriba
                    System.out.println("Colisiono generador arr");
                } else {
                    // Colisión desde abajo
                    System.out.println("Colisiono generador abajo");
                }
            }
        }
    }
}
}
