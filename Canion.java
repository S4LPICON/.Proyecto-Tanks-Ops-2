import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase para el cañón del tanque.
 * 
 * @version 1.0
 */
public class Canion extends Arma {

    public Canion(Tanque xda,TextBoxManager txtBox, int municionInicial, int bombasinicial) {
        super(xda,txtBox,municionInicial, bombasinicial, 2);
        GreenfootImage nimage = new GreenfootImage("Armas/canion.png"); // Cargar la imagen del canion correspondiente
        nimage.scale(120, 40); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
    }

    @Override //metodo abstracto de crear proyectil
    protected void crearProyectil() {
        Greenfoot.playSound("tankshoot.wav");//reproduce el sonido correspondiente
        Bala bullet = new Bala();
        double angleRadians = Math.toRadians(getRotation()); // el angulo del canion en radianes
        int balaX = (int) (getX() + 28 * Math.cos(angleRadians));  // Calcula la posición X del crosshair
        int balaY = (int) (getY() + 28 * Math.sin(angleRadians));  // Calcula la posición Y del crosshair
        
        getWorld().addObject(bullet, balaX, balaY);
        
        bullet.setRotation(getRotation());  // Establece la rotación de la bala igual a la del canion
        bullet.move(40);  // Mueve la bala hacia adelante
        isRecoiling = true;  // Inicia el estado de retroceso
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
}
