import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cangrejo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cangrejo extends Enemy
{
    public Cangrejo(Tanque player, EnemyAdm admn, int vida, int speed) {
        super(player,admn,vida,speed);
        
        mapa = GameControl.mpActual;
    }
    public void act()
    {
        // Add your action code here.
    }
    
    public void animarCaminar(String[] imagePaths, int frameDuration) {
        int numFrames = imagePaths.length;
    
        // Calcula el índice del frame actual basado en el tiempo transcurrido
        int currentFrame = (frame / frameDuration) % numFrames;
    
        // Establece la imagen actual del array de imágenes
        setImage(imagePaths[currentFrame]);
    
        // Incrementa el contador de frames
        frame++;
    }

    public void aplayDeadAnimation() {
        if (frame % 3 == 0) {
            if (deadIndex < 12) {
                setImage("Proyectiles/Explosion/" + (deadIndex + 1) + ".png");
                deadIndex++;
            }
        }
        frame++;

        // Cuando la animación de muerte ha terminado
        if (deadIndex >= 12) {
            World world = getWorld();
            if (world != null) {
                world.removeObject(this); // Eliminar el zombie del mundo
            }
        }
    }
}
