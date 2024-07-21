import greenfoot.*; 

public class Bala extends Proyectil
{
    private static final int VELOCIDAD_DEFAULT = 25;

    public Bala() {
        super(VELOCIDAD_DEFAULT, 13, "Proyectiles/Bala/");
    }
    
    //en este caso la bala no es explosiva
    public void explotar() {}
    
    public void act() {
        super.act();
    }
}
