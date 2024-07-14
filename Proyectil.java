import greenfoot.*;  

public abstract class Proyectil extends Actor
{
    private int speed;  // Velocidad de movimiento del proyectil
    private int damage;
    private int frame=0;
    private int frameIndex=0;
    
    private String path;
    
    public Proyectil(int damage) {
        this.damage = damage;
    }
    public Proyectil(int velocidad, int damage, String path) {
        setImage(path+"1.png");
        this.path = path;
        this.speed = velocidad;
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
    
    public void act() {
        animacion();
        mover();
        verificarColisiones();
    }

    
    public void animacion(){
        if (frame % 3 == 0) {
            if (frameIndex < 4) {
                setImage(this.path + (frameIndex + 1) + ".png");
                frameIndex++;
            }
        }
        frame++;
    }
    // Método para mover el proyectil
    protected void mover() {
        move(speed);
    }
    
    public abstract void explotar();
    
    public void verificarColisiones(){
        if (isAtEdge()) {
            getWorld().removeObject(this);
        } else if(isTouching(Actor.class)){
            if(isTouching(Construccion.class) || isTouching(Extra.class)){
                getWorld().removeObject(this); // como toca el enemigo se elimina el objeto antes de hacer danio
            }
        }
    }
}
