import greenfoot.*;

public class Zombie extends Enemy {
    
    String[] WalkAnimation = new String[]{"Enemigos/Zombie/ZombieWalkAnimation/1.png", "Enemigos/Zombie/ZombieWalkAnimation/2.png", "Enemigos/Zombie/ZombieWalkAnimation/3.png","Enemigos/Zombie/ZombieWalkAnimation/4.png","Enemigos/Zombie/ZombieWalkAnimation/5.png","Enemigos/Zombie/ZombieWalkAnimation/6.png","Enemigos/Zombie/ZombieWalkAnimation/7.png", "Enemigos/Zombie/ZombieWalkAnimation/8.png"};
    int frameActual=0;
    int frameDuration = 10;//
    
    int indexHurt =0;
    int frameHurt=0;
    public Zombie(Tanque player, EnemyAdm admn, int vida, int speed) {
        super(player,admn,vida,speed, 10);
        
        mapa = GameControl.mpActual;
    }

    public void act() {
        super.act();
        //getWorld().showText("Damaging " + isDamageRecibe, getX(), getY()-15);
        //animarCaminar(frameDuration);
        
        //animarCaminar(WalkAnimation, 10);
        //aplayDeadAnimation();
        //IaEnemy();
    }
    public void addedToWorld(){
        getWorld().showText("Damaging " + isDamageRecibe, 500, 500);
    }
    
    
    public void hurtAnimation(){
        if (frameHurt % 3 == 0) {
            if (indexHurt < 16 && !isDead) {
                setImage("Enemigos/Zombie/ZombieHurtAnimation/" + (indexHurt+ 1) + ".png");
                indexHurt++;
            }else{
                isDamageRecibe = false;
                indexHurt =0;
                frameHurt =0;
            }
        }
        frameHurt++;
    }
    
    public void animarCaminar(int frameDuration) {
        if(!isDead){
            int numFrames = WalkAnimation.length;
        
            // Calcula el índice del frame actual basado en el tiempo transcurrido
            int currentFrame = (frame / frameDuration) % numFrames;
        
            // Establece la imagen actual del array de imágenes
            setImage(WalkAnimation[currentFrame]);
        
            // Incrementa el contador de frames
            frame++;
        }
    }
    public void aplayDeadAnimation() {
        if (frame % 3 == 0) {
            if (deadIndex < 12) {
                setImage("Enemigos/Zombie/ZombieDeadAnimation/" + (deadIndex + 1) + ".png");
                deadIndex++;
            }
        }
        frame++;

        // Cuando la animación de muerte ha terminado
        if (deadIndex >= 12) {
            World world = getWorld();
            if (this != null && world != null) {
                world.removeObject(this); // Eliminar el zombie del mundo
            }
        }
    }
}
