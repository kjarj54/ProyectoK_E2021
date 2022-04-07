/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import cr.ac.una.unaproyectokevinaemanuelv.controller.NuevaPartidaViewController;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kevin
 */
public class Enemigo2 extends ObjetoJuego {
    private int vida;
    private HashMap<String, Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;

    public Enemigo2(int vida, String animacionActual, int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
        this.vida = vida;
        animaciones = new HashMap<String, Animacion>();
        this.animacionActual = animacionActual;
        inicializarAnimaciones();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }
    
    public void inicializarAnimaciones(){
        
        Rectangle coordenadasCorrer[]={
            new Rectangle(5,183,95,95),
            new Rectangle(99,184,90,89),
            new Rectangle(199,182,90,93),
            new Rectangle(195,184,90,90),
            new Rectangle(388,182,91,94),
            new Rectangle(480,180,97,95),
            new Rectangle(667,186,92,85),
            new Rectangle(751,184,90,92)              
        };
        Rectangle coordenadasAtacar[]={

        };
        
        Rectangle coordenadasMorir[]={
            
        };        
        Animacion animacionCorrer= new Animacion(0.05, coordenadasCorrer);
        Animacion animacionAtacar= new Animacion(0.1, coordenadasAtacar);
        animaciones.put("correr", animacionCorrer);
        animaciones.put("atacar", animacionAtacar); 
        
        
    }
    public void calcularFrame(double t){
       Rectangle coordenadas = animaciones.get("correr").calcularFrameActual(t); 
       this.xImagen =(int) coordenadas.getX();
       this.yImagen =(int) coordenadas.getY();
       this.altoImagen= (int) coordenadas.getWidth();
       this.anchoImagen= (int) coordenadas.getHeight();

    }
    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, x-100,y,100,70);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, x-100,y+100,100,70);
        
    }

    @Override
    public void mover() {
        if(x<=750)
            x+=velocidad;
    
    }
    
}
