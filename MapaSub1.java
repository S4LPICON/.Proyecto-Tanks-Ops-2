import greenfoot.*;

public class MapaSub1 extends Mapas {
    
    private Tanque tanque;
    private Arbol arbol1 =  new Arbol();
    private Arbol arbol2 =  new Arbol();
    private Arbol arbol3 =  new Arbol();
    
    private Caja caja1 = new Caja();
    private Caja caja2 = new Caja();
    private Caja caja3 = new Caja();
    
    private Antena antena1;
    private Generador gen1;
    
    
    public MapaSub1() { 
        super();
        //arbol1 =  new Arbol();       
        antena1 = new Antena();
        gen1 = new Generador();
        setBackground("Mapa/MapaSub1.png");
        AniadirObjetos();
    }
    
    public MapaSub1(Tanque awebado) { 
        super();
        tanque = awebado;
        setBackground("Mapa/MapaSub1.png");
        addObject(awebado, 150, 150);
        addObject(arbol1, 500, 500);
    }
    
    public void AniadirObjetos(){
        addObject(arbol1, 254, 158);
        addObject(arbol2, 336, 586);
        addObject(arbol3, 938, 231);
        
        addObject(caja1, 332, 288);
        addObject(caja2, 381, 225);
        addObject(caja3, 413, 296);
    }
}

