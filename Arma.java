import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase base para todas las armas.
 * 
 * @version 1.0
 */
public abstract class Arma extends Actor {
    protected int municion;
    private int rotationSpeed = 3;  // Velocidad de rotación del cañón
    private int bombas;
    protected Tanque xd;
    protected boolean isRecoiling = false;  // Bandera para controlar el estado de retroceso
    protected boolean isRecoiling1 = false;  // Bandera para controlar el estado de retroceso
    protected int recoilStep = 0;  // Contador de pasos de retroceso
    private TextBoxManager txtBox;
    
    private Mira crosshair = new Mira();  // Objeto crosshair
   
    private int recoilDistance = 20;  // Distancia de retroceso
    private int recoilSpeed = 2;  // Velocidad de retroceso
    private int recoilSpeed1 = 2;  // Velocidad de retroceso
    private boolean isPlayingSound = false; // Estado del sonido
    
    public Arma(Tanque xda,TextBoxManager txtBoxa,int municionInicial, int bombasinicial) {
        
        this.municion = municionInicial;
        this.bombas = bombasinicial;
        this.xd = xda;
        this.txtBox = txtBox;
    }
    
    public Arma(Tanque xda,TextBoxManager txtBoxa, int municionInicial, int bombasinicial, int recoilSpeed) {
        this.txtBox = txtBoxa;
        this.recoilSpeed = recoilSpeed;
        this.municion = municionInicial;
        this.bombas = bombasinicial;
        this.xd = xda;
        
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

       // if (isTurning) {
       //     if (!isPlayingSound) {
        //        //Greenfoot.playSound("tank-turret-rotate.wav");
        //        isPlayingSound = true;
            //            }
          //  } else {
           // isPlayingSound = false;
    }
    
    
    public void act() {
        txtBox.setArms(getMunicion()); // setear en el contador las balas que tiene el jugador
        txtBox.setBombs(getBombas()); // el contador de bombas
        txtBox.setScore(xd.getPuntuacion());
        txtBox.setRound(((EnemyAdm.ronda)-1));
        controlCanion();  // Controla la rotación del cañón
        if (Greenfoot.isKeyDown("space") && !isRecoiling) {
            disparar();  // Dispara al presionar la tecla Espacio
            
        }
        if (Greenfoot.isKeyDown("shift") && !isRecoiling) {
            bomba();  // deja una mina al presionar shift
            
        }
        handleRecoil();  // Maneja la animación de retroceso
        handleRecoil1();
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
    
    private void handleRecoil1() {
        if (isRecoiling1) {
            recoilStep++;
            if (recoilStep >= 12) {
                isRecoiling1 = false;  // Termina el estado de retroceso
            }
        }
    }
    
    public void addedToWorld(World world) {
        getWorld().addObject(crosshair, getX() + 200, getY());  // Agrega el crosshair al mundo, ajusta la posición según sea necesario
    }  
    
    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public int getBombas() {
        return bombas;
    }

    public void setBombas(int bombas) {
        this.bombas = bombas;
    }
    
    public void recargar(int cantidad) {
        this.municion += cantidad;
    }

    public void disparar() {
        if (municion > 0) {
            municion--;
            crearProyectil();
        }
    }
    public void bomba() {
        if (bombas > 0 && !isRecoiling1) {
            bombas--;
            crearBomba();
        }
    }
    
    public void crearBomba(){
        Mina bomb = new Mina();
        // Obtener coordenadas delanteras del tanque
        int xDelantero = getX() + (int) (Math.cos(Math.toRadians(xd.getRotation())) * -90); // 20 es la distancia desde el centro del tanque al frente
        int yDelantero = getY() + (int) (Math.sin(Math.toRadians(xd.getRotation())) * -90); // 20 es la distancia desde el centro del tanque al frente
        
        // Aquí deberías colocar el código para crear o mover el objeto detrás del tanque
        getWorld().addObject(bomb, xDelantero, yDelantero);
        
        // Asegúrate de que el tanque siempre se añade después de la mina
        isRecoiling1 = true;  // Inicia el estado de retroceso
        recoilStep = 0;  // Resetea el contador de pasos de retroceso
    }
    
    protected abstract void crearProyectil();
}
