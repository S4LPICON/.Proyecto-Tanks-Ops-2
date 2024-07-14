import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escopeta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escopeta extends Arma
{
    public Escopeta(Tanque xda,TextBoxManager txtBoxa, int municionInicial, int bombasinicial){
        super(xda,txtBoxa,municionInicial, bombasinicial, 1);
        setImage("Armas/escopeta.png");
    }
        
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    
    public void disparar() {
        if (municion > 0) {
            municion-=4;
            crearProyectil();
        }
    }
    
    
    //AQUI FALTA AJUSTAR QUE LOS 4 PERDIGONES SALGAN COMPLETAMENTE SEPARADOS COMO SI FUERA UNA ESCOPETA NORMAL
    public void crearProyectil(){
        int xDelantero = getX() + (int) (Math.cos(Math.toRadians(getRotation())) * 20); // 20 es la distancia desde el centro del tanque al frente
        int yDelantero = getY() + (int) (Math.sin(Math.toRadians(getRotation()))* 20); // 20 es la distancia desde el centro del tanque al frente
        
        
        Perdigon bullet = new Perdigon();
        getWorld().addObject(bullet, xDelantero , yDelantero+5);
        Perdigon bullet1 = new Perdigon();
        getWorld().addObject(bullet1, xDelantero , yDelantero-5);
        Perdigon bullet2 = new Perdigon();
        getWorld().addObject(bullet2, xDelantero , yDelantero+10);
        Perdigon bullet3 = new Perdigon();
        getWorld().addObject(bullet3, xDelantero , yDelantero-10);
        
        
        bullet.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet.move(10);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        
        bullet1.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet1.move(20);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        
        bullet2.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet2.move(30);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        
        bullet3.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet3.move(40);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        isRecoiling = true;  // Inicia el estado de retroceso
        
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
}
