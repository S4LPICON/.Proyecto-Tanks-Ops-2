import greenfoot.*;

public class Tanque extends Actor {
    private int speed = 5;
    private Canion canion;
    private HUID huid;
    private VidasCounter vidasCounter;
    private TextBoxManager txtBox;

    
    public Tanque(String imagen) {
        setImage(imagen);
        txtBox = new TextBoxManager();
        canion = new Canion(txtBox);
        huid = new HUID();
        vidasCounter = new VidasCounter();
    }

    public void act() {
        mover();
        GameControl.checkBorders();
    }

    private void mover() {
        if (Greenfoot.isKeyDown("w")) {
            move(speed);
            txtBox.setBombs(8); // el contador de bombas
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
        getWorld().addObject(huid, 150, 50);
        getWorld().addObject(txtBox, 500, 500);
        getWorld().addObject(vidasCounter, 211, 80);
    }
}
