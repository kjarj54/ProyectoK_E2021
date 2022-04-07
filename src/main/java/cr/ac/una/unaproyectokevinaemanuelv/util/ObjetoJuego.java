/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author kevin
 */
public abstract class ObjetoJuego {
    protected int x;
    protected int y;
    protected String nombreImagen;
    protected int velocidad;
    protected int ancho;
    protected int alto;

    public ObjetoJuego(int x, int y, String nombreImagen, int velocidad) {
        this.x = x;
        this.y = y;
        this.nombreImagen = nombreImagen;
        this.velocidad = velocidad;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public abstract void pintar(GraphicsContext graficos);
    public abstract void mover();
    
}
