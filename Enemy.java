import greenfoot.*;
import java.util.List;

public class Enemy extends Actor {
    private int vida;
    private int mpZomby;
    private int damage;
    private int velocidad;
    private Tanque player;
    private int speed = 2;
    private int mapa = 1;
    private int plpx, plpy;
    private boolean imHere = true;
    private int deadIndex = 0; // Índice de la imagen de la explosión
    private boolean exploting = false; // Flag para saber si está explotando
    private int frame = 0; // Contador de frames
    private EnemyAdm Adm;

    public Enemy(Tanque playera, EnemyAdm admn) {
        setImage("Enemigos/zombie.png");
        player = playera;
        mapa = GameControl.mpActual;
        Adm = admn;
    }

    public void act() {
        if (exploting) {
            aplayDeadAnimation();
        } else {
            if (isTouching(Actor.class)) {
                Actor actor = getOneIntersectingObject(Actor.class);
                if (actor != null && (actor instanceof Proyectil)) {
                    takeDamage(10); // Ejemplo: reducir la vida en 10 cuando se toca un proyectil
                }
            }

            if (isTouching(Tanque.class)) {
                move(-25);
            }
            if (isTouching(Enemy.class)) {
                setRotation(Greenfoot.getRandomNumber(360));
                move(50);
            }

            if (GameControl.mpActual != mapa) {
                if (mapa == 1) {
                    perseguir(GameControl.mapa1Exit_x, GameControl.mapa1Exit_y);
                } else if (mapa == 2) {
                    perseguir(GameControl.mapa2Exit_x, GameControl.mapa2Exit_y);
                } else if (mapa == 3) {
                    perseguir(GameControl.mapa3Exit_x, GameControl.mapa3Exit_y);
                } else if (mapa == 4) {
                    perseguir(GameControl.mapa4Exit_x, GameControl.mapa4Exit_y);
                }
            } else {
                perseguirEnElMismoMundo();
            }

            checkBorders();
        }
    }

    public void perseguir(int x, int y) {
        this.turnTowards(x, y);
        move(speed * 2);
    }

    private void morir() {
        // Iniciar la animación de explosión
        exploting = true;
        deadIndex = 0; // Asegurarse de que el índice de la animación comience desde el principio
        frame = 0; // Reiniciar el contador de frames
    }

    public void perseguirEnElMismoMundo() {
        this.turnTowards(player.getX(), player.getY());
        move(speed);
    }

    private void aplayDeadAnimation() {
        // Cambiar la imagen cada ciertos frames para la animación
        if (frame % 3 == 0) { // Cambia la imagen cada 3 frames (ajusta según necesites)
            if (deadIndex < 12) {
                setImage("Proyectiles/Explosion/" + (deadIndex + 1) + ".png");
                deadIndex++;
            } else {
                // Verificar si el enemigo aún está en el mundo antes de eliminarlo
                World world = getWorld();
                if (world != null) {
                    world.removeObject(this); // Eliminar el zombie del mundo al finalizar la animación
                    Adm.removeEnemy(this);
                }
                return;
            }
        }
        frame++;
    }

    public void checkBorders() {
        int x = this.getX();
        int y = this.getY();
        int worldWidth = this.getWorld().getWidth();
        int worldHeight = this.getWorld().getHeight();

        if (x >= worldWidth - 10) { // derecha
            if (mapa == 1) {
                switchWorld(GameControl.mapa2, this, "right");
                mapa = 2;
            } else if (mapa == 3) {
                switchWorld(GameControl.mapa4, this, "right");
                mapa = 4;
            }
        } else if (x <= 0 + 10) { // izquierda
            if (mapa == 2) {
                switchWorld(GameControl.mapa1, this, "left");
                mapa = 1;
            } else if (mapa == 4) {
                switchWorld(GameControl.mapa3, this, "left");
                mapa = 3;
            }
        } else if (y >= worldHeight - 10) { // abajo
            if (mapa == 1) {
                switchWorld(GameControl.mapa3, this, "down");
                mapa = 3;
            } else if (mapa == 2) {
                switchWorld(GameControl.mapa4, this, "down");
                mapa = 4;
            }
        } else if (y <= 0 + 10) { // arriba
            if (mapa == 3) {
                switchWorld(GameControl.mapa1, this, "up");
                mapa = 1;
            } else if (mapa == 4) {
                switchWorld(GameControl.mapa2, this, "up");
                mapa = 2;
            }
        }
    }

    private void switchWorld(Mapas newWorld, Enemy enemy, String direction) {
        int x = enemy.getX();
        int y = enemy.getY();

        newWorld.aniadir(enemy); // Añadir el enemigo al nuevo mundo

        newWorld.setPlayerPosition(enemy, direction);
        if (isTouching(Enemy.class)) {
            move(-50);
        }
    }

    public boolean shouldBeRemoved() {
        return exploting && deadIndex >= 12; // Indica que el enemigo debe ser eliminado si la animación de explosión ha terminado
    }

    public void takeDamage(int damage) {
        // Lógica para reducir la vida
        vida -= damage;
        if (vida <= 0) {
            morir();
        }
    }
}
