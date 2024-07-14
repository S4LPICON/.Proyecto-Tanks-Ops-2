import greenfoot.*;

public class MapaSub3 extends Mapas {
    
    private Casa casa1 = new Casa();
     
    private Arbol arbol1 = new Arbol();
    private Arbol arbol2 = new Arbol();
    
    private CarroMilitar carmil = new CarroMilitar(0);
    
    private Camion camion1 = new Camion(12);
    
    private Caja caja1 = new Caja();
    
    
    public MapaSub3() { 
        super();
        setBackground("Mapa/MapaSub3.png");
        AniadirObjetos();
    }
    
    
    public MapaSub3(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub3.png");
        addObject(awebado, 500, 500);
    }
    
    public void AniadirObjetos(){
        addObject(casa1, 218, 545);
        
        addObject(arbol1, 694, 570);
        addObject(arbol2, 1226, 141);
        
        addObject(carmil, 150, 318);
        
        addObject(camion1, 1005, 130);
        
        addObject(caja1, 1036, 611);
    }
}