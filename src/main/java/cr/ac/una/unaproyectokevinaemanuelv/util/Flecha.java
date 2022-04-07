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
public class Flecha extends ObjetoJuego{
    boolean bandera;
    double mouseX;
    double mouseY;
    int daño=1; 

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }
    
    public boolean getBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    public Flecha(int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), x,y,100,20);
        graficos.setStroke(Color.RED);
        graficos.strokeRect(x,y,100,20);
    }
    public Rectangle obtenerRectangulo(){
        return new Rectangle(x,y,100,20);
        
    }
    @Override
    public void mover() {
        
        //
        if(bandera==true){
            if(x>=mouseX){
                x-=velocidad;
                
            }
            if(y<=mouseY){
                y+=velocidad;
                
            }
        }else{
            x=830;
            y=65;
        }

        //System.out.println(bandera);
    }
    
}
