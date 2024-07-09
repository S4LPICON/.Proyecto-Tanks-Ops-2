import greenfoot.*;
import java.util.ArrayList;


public class GameControl extends World{
    public static int mpActual;  // Estado del mundo actual
    public static Tanque player;
    public static MapaSub1 mapa1;
    public static MapaSub2 mapa2;
    public static MapaSub3 mapa3;
    public static MapaSub4 mapa4;
    public static int mapa1Exit_x,mapa1Exit_y;
    public static int mapa2Exit_x,mapa2Exit_y;
    public static int mapa3Exit_x,mapa3Exit_y;
    public static int mapa4Exit_x,mapa4Exit_y;

    public GameControl() {
        super(1,1,1);
        // Asigna el tanque al primer mapa
        player = new Tanque("tank.png");
        mapa1 = new MapaSub1(player);
        Greenfoot.setWorld(mapa1);
        mapa2 = new MapaSub2();
        mapa3 = new MapaSub3();
        mapa4 = new MapaSub4();
        mpActual = 1;
      
        mapa1.addObject(player, mapa1.getWidth() / 2, mapa1.getHeight() / 2);
    }
    
    
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
}
