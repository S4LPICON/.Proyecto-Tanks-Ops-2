import greenfoot.*;
import java.util.ArrayList;

public class GameControl extends World{
    public static int mpActual;  // Estado del mundo actual
    public static int municion = 500;
    public static Tanque player;
    
    public static LanzaLlamas lanzallamas;
    public static Escopeta escopeta;
    
    //Botones del menu play, controls, quit
    private Botton bt1 = new Botton("HUID/Play Button.png", "play");
    private Botton bt2 = new Botton("HUID/Controls Button.png", "controls");
    private Botton bt3 = new Botton("HUID/Quit Button.png", "quit");
    
    //instancia de los mapas para tenerlos en memoria
    public static MapaSub1 mapa1;
    public static MapaSub2 mapa2;
    public static MapaSub3 mapa3;
    public static MapaSub4 mapa4;
    
    //variables del jugador para que los zombies lo puedan seguir
    public static int mapa1Exit_x,mapa1Exit_y;
    public static int mapa2Exit_x,mapa2Exit_y;
    public static int mapa3Exit_x,mapa3Exit_y;
    public static int mapa4Exit_x,mapa4Exit_y;
    
    //musica del menu
    public static GreenfootSound MusicaMenu = new GreenfootSound("menugame.mp3");
    private int xd=0;

    public GameControl() {
        super(1000,600,1);
        player = new Tanque("Tanques/tank.png");
        setBackground("menu.jpeg");
        aniadirBottones();
        mapa1 = new MapaSub1();
        mapa2 = new MapaSub2();
        mapa3 = new MapaSub3();
        mapa4 = new MapaSub4();
        MusicaMenu.playLoop();
    }
    
    public static void iniciar(){
        MusicaMenu.stop();
        Greenfoot.setWorld(mapa1);
        mpActual = 1;
        mapa1.addObject(player, 600, 600);
    }
    
    // Encargado de detectar las cordenadas por donde el jugador sale de la pantalla para enviarlo a otro mapa
    public static void checkBorders() {
        int x = player.getX();
        int y = player.getY();
        int worldWidth = player.getWorld().getWidth();
        int worldHeight = player.getWorld().getHeight();

    
        if (x >= worldWidth - 1) { // derecha
            if (mpActual == 1) {
                mapa1Exit_x = player.getX();
                mapa1Exit_y = player.getY();
                switchWorld(mapa2, player, "right");
                mpActual = 2;
                
            } else if (mpActual == 3) {
                mapa3Exit_x = player.getX();
                mapa3Exit_y = player.getY();
                switchWorld(mapa4, player, "right");
                mpActual = 4;
                
            }
        } else if (x <= 0) { // izquierda
            if (mpActual == 2) {
                mapa2Exit_x = player.getX();
                mapa2Exit_y = player.getY();
                switchWorld(mapa1, player, "left");
                mpActual = 1;
                
            } else if (mpActual == 4) {
                mapa4Exit_x = player.getX();
                mapa4Exit_y = player.getY();
                switchWorld(mapa3, player, "left");
                mpActual = 3;
                
            }
        } else if (y >= worldHeight - 1) { // abajo
            if (mpActual == 1) {
                mapa1Exit_x = player.getX();
                mapa1Exit_y = player.getY();
                switchWorld(mapa3, player, "down");
                mpActual = 3;
                
            } else if (mpActual == 2) {
                mapa2Exit_x = player.getX();
                mapa2Exit_y = player.getY();
                switchWorld(mapa4, player, "down");
                mpActual = 4;
                
            }
        } else if (y <= 0) { // arriba
            if (mpActual == 3) {
                mapa3Exit_x = player.getX();
                mapa3Exit_y = player.getY();
                switchWorld(mapa1, player, "up");
                mpActual = 1;
                
            } else if (mpActual == 4) {
                mapa4Exit_x = player.getX();
                mapa4Exit_y = player.getY();
                switchWorld(mapa2, player, "up");
                mpActual = 2;
                
            }
        }
    }

    private static void switchWorld(Mapas newWorld, Tanque player, String direction) {
        // Guardar la posición actual del jugador
        int x = player.getX();
        int y = player.getY();

        // Cambiar al nuevo mundo
        Greenfoot.setWorld(newWorld); // new world es el mundo a mover
        newWorld.aniadir(player); //se supone que aniade el jugador

        if (direction.equals("right")) {
            player.setLocation(newWorld.getWidth() - newWorld.getWidth() +1, y);
            
        } else if (direction.equals("left")) {
            player.setLocation(newWorld.getWidth() - 1, y);
            
        } else if (direction.equals("down")) {
            player.setLocation(x, 1);
            
        } else if (direction.equals("up")) {
            player.setLocation(x, newWorld.getHeight() - 1);
        }
    }
    
    //botones del menu
    public void aniadirBottones(){
        addObject(bt1, 500, 300);
        addObject(bt2, 500, 370);
        addObject(bt3, 500, 440);
    }
}
