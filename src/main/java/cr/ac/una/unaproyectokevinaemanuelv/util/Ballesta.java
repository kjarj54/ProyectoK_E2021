/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import cr.ac.una.unaproyectokevinaemanuelv.controller.NuevaPartidaViewController;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 *
 * @author kevin
 */
public class Ballesta extends ObjetoJuego{
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;

    public Ballesta(int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
    }
    
    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), x,y,150,150);
        
    }
    @Override
    public void mover() {
        
    }
    
}
