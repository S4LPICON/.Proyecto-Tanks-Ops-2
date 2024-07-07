import greenfoot.*;

public class MapaSub1 extends Mapas {
    
    public MapaSub1() { 
        super();
        setBackground("Mapa/MapaSub1.png");
    }
    
    public MapaSub1(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub1.png");
        addObject(awebado, 500, 500);
    }
}

