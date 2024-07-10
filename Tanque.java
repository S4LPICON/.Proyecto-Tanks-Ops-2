import greenfoot.*;

public class Tanque extends Actor {
    private int speed = 5;
    
    
    private EnemyAdm admEnemy =new EnemyAdm(this);
    private Canion canion;
    private HUID huid;
    private VidasCounter vidasCounter;
    private TextBoxManager txtBox;

    
    public Tanque(String imagen) {
        setImage(imagen);
        txtBox = new TextBoxManager();
        canion = new Canion(txtBox, this);
        huid = new HUID();
        vidasCounter = new VidasCounter();
    }
    
    
    public Tanque(String imagen, int velocidad) {
        this.speed = velocidad;
        setImage(imagen);
        txtBox = new TextBoxManager();
        canion = new Canion(txtBox, this);
        huid = new HUID();
        vidasCounter = new VidasCounter();
    }

    public void act() {
        mover();
        getRotation();
        GameControl.checkBorders();
        ComprobarColisiones();
    }

    private void mover() {
        if (Greenfoot.isKeyDown("w")) {
            move(speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("s")) {
            move(-speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            turn(5);
        }
        canion.setLocation(getX(), getY());
    }

    public void addedToWorld(World world) {
        getWorld().addObject(canion, getX(), getY());
        getWorld().addObject(admEnemy, -5, -5);  // Agrega el crosshair al mundo, ajusta la posición según sea necesario
        getWorld().addObject(huid, 150, 50);
        getWorld().addObject(txtBox, 0, 0);
        getWorld().addObject(vidasCounter, 211, 80);
    }
    
    
    public void ComprobarColisiones() {
        Actor colisionado=getOneIntersectingObject(Construccion.class);
        
        if( isTouching(Extra.class)) {
        colisionado = getOneIntersectingObject(Extra.class);
        }
        
        if (colisionado != null) {
            int dx = getX() - colisionado.getX();
            int dy = getY() - colisionado.getY();
            
            int retroceso = 15; // Distancia fija de retroceso
            
            // Determinar la dirección de la colisión
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    // Colisión desde la izquierda
                    setLocation(getX() + retroceso, getY());
                } else {
                    // Colisión desde la derecha
                    setLocation(getX() - retroceso, getY());
                }
            } else {
                if (dy > 0) {
                    // Colisión desde arriba
                    setLocation(getX(), getY() + retroceso);
                } else {
                    // Colisión desde abajo
                    setLocation(getX(), getY() - retroceso);
                }
            }
        }
    
}

}
