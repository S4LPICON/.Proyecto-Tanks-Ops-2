import greenfoot.*;  

public class Proyectil extends Actor
{
    private int speed;  // Velocidad de movimiento del proyectil

    public Proyectil() {
        
    }
    public Proyectil(int velocidad) {
        this.speed = velocidad;
        
    }

    public void act() {
        mover();
        verificarBordes();
    }

    // Método para mover el proyectil
    protected void mover() {
        move(speed);
    }

    // Método para verificar si el proyectil está en el borde del mundo y eliminarlo si es así
    protected void verificarBordes() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
