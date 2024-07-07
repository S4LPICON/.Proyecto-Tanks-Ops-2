import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase base para todas las armas.
 * 
 * @version 1.0
 */
public abstract class Arma extends Actor {
    private int municion;

    public Arma(int municionInicial) {
        this.municion = municionInicial;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
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

    protected abstract void crearProyectil();
}
