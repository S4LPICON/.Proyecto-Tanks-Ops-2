import greenfoot.*;

public abstract class Enemy extends Actor {
    
    String[] WalkAnimation;;
    int frameActual=0;
    
    protected int vida;
    protected Tanque player;
    protected int speed;
    protected int mapa;
    protected int deadIndex;
    protected boolean isDead;
    protected int frame;
    protected EnemyAdm Adm;

    public Enemy(Tanque player, EnemyAdm admn, int vida, int speed) {
        this.player = player;
        this.vida = vida;
        this.Adm = admn;
        this.speed = speed;
        this.mapa = 1;
        this.deadIndex = 0;
        this.isDead = false;
        this.frame = 0;
        mapa = GameControl.mpActual;
        Adm = admn;
    }

    public void act() {
        IaEnemy();
    }
    
    public abstract void animarCaminar(String[] imagePaths, int frameDuration);
    public abstract void aplayDeadAnimation();
    
    public void IaEnemy(){
        if (!isDead) {
            PersecucionControl();
            AnimADM();
            ComprobarColisiones();
        } else {
            aplayDeadAnimation();
        }
    }
    
    public void perseguir(int x, int y) {
        this.turnTowards(x, y);
        move(speed * 10);
    }

    public void morir() {
        isDead = true;
        deadIndex = 0;
        frame = 0;
    }

    public void perseguirEnElMismoMundo() {
        this.turnTowards(player.getX(), player.getY());
        move(speed);
    }


    public void checkBorders() {
        int x = this.getX();
        int y = this.getY();
        int worldWidth = this.getWorld().getWidth();
        int worldHeight = this.getWorld().getHeight();

        if (x >= worldWidth - 10) { // Derecha
            if (mapa == 1) {
                switchWorld(GameControl.mapa2, this, "right");
                mapa = 2;
            } else if (mapa == 3) {
                switchWorld(GameControl.mapa4, this, "right");
                mapa = 4;
            }
        } else if (x <= 0 + 10) { // Izquierda
            if (mapa == 2) {
                switchWorld(GameControl.mapa1, this, "left");
                mapa = 1;
            } else if (mapa == 4) {
                switchWorld(GameControl.mapa3, this, "left");
                mapa = 3;
            }
        } else if (y >= worldHeight - 10) { // Abajo
            if (mapa == 1) {
                switchWorld(GameControl.mapa3, this, "down");
                mapa = 3;
            } else if (mapa == 2) {
                switchWorld(GameControl.mapa4, this, "down");
                mapa = 4;
            }
        } else if (y <= 0 + 10) { // Arriba
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

        // Ajustar posición si está tocando otro enemigo
        if (enemy.isTouching(Enemy.class)) {
            enemy.move(-50);
        }
    }

    public void AnimADM() {
        if (isTouching(Proyectil.class)) {
            Proyectil proyectil = (Proyectil) getOneIntersectingObject(Proyectil.class);
            if (proyectil != null) {
                takeDamage(proyectil.getDamage()); // Reducir la vida según el daño del proyectil
            }
        }
    }

    public void PersecucionControl() {
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

    public boolean shouldBeRemoved() {
        return isDead && deadIndex >= 12; // Indica que el zombie debe ser eliminado si la animación de muerte ha terminado
    }

    public void takeDamage(int damage) {
        vida -= damage;
        if (vida <= 0 && !isDead) {
            morir(); // Iniciar el proceso de muerte si la vida llega a cero o menos
        }
    }

    public void ComprobarColisiones() {
        if (isTouching(Actor.class) && getWorld() != null) {
            Actor colisionado = getOneIntersectingObject(Actor.class);
            if (colisionado != null && !(colisionado instanceof Mira) && !(colisionado instanceof Mina) && !(colisionado instanceof Proyectil)) {
                int dx = getX() - colisionado.getX();
                int dy = getY() - colisionado.getY();

                int retroceso = 15; // Distancia fija de retroceso

                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0) {
                        setLocation(getX() + retroceso, getY());
                    } else {
                        setLocation(getX() - retroceso, getY());
                    }
                } else {
                    if (dy > 0) {
                        setLocation(getX(), getY() + retroceso);
                    } else {
                        setLocation(getX(), getY() - retroceso);
                    }
                }
            }
        }
    }
}
