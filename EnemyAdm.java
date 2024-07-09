import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class EnemyAdm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyAdm extends Actor
{
    private ArrayList<Enemy> listEnemy = new ArrayList<>();
    private int maxZombies = 15; // Máximo de zombies activos
    private World name;
    private Tanque player;
    
    public EnemyAdm(Tanque playera){
        player = playera;
    }
    
    public void act() {
        spawnRandomZombie();
        
        Iterator<Enemy> iterator = listEnemy.iterator();
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
    
    private void spawnRandomZombie() {
        World name = getWorld();
        if (listEnemy.size() < maxZombies) {
            int randomCorner = Greenfoot.getRandomNumber(4); // 0: arriba izquierda, 1: arriba derecha, 2: abajo izquierda, 3: abajo derecha
            int rx = Greenfoot.getRandomNumber(1346), ry = Greenfoot.getRandomNumber(675);
            int x = 0, y = 0;
            switch(randomCorner) {
                case 0: // Esquina arriba izquierda
                    x = 50;
                    y = ry;
                    break;
                case 1: // Esquina arriba derecha
                    x = name.getWidth() - 50;
                    y = ry;
                    break;
                case 2: // Esquina abajo izquierda
                    x = rx;
                    y = name.getHeight() - 50;
                    break;
                case 3: // Esquina abajo derecha
                    x = name.getWidth() - 50;
                    y = rx - 50;
                    break;
            }
            
            Enemy zombie = new Enemy(player, this); // Crea un nuevo zombie
            name.addObject(zombie, x, y); // Agrega el zombie al mundo
            listEnemy.add(zombie); // Agrega el zombie a la lista
        }
    }
    
    public void removeEnemy(Enemy zombie) {
        getWorld().removeObject(zombie); // Elimina el zombie del mundo
        listEnemy.remove(zombie); // Elimina el zombie de la lista
        // Genera un nuevo zombie para mantener el máximo de 15 zombies activos
        spawnRandomZombie();
    }
}
