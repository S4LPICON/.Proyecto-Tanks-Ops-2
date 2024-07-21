import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BarraIndicadora extends Actor
{
    GreenfootImage imagen = new GreenfootImage(114, 15);
    //GreenfootImage imagenVida = new GreenfootImage(50, 10);
    int vida;
    int vidaMax;
    int dañoRecibido;
    int center;
    private Color color;
    public BarraIndicadora (int x, Actor M){
        
        //recibir los coolores como parametros
        vida=x;
        vidaMax=x;
        dañoRecibido=0;
        this.color = Color.RED;
        imagen.setColor(Color.RED);
        imagen.fillRect(0, 0,114, 15);
        setImage(imagen);
    }
    
    public BarraIndicadora (int x, Actor M, Color color){
        
        //recibir los coolores como parametros
        vida=x;
        vidaMax=x;
        dañoRecibido=0;
        this.color = color;
        imagen.setColor(color);
        imagen.fillRect(0, 0,114, 15);
        setImage(imagen);
    }
    
    public void actualizarBarra(){
        int ancho = (int)((dañoRecibido / (double)vidaMax) * imagen.getWidth());
        if (dañoRecibido>=vidaMax) {
         ancho=114;
         vida=0;
         center=20;
        }
        imagen.clear();
        
        imagen.setColor(color);
        imagen.fillRect(0, 0,114, 15);
        
        imagen.setColor(Color.WHITE);
        imagen.fillRect(114-ancho, 0, 114, 15);
        setImage(imagen);
    }
    public void fijar (int x, int y){
        setLocation(x, y-35);
    }
    public void actualizarVida(int x){
        this.vida=x;
        this.dañoRecibido=vidaMax-vida;
    }
}