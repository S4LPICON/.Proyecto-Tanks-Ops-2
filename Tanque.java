import greenfoot.*;

public class Tanque extends Actor {
    private int speed = 10;
    
    
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
        getWorld().addObject(admEnemy, 500, 500);  // Agrega el crosshair al mundo, ajusta la posición según sea necesario
        getWorld().addObject(huid, 150, 50);
        getWorld().addObject(txtBox, 0, 0);
        getWorld().addObject(vidasCounter, 211, 80);
    }
    
    
    
}
