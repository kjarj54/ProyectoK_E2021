/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import cr.ac.una.unaproyectokevinaemanuelv.controller.NuevaPartidaViewController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kevin
 */
public class Castillo extends ObjetoJuego{
    private int vidaCastillo;

    public Castillo(int vidaCastillo, int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
        this.vidaCastillo = vidaCastillo;
        this.ancho = (int)NuevaPartidaViewController.imagenes.get("castillo").getWidth();
        this.alto = (int)NuevaPartidaViewController.imagenes.get("castillo").getHeight();
    }

    public int getVidaCastillo() {
        return vidaCastillo;
    }

    public void setVidaCastillo(int vidaCastillo) {
        this.vidaCastillo = vidaCastillo;
    }
    
    @Override
    public void pintar(GraphicsContext graficos) {
        if(vidaCastillo!= 0){
            graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), this.x, this.y);
        }
    }
    
    public Rectangle obtenerRectangulo(){
        if(vidaCastillo!= 0){
           return new Rectangle(this.x, this.y,300,800);
        }
        return new Rectangle();
        
    }
    public void verificarColiciones(Enemigo enemigo){
        if(this.obtenerRectangulo().getBoundsInLocal().intersects(enemigo.obtenerRectangulo2().getBoundsInLocal())){
            this.vidaCastillo -= enemigo.getDaño();
        }
    }
    @Override
    public void mover() {
        
    }
    
}
