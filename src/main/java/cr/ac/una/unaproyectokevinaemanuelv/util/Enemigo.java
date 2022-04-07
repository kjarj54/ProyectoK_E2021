/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import cr.ac.una.unaproyectokevinaemanuelv.controller.NuevaPartidaViewController;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kevin
 */
public class Enemigo extends ObjetoJuego {
    private int vida;
    private HashMap<String, Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;
    private int daño=1;

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    
    int  r=(int) (Math.random()*300+100);
    int  g=(int) (Math.random()*300+100);
    int  d=(int) (Math.random()*300+100);
    int  y1=(int) (Math.random()*300+100);
    int  y2=(int) (Math.random()*300+100);
    int  y3=(int) (Math.random()*300+100);
    int  y4=(int) (Math.random()*300+100);
    int  y5=(int) (Math.random()*300+100);
    int  y6=(int) (Math.random()*300+100);
    int  y7=(int) (Math.random()*300+100);
    int  y8=(int) (Math.random()*300+100);
    int  y9=(int) (Math.random()*300+100);


int t,v1,v2,v3,v4,v5;


    public Enemigo(int x, int y, String nombreImagen, int velocidad,int vida,String animacionActual) {
        super(x, y, nombreImagen, velocidad);
        this.vida = vida;
        this.animacionActual= animacionActual;
        animaciones = new HashMap<String, Animacion>();
        inicializarAnimaciones();
        
    }
    
    public String getAnimacionActual() {
        return animacionActual;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void inicializarAnimaciones(){
        
        Rectangle coordenadasCorrer[]={
            new Rectangle(46,779,158,173),
            new Rectangle(215,779,158,173),
            new Rectangle(396,779,158,175),
            new Rectangle(566,779,158,174),
            new Rectangle(769,779,158,173),
            new Rectangle(958,779,158,173),
            new Rectangle(1140,779,158,163),
            new Rectangle(1298,779,158,160),
            new Rectangle(1449,779,158,155),
            new Rectangle(1588,779,158,168),
            new Rectangle(1747,779,158,160)
                
        };
        Rectangle coordenadasAtacar[]={
           new Rectangle(1103,308,180,182),
           new Rectangle(61,307,170,185),
           new Rectangle(228,307,161,174),
           new Rectangle(413,296,180,182),
           new Rectangle(594,297,180,178),
           new Rectangle(766,301,170,170),
           new Rectangle(931,307,162,182),
           new Rectangle(1103,308,180,182),
        };
        
        Rectangle coordenadasMorir[]={
            
        };        
        Animacion animacionCorrer= new Animacion(0.05, coordenadasCorrer);
        Animacion animacionAtacar= new Animacion(0.1, coordenadasAtacar);
        animaciones.put("correr", animacionCorrer);
        animaciones.put("atacar", animacionAtacar); 
        
        
    }
    
    public void calcularFrame(double t){
       Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
       
       this.xImagen =(int) coordenadas.getX();
       this.yImagen =(int) coordenadas.getY();
       this.altoImagen= (int) coordenadas.getWidth();
       this.anchoImagen= (int) coordenadas.getHeight();

    }
    //se esjecuta por cada iteracion del juego
    @Override
    public void pintar(GraphicsContext graficos) {      
        r=y;
        if(vida != 0){
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, t-300,y,80,50);
        }
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, t-300,d,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v1-500,g,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v1-500,y1,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v2-750,y2,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v3-1000,y3,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v4-1300,y4,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v5-2000,y5,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v5-2000,y6,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v5-2000,y7,80,50);
        graficos.drawImage(NuevaPartidaViewController.imagenes.get(nombreImagen), xImagen, yImagen,anchoImagen,altoImagen, v5-2000,y8,80,50);
        
        if(x>=700){
            setAnimacionActual("atacar");
        }
        
    }
    public Rectangle obtenerRectangulo(){
        if(vida!= 0){
            return new Rectangle(t-300,y,10,50);
        }
        
        return new Rectangle();
    }
    public Rectangle obtenerRectangulo2(){
        if(vida!= 0){
            return new Rectangle(t-300,y,90,50);
        }
        
        return new Rectangle();
    }   
    
    public void verificarColiciones(Flecha flecha){
        if(this.obtenerRectangulo().getBoundsInLocal().intersects(flecha.obtenerRectangulo().getBoundsInLocal())){
            this.vida -= flecha.getDaño();
            flecha.setX(830);
            flecha.setY(65);
            flecha.setMouseX(830);
            flecha.setMouseY(60);
            //System.out.println("pito chocaron");
        }
    }
    
    
    //se esjecuta por cada iteracion del juego
    @Override
    public void mover() {
        if(x<=920){
            x+=velocidad;
        }
        if( t<950){
            t=t+velocidad;    
        }
        if(v1<1100){
            v1=v1+velocidad;   
        }
        if(v2<1350){
            v2=v2+velocidad;
        }
        if(v3<1600){
            v3=v3+velocidad;
        }
        if(v4<1900){
            v4=v4+velocidad;
        }
        if(v5<2600){
            v5=v5+velocidad;
        }
    }
    
}
