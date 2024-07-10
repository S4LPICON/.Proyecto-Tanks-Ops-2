import greenfoot.*;  

public class Proyectil extends Actor
{
    private int speed;  // Velocidad de movimiento del proyectil
    private int damage;
    
    
    public Proyectil(int damage) {
        this.damage = damage;
    }
    public Proyectil(int velocidad, int damage) {
        this.speed = velocidad;
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
    
    public void act() {
        
        if (this != null) { // Verifica si el actor aún está en el mundo
            mover();
            verificarColisiones();
               // Realiza acciones válidas en el mundo
            
        }
        
    }

    // Método para mover el proyectil
    protected void mover() {
        move(speed);
    }

    
    public void verificarColisiones(){
        if (isAtEdge()) {
            getWorld().removeObject(this);
        } else if(isTouching(Actor.class)){
            if(!isTouching(Mira.class) && !isTouching(Enemy.class)){
                getWorld().removeObject(this); // como toca el enemigo se elimina el objeto antes de hacer danio
            }
        }
    }
}
