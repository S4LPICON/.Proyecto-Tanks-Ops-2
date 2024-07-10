import greenfoot.*; 

public class Bala extends Proyectil
{
    private static final int VELOCIDAD_DEFAULT = 25;

    public Bala() {
        super(VELOCIDAD_DEFAULT, 13);
        setImage("Proyectiles/bala.png");  // Asegúrate de tener una imagen de bala llamada "bala.png"
    }

    public void act() {
        super.act();
        // Aquí puedes agregar más comportamientos específicos para la bala si es necesario
    }
}
