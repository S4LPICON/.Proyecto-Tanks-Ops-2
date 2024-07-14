import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase para el cañón del tanque.
 * 
 * @version 1.0
 */
public class Canion extends Arma {
    //private int rotationSpeed = 3;  // Velocidad de rotación del cañón
    //private int damage;
    //private Mira crosshair;  // Objeto crosshair
   
    //private int recoilDistance = 20;  // Distancia de retroceso
    //private int recoilSpeed = 2;  // Velocidad de retroceso
    //private boolean isPlayingSound = false; // Estado del sonido
    
    //private Tanque xd;

    public Canion(Tanque xda,TextBoxManager txtBox, int municionInicial, int bombasinicial) {
        super(xda,txtBox,municionInicial, bombasinicial, 2); // PORQUE PUTAS SI LE PONGO LE QUITO EL 20 SE CRASHEA
        GreenfootImage nimage = new GreenfootImage("Armas/canion.png"); // Cargar una imagen
        nimage.scale(120, 40); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        //crosshair = new Mira();  // Crea una instancia del crosshair
        //this.txtBox = txtBoxa;
        //xd=xda;
    }

    @Override
    protected void crearProyectil() {
        
        Bala bullet = new Bala();
        double angleRadians = Math.toRadians(getRotation());
        int balaX = (int) (getX() + 28 * Math.cos(angleRadians));  // Calcula la posición X del crosshair
        int balaY = (int) (getY() + 28 * Math.sin(angleRadians));  // Calcula la posición Y del crosshair
        getWorld().addObject(bullet, balaX, balaY);
        bullet.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet.move(40);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        isRecoiling = true;  // Inicia el estado de retroceso
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
    
    
    
}
