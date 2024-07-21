import greenfoot.*;

public class Tanque extends Actor {
    private int speed = 5;
    private int vida =100;
    private int escudo = 75;
    private int puntuacion = 0;
    private EnemyAdm admEnemy =new EnemyAdm(this);
    private Canion canion;
    private LanzaLlamas lanzallamas;
    private Escopeta escopeta;
    private HUID huid;
    private TextBoxManager txtBox;
    
    private int kills =0;
    private boolean isdead = false;
    
    private GreenfootSound moveSound = new GreenfootSound("tankavanzando.wav");//
    private boolean isPlaying = false;
    
    private boolean cooldownDeltaAttack = false;
    private int cooldownAttackTime =0;
    private int cooldownAttack=(60 * 10); // 60 = 1seg
    
    private boolean cooldownEscudo = false;
    private int cooldownTime =0;
    private int cooldown=120; // 60 = 1seg
    private int cantAumento = 10; //cantidad que se le suma al jugador cada cierto tiempo
    private int escudoMax = escudo;
    private int vidaMax = vida;
    
    private BarraIndicadora barravida = new BarraIndicadora(vida, this);
    private BarraIndicadora barraescudo = new BarraIndicadora(escudo, this, Color.LIGHT_GRAY);
    
    private MunicionesGuns muni = new MunicionesGuns();
    private MunicionesBombs munib = new MunicionesBombs();
    private Puntuacion puntos = new Puntuacion();
    
    public Tanque(String imagen) {
        GreenfootImage nimage = new GreenfootImage(imagen); // Cargar una imagen
        nimage.scale(90, 50); // Escalar la imagen a nuevas dimensiones
        setImage(nimage);
        txtBox = new TextBoxManager();
        canion = new Canion(this,txtBox, 120,9);
        huid = new HUID();
        moveSound.setVolume(50);
    }
    
    public Tanque(String imagen, Canion arma) {
        setImage(imagen);
        txtBox = new TextBoxManager();
        canion = arma;
        huid = new HUID();
    }
    
    public Tanque(String imagen, LanzaLlamas arma) {
        setImage(imagen);
        txtBox = new TextBoxManager();
        lanzallamas = new LanzaLlamas(this,txtBox, 500, 8);
        huid = new HUID();
    }
    
    public Tanque(String imagen, Escopeta arma) {
        setImage(imagen);
        txtBox = new TextBoxManager();
        escopeta = new Escopeta(this,txtBox, 98, 80);
        huid = new HUID();
    }
    
    public Tanque(String imagen, int velocidad) {
        this.speed = velocidad;
        setImage(imagen);
        txtBox = new TextBoxManager();
        canion = new Canion(this,txtBox, 50,8);
        huid = new HUID();
    }

    public void aumentarkills(){
        this.kills++;
    }
    
    public void act() {
        vefMuerte();
        if(!isdead){
            mover();
            getRotation();
            vefMuerte();
            GameControl.checkBorders();
            ComprobarColisiones();
            recuperarEscudoCada();
            //MostrarInfoEnPantalla(); // opcion util para el desarrollo
            cooldownUltimoAtaque();
        }
        
    }
    
    public void setMuniToMax(){
        if(canion != null){
            canion.munMax();
        }else if(lanzallamas != null){
            lanzallamas.munMax();
        }else if(escopeta != null){
            escopeta.munMax();
        }
    }
    
    public void vefMuerte(){
        if(this.vida <= 0){
            // muere el jugador
            isdead = true;
            moveSound.stop();
            Item a = new Item("gameover.png");
            getWorld().addObject(a, 675, 337);
            getWorld().showText("Has matado "+ this.kills + " Zombies", 675, 500);
            getWorld().showText("Tu Puntage fue de "+ this.puntuacion, 675, 550);
            getWorld().showText("Has sobrevivido "+ EnemyAdm.ronda + " rondas.", 675, 600);
            Greenfoot.stop();
        }
        if(this.vida <= 0 && isdead){
            Greenfoot.playSound("gameover.mp3");
        }
    }
    
    private void MostrarInfoEnPantalla(){
        getWorld().showText("esc "+escudo,300,500);
        getWorld().showText("vid "+vida,600,500);
        getWorld().showText("coolEsc"+cooldownEscudo,800,500);
        getWorld().showText("escmax"+escudoMax,1000,500);
        getWorld().showText("timer "+cooldownAttackTime,20,400);
        getWorld().showText("coolattac"+cooldownDeltaAttack,20,500);
    }
    
