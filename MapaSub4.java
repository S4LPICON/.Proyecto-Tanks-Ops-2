import greenfoot.*;

public class MapaSub4 extends Mapas {
    
    public MapaSub4() { 
        super();
        setBackground("Mapa/MapaSub4.png");
    }
    
    public MapaSub4(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub1.png");
        addObject(awebado, 500, 500);
    }

}