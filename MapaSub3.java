import greenfoot.*;

public class MapaSub3 extends Mapas {
    
    public MapaSub3() { 
        super();
        setBackground("Mapa/MapaSub3.png");
    }
    
    
    public MapaSub3(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub3.png");
        addObject(awebado, 500, 500);
    }
}