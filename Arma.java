import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase base para todas las armas.
 * 
 * @version 1.0
 */
public abstract class Arma extends Actor {
    private int municion;
    private int bombas;

    public Arma(int municionInicial, int bombasinicial) {
        this.municion = municionInicial;
        this.bombas = bombasinicial;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public int getBombas() {
        return bombas;
    }

    public void setBombas(int bombas) {
        this.bombas = bombas;
    }
    
    public void recargar(int cantidad) {
        this.municion += cantidad;
    }

    public void disparar() {
        if (municion > 0) {
            municion--;
            crearProyectil();
        }
    }
    public void bomba() {
        if (bombas > 0) {
            bombas--;
            crearBomba();
        }
    }

    protected abstract void crearProyectil();
    protected abstract void crearBomba();
}
