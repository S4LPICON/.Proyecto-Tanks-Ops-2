import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LanzaLlamas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LanzaLlamas extends Arma
{
    public LanzaLlamas(Tanque xda,TextBoxManager txtBoxa, int municionInicial, int bombasinicial){
        super(xda,txtBoxa,municionInicial, bombasinicial, -1);
        setImage("Armas/lanzallamas.png");
    }
        
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    
    public void crearProyectil(){
        Fuego bullet = new Fuego();
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
