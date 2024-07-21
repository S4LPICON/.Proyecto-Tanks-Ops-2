import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    private String action;
    private Tanque xd;
    
    private int cooldownStep = 0;
    private int cooldownmax = 300;
    
    GreenfootImage nimage;
    
    public Item(Tanque juga, String img, String act1ion){
        this.nimage = new GreenfootImage(img);
        setImage(nimage);
        this.action = act1ion;
        this.xd = juga;
    }
    
    public Item(String img){
        this.nimage = new GreenfootImage(img); // Cargar una imagen
        nimage.scale(1345, 675); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
    }
    
    
    public void act()
    {
        if(isTouching(Tanque.class)){
            if(action == "salud"){
                xd.aumentarVida(20);
            }else if(action == "mun"){
                xd.setMuniToMax();
            }else if(action == "arma"){
                //logica para darle una nueva arma al jugador aun no implementada
            }
            getWorld().removeObject(this);
        }
        cooldownStep++;
        if(cooldownStep > (cooldownmax/2) ){
            nimage.setTransparency(cooldownStep-46);
        }
        if(cooldownStep > cooldownmax){
            getWorld().removeObject(this);
        }
    }
}
