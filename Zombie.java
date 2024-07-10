import greenfoot.*;

public class Zombie extends Enemy {
    
    String[] WalkAnimation = new String[]{"Enemigos/ZombieAnimation/1.png", "Enemigos/ZombieAnimation/2.png", "Enemigos/ZombieAnimation/3.png","Enemigos/ZombieAnimation/4.png","Enemigos/ZombieAnimation/5.png","Enemigos/ZombieAnimation/6.png","Enemigos/ZombieAnimation/7.png", "Enemigos/ZombieAnimation/8.png"};
    int frameActual=0;
    int frameDuration = 10;
    public Zombie(Tanque player, EnemyAdm admn, int vida, int speed) {
        super(player,admn,vida,speed);
        
        mapa = GameControl.mpActual;
    }

    public void act() {
        super.act();
        
        animarCaminar(WalkAnimation,frameDuration);
        //animarCaminar(WalkAnimation, 10);
        //aplayDeadAnimation();
        //IaEnemy();
    }
    
    
    
    public void animarCaminar(String[] imagePaths, int frameDuration) {
        if(!isDead){
            int numFrames = imagePaths.length;
        
            // Calcula el índice del frame actual basado en el tiempo transcurrido
            int currentFrame = (frame / frameDuration) % numFrames;
        
            // Establece la imagen actual del array de imágenes
            setImage(imagePaths[currentFrame]);
        
            // Incrementa el contador de frames
            frame++;
        }
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
                //world.removeObject(this); // Eliminar el zombie del mundo
            }
        }
    }





}
