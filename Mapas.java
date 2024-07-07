import greenfoot.*;

public class Mapas extends World
{

    public Mapas()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1345, 675, 1); 
    }
    
    public void aniadir(Tanque playera){
        addObject(playera, -1, -1);
    }
    
    public void setPlayerPosition(Tanque player, String direction) {
        showText("jous", 700, 500);
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
    
   
}
