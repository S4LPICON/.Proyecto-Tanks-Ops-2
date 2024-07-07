import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase para el cañón del tanque.
 * 
 * @version 1.0
 */
public class Canion extends Arma {
    private int rotationSpeed = 4;  // Velocidad de rotación del cañón
    private Mira crosshair;  // Objeto crosshair
    private boolean isRecoiling = false;  // Bandera para controlar el estado de retroceso
    private int recoilStep = 0;  // Contador de pasos de retroceso
    private int recoilDistance = 20;  // Distancia de retroceso
    private int recoilSpeed = 3;  // Velocidad de retroceso
    private boolean isPlayingSound = false; // Estado del sonido
    private TextBoxManager txtBox;
    private Tanque xd;

    public Canion(TextBoxManager txtBoxa, Tanque xda) {
        super(50,8);  // Ejemplo: el cañón comienza con 10 municiones
        setImage("canion.png");  // Asegúrate de tener una imagen de cañón llamada "canion.png"
        crosshair = new Mira();  // Crea una instancia del crosshair
        this.txtBox = txtBoxa;
        xd=xda;
    }

    public void addedToWorld(World world) {
        getWorld().addObject(crosshair, getX() + 200, getY());  // Agrega el crosshair al mundo, ajusta la posición según sea necesario
    }

    public void act() {
        txtBox.setArms(getMunicion()); // setear en el contador las balas que tiene el jugador
        txtBox.setBombs(getBombas()); // el contador de bombas
        controlCanion();  // Controla la rotación del cañón
        if (Greenfoot.isKeyDown("space") && !isRecoiling) {
            disparar();  // Dispara al presionar la tecla Espacio
            
        }
        if (Greenfoot.isKeyDown("shift") && !isRecoiling) {
            bomba();  // deja una mina al presionar shift
            
        }
        handleRecoil();  // Maneja la animación de retroceso
    }

    private void controlCanion() {
        // Actualiza la posición del crosshair para que esté siempre a 200 píxeles frente al cañón
        double angleRadians = Math.toRadians(getRotation());  // Convierte el ángulo de rotación del cañón a radianes
        int crosshairX = (int) (getX() + 400 * Math.cos(angleRadians));  // Calcula la posición X del crosshair
        int crosshairY = (int) (getY() + 400 * Math.sin(angleRadians));  // Calcula la posición Y del crosshair
        crosshair.setLocation(crosshairX, crosshairY);
        boolean isTurning = false;
        
        if (Greenfoot.isKeyDown("left")) {
            turn(-rotationSpeed);  // Gira el cañón hacia la izquierda
            crosshair.turn(-rotationSpeed);  // Gira el crosshair junto con el cañón
            isTurning = true;
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(rotationSpeed);  // Gira el cañón hacia la derecha
            crosshair.turn(rotationSpeed);  // Gira el crosshair junto con el cañón
            isTurning = true;
        }

        if (isTurning) {
            if (!isPlayingSound) {
                //Greenfoot.playSound("tank-turret-rotate.wav");
                isPlayingSound = true;
            }
        } else {
            isPlayingSound = false;
        }
    }

    @Override
    protected void crearProyectil() {
        Bala bullet = new Bala();
        getWorld().addObject(bullet, getX(), getY());
        bullet.setRotation(getRotation());  // Establece la rotación de la bala igual a la del tanque
        bullet.move(40);  // Mueve la bala hacia adelante desde la posición del tanque (alejar o acercar al cañón)
        isRecoiling = true;  // Inicia el estado de retroceso
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
    
    public void crearBomba(){
        Mina bomb = new Mina();
        // Obtener coordenadas delanteras del tanque
        int xDelantero = getX() + (int) (Math.cos(Math.toRadians(xd.getRotation())) * -90); // 20 es la distancia desde el centro del tanque al frente
        int yDelantero = getY() + (int) (Math.sin(Math.toRadians(xd.getRotation())) * -90); // 20 es la distancia desde el centro del tanque al frente
        
        // Aquí deberías colocar el código para crear o mover el objeto detrás del tanque
        getWorld().addObject(bomb, xDelantero, yDelantero);
        
        // Asegúrate de que el tanque siempre se añade después de la mina
        isRecoiling = true;  // Inicia el estado de retroceso
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
    
    private void handleRecoil() {
        if (isRecoiling) {
            recoilStep++;
            if (recoilStep <= recoilDistance / recoilSpeed) {
                move(-recoilSpeed);  // Retrocede el cañón
            } else if (recoilStep <= (recoilDistance / recoilSpeed) * 2) {
                move(recoilSpeed);  // Mueve el cañón de vuelta a su posición original
            } else {
                isRecoiling = false;  // Termina el estado de retroceso
            }
        }
    }
}
