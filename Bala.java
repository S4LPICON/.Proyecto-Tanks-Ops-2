import greenfoot.*; 

public class Bala extends Proyectil
{
    private static final int VELOCIDAD_DEFAULT = 25;

    public Bala() {
        super(VELOCIDAD_DEFAULT, 1, "Proyectiles/Bala/");
        //setImage("Proyectiles/bala.png");  // Asegúrate de tener una imagen de bala llamada "bala.png"
    }
    
    //IMPORTANTE ANIMACION DE CUANTO CHOCA CON UN ENEMIGO O CONSTRUCCION
    public void explotar() {
        // Iniciar la animación de explosión
        //exploting = true;
    }
    
    public void act() {
        super.act();
        // Aquí puedes agregar más comportamientos específicos para la bala si es necesario
    }
}
