import greenfoot.*;

public class MapaSub2 extends Mapas {
    
    public MapaSub2() { 
        super();
        setBackground("Mapa/MapaSub2.png");
    }
    
    public MapaSub2(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub2.png");
        addObject(awebado, 500, 500);
    }
    
}