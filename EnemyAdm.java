import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;


public class EnemyAdm extends Actor
{
    private ArrayList<Enemy> listEnemy = new ArrayList<>();
    private int enemys = 500; // Máximo de zombies que pueden haber en el mundo
    private World name;
    private Tanque player;
    
    
    private boolean juegoIniciado = false;
    public static int ronda ;
    private int baseCantidad = 1; // Cantidad base de enemigos por ronda
    private int factorIncremento = 1; // Factor de incremento de enemigos por ronda
    private int vidaBase = 25;
    private int dañoBase = 10;
    
    private boolean coolDownRonda = false;
    private int rondasCooldown = 0;
    
    public EnemyAdm(Tanque player){
        this.player = player;
        ronda =1; // podria modificar si quiero empezar en otra ronda
    }
    
    public void act() {
        
        if(listEnemy.size() <1){
            coolDownRonda = true;
            iniciarJuego();
        }
        
        Iterator<Enemy> iterator = listEnemy.iterator();
        
        //encargado de mover a todos los zombies 
        while (iterator.hasNext()) {
            Enemy x = iterator.next();
            if (x != null) {
                x.act();
                if (x.shouldBeRemoved()) { // Agrega una condición para eliminar enemigos
                    iterator.remove();
                    getWorld().removeObject(x);
                }
            }
        }
    }
    
    public void iniciarJuego(){
        if (coolDownRonda) {
            rondasCooldown++;
            if (rondasCooldown >= 240) {//240
                int cantidadEnemigos = baseCantidad + (ronda + factorIncremento);
                int vidaEnemigos = vidaBase + (ronda * 2); // Incremento de vida por ronda
                int dañoEnemigos = dañoBase + ronda ; // Incremento de daño por ronda
                ronda++;
                for (int i = 0; i < cantidadEnemigos; i++) {
                    Zombie enemigo = new Zombie(player, this, vidaEnemigos, 1);
                    enemigo.setDanio(dañoEnemigos); // Método para establecer el daño del enemigo
                    spawnRandomZombie(enemigo);
                    listEnemy.add(enemigo);
                
                }
            }
        
        }
    }
    private void spawnRandomZombie(Zombie enemigo) {
        World name = getWorld();
        if (listEnemy.size() < enemys) {
            int minX = 200; // valor mínimo
            int maxX = 1200; // valor máximo
            
            int minY = 120; // valor mínimo
            int maxY = 550; // valor máximo
            int randomNum = Greenfoot.getRandomNumber(maxX - minX + 1) + minX;
            
            int randomCorner = Greenfoot.getRandomNumber(4); // 0: arriba izquierda, 1: arriba derecha, 2: abajo izquierda, 3: abajo derecha
            int rx = Greenfoot.getRandomNumber(maxX - minX + 1) + minX, ry = Greenfoot.getRandomNumber(maxY - minY + 1) + minY;
            int x = 0, y = 0;
            switch(randomCorner) {
                case 0: // Esquina arriba izquierda
                    x = minX;
                    y = ry;
                    break;
                case 1: // Esquina arriba derecha
                    x = maxX;
                    y = ry;
                    break;
                case 2: // Esquina abajo izquierda
                    x = rx;
                    y = maxY;
                    break;
                case 3: // Esquina abajo derecha
                    x = maxX;
                    y = ry;
                    break;
            }
            
            name.addObject(enemigo, x, y); // Agrega el zombie al mundo
        }
    }
    
    public void removeEnemy(Enemy zombie) {
        getWorld().removeObject(zombie); // Elimina el zombie del mundo
        listEnemy.remove(zombie); // Elimina el zombie de la lista
    }
}
