/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;


import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kevin
 */
public class Animacion {
    private double duracion;
    private Rectangle coordenadas[];

    public Animacion(double duracion,Rectangle coordenadas[]) {
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Rectangle[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Rectangle[] coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public Rectangle calcularFrameActual(double t){
        int cantidadFrames = this.coordenadas.length;
        int indiceFrameActual = (int) (t%(cantidadFrames*duracion)/duracion) ;
        return coordenadas[indiceFrameActual];
    }

}
