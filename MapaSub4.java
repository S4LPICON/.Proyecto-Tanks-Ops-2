import greenfoot.*;

public class MapaSub4 extends Mapas {
    
    private Carro carro1 = new Carro(30);
    private Carro carro2 = new Carro(90);
    private Carro carro3 = new Carro(120);
    
    private Arbol arbol1 = new Arbol();
    
    private TanqueCombus tc1 = new TanqueCombus(90);
    
    private Collision col1 = new Collision(200, 20);
    
    public MapaSub4() { 
        super();
        setBackground("Mapa/MapaSub4.png");
        AniadirObjetos();
    }
    
    public MapaSub4(Tanque awebado) { 
        super();
        setBackground("Mapa/MapaSub1.png");
        addObject(awebado, 500, 500);
    }

    public void AniadirObjetos(){
        
        addObject(carro1, 165, 251);
        addObject(carro2, 408, 261);
        addObject(carro3, 562, 107);
        
        addObject(arbol1, 1074, 108);
        
        addObject(tc1, 362, 630);
        
        addObject(col1, 836, 656);
    }
}