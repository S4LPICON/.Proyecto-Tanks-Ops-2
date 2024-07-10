import greenfoot.*;

public class MapaSub1 extends Mapas {
    
    private Tanque tanque;
    private Arbol arbol1;
    private Rio rio1;
    private Antena antena1;
    private Generador gen1;
    
    
    public MapaSub1() { 
        super();
        arbol1 =  new Arbol();       
        antena1 = new Antena();
        rio1 = new Rio(-45);
        gen1 = new Generador();
        setBackground("Mapa/MapaSub1.png");
        AniadirObjetos();
    }
    
    public MapaSub1(Tanque awebado) { 
        super();
        tanque = awebado;
        arbol1 =  new Arbol(); 
        setBackground("Mapa/MapaSub1.png");
        addObject(awebado, 150, 150);
        addObject(arbol1, 500, 500);
    }
    
    public void AniadirObjetos(){
        //addObject(arbol1, 500, 500);
        addObject(antena1, 550, 150);
        //addObject(rio1, 500, 500);
        addObject(gen1, 844, 74);
    }
}