    public void recuperarEscudoCada(){
        if(!cooldownEscudo && !cooldownDeltaAttack && escudo < 75){
            aumentarEscudo(cantAumento);
            cooldownTime =0;
            cooldownEscudo=true;
        }else if(cooldownTime >cooldown){
            cooldownEscudo=false;
        }else{
            cooldownTime++;
        }
        
    }
    
    public void aumentarEscudo(int cant){
        if(escudo < escudoMax - cant){
            this.escudo += cant;
        }else{
            this.escudo += (escudoMax - escudo);
        }
        
        barraescudo.actualizarVida(escudo);
        barraescudo.actualizarBarra();
    }
    
    public void cooldownUltimoAtaque(){
        if(!cooldownDeltaAttack){
            cooldownAttackTime =0;
        }else if(cooldownAttackTime >cooldownAttack){
            cooldownDeltaAttack=false;
        }else{
            cooldownAttackTime++;
        }
    }
    
    public void aumentarVida(int cant){
        if(vida < vidaMax - cant){
            this.vida += cant;
        }else{
            this.vida += (vidaMax - vida);
        }
        barravida.actualizarVida(vida);
        barravida.actualizarBarra();
    }
    
    public void quitarVida(int cant){
        cooldownAttackTime=0;
        cooldownDeltaAttack=true;
        this.vida -= cant;
        barravida.actualizarVida(vida);
        barravida.actualizarBarra();
        
    }
    public void quitarEscudo(int cant){
        cooldownAttackTime=0;
        cooldownDeltaAttack=true;
        this.escudo -= cant;
        barraescudo.actualizarVida(escudo);
        barraescudo.actualizarBarra();
    }
    public int getEscudo(){
        return this.escudo;
    }
    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public void setPuntuacion(int puntos){
        this.puntuacion += puntos;
    }
    
    private void mover() {
        if (Greenfoot.isKeyDown("w")) {
            move(speed);
            if (!isPlaying && !isdead) {
                moveSound.playLoop(); // Reproduce el sonido en loop
                isPlaying = true;
            }
        } else if(Greenfoot.isKeyDown("s")){
            move(-speed);
            if (!isPlaying && !isdead) {
                moveSound.playLoop(); // Reproduce el sonido en loop
                isPlaying = true;
            }
        } else {
            if (isPlaying) {
                moveSound.stop(); // Detiene el sonido
                isPlaying = false;
            }
        }
        
        if (Greenfoot.isKeyDown("a")) {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("d")) {
            turn(5);
        }
        if(canion != null){
            getWorld().addObject(canion, getX(), getY());
        }
        pocisionArma();
    }
    
    public void pocisionArma(){
        if(canion != null){
            canion.setLocation(getX(), getY());
        }else if(lanzallamas != null){
            lanzallamas.setLocation(getX(), getY());
        }else if(escopeta != null){
            escopeta.setLocation(getX(), getY());
        }
    }
    
    public void addedToWorld(World world) {
        if(canion != null){
            getWorld().addObject(canion, getX(), getY());
        }else if(lanzallamas != null){
            getWorld().addObject(lanzallamas, getX(), getY());
        }else if(escopeta != null){
            getWorld().addObject(escopeta, getX(), getY());
        }
        
        getWorld().addObject(admEnemy, -5, -5);  // Agrega el crosshair al mundo, ajusta la posición según sea necesario
        getWorld().addObject(huid, 94, 62);
        getWorld().addObject(muni, 1264, 600);
        getWorld().addObject(munib, 1264, 650);
        getWorld().addObject(puntos, 74, 645);
        getWorld().addObject(txtBox, 0, 0);
        
        getWorld().addObject(barravida, 109, 22);
        getWorld().addObject(barraescudo, 109, 55);
    }
    
    
    public void ComprobarColisiones() {
        Actor colisionado=getOneIntersectingObject(Construccion.class);
        
        if( isTouching(Extra.class)) {
        colisionado = getOneIntersectingObject(Extra.class);
        }
        
        if (colisionado != null) {
            int dx = getX() - colisionado.getX();
            int dy = getY() - colisionado.getY();
            
            int retroceso = 5; // Distancia fija de retroceso
            
            // Determinar la dirección de la colisión
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    setLocation(getX() + retroceso, getY());
                } else {
                    // Colisión desde la derecha
                    setLocation(getX() - retroceso, getY());
                }
            } else {
                if (dy > 0) {
                    // Colisión desde arriba
                    setLocation(getX(), getY() + retroceso);
                } else {
                    // Colisión desde abajo
                    setLocation(getX(), getY() - retroceso);
                }
            }
        }
    }
}
