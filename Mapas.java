import greenfoot.*;

public class Mapas extends World
{
    public Mapas()
    {    
        super(1300, 675, 1); 
    }
    
    
    //aniade los actores al mundo
    public void aniadir(Tanque player){
        addObject(player, -1, -1);
    }
    public void aniadir(Enemy enemy){
        addObject(enemy, -1, -1);
    }
    
    //setea la pocision del jugador con respecto a la direccion de donde venia
    public void setPlayerPosition(Tanque player, String direction) {
        if (direction.equals("left")) {
            player.setLocation(getWidth() - 1, player.getY());
        } else if (direction.equals("right")) {
            player.setLocation(1, player.getY());
        } else if (direction.equals("up")) {
            player.setLocation(player.getX(), getHeight() - 1);
        } else if (direction.equals("down")) {
            player.setLocation(player.getX(), 1);
        }
    }
    
    /*setea la pocision del jenemigo con respecto a la direccion de donde venia y con unas cords random para envitar que los
    salgan en una fila 
    */
     
    public void setEnemyPosition(Enemy enemy, String direction) {
        int randX = Greenfoot.getRandomNumber(1340);
        int randY = Greenfoot.getRandomNumber(670);
        if (direction.equals("left")) {
            enemy.setLocation(getWidth() - 11, randY);
        } else if (direction.equals("right")) {
            enemy.setLocation(11, randY);
        } else if (direction.equals("up")) {
            enemy.setLocation(randX, getHeight() - 11);
        } else if (direction.equals("down")) {
            enemy.setLocation(randX, 11);
        }
    }
}
