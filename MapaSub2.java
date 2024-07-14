import greenfoot.*;

public class MapaSub2 extends Mapas {
    
    private Camion camion1 = new Camion(-45);
    private Camion camion2 = new Camion(45);
    
    private Arbol arbol1 = new Arbol();
    private Arbol arbol2 = new Arbol();
    private Arbol arbol3 = new Arbol();//1124 136
    
    private Casa casa1 = new Casa();
    
    private Metal metal1 = new Metal(30);
    
    
    
    public MapaSub2() { 
        super();
        setBackground("Mapa/MapaSub2.png");
        AniadirObjetos();
    }
    
    public MapaSub2(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub2.png");
        addObject(awebado, 500, 500);
    }
    
    public void AniadirObjetos(){
        addObject(camion1, 254, 158);
        addObject(camion2, 336, 586);
        
        addObject(arbol1, 413, 268);
        addObject(arbol2, 519, 586);
        addObject(arbol3, 865, 364);
        
        addObject(casa1, 1124, 136);
        
        addObject(metal1, 1061, 550);
        
        
    }
}