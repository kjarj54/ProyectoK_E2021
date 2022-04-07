/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.controller;

import cr.ac.una.unaproyectokevinaemanuelv.util.Ballesta;
import cr.ac.una.unaproyectokevinaemanuelv.util.Castillo;
import cr.ac.una.unaproyectokevinaemanuelv.util.Enemigo;
import cr.ac.una.unaproyectokevinaemanuelv.util.Enemigo2;
import cr.ac.una.unaproyectokevinaemanuelv.util.Flecha;
import cr.ac.una.unaproyectokevinaemanuelv.util.HiloMusica;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class NuevaPartidaViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    Canvas lienzo = new Canvas(1000,600);
    GraphicsContext graficos;
    Enemigo enemigo;
    Enemigo2 enemigo2;
    Ballesta ballesta;
    Flecha flecha;
    Castillo castillo;
    ImageView img = new ImageView();
    
    public static HashMap<String, Image> imagenes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializarComponentes();
        cicloJuego();
    }    

    @Override
    public void initialize() {

    }
    
    //inicializa componentes
    public void inicializarComponentes(){
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();
        imagenes = new HashMap<String,Image>();
        cargarImagenes();
        enemigo = new Enemigo(0, 40,"golem", 3,1,"correr");
        enemigo2 = new Enemigo2(0, "correr", 0, 40,"robot", 3);
        ballesta = new Ballesta(800, 0, "ballesta", 0);
        click();
        flecha = new Flecha(830, 65, "flecha", 10);
        botones();
        castillo = new Castillo(10000, 700, -200, "castillo", 0);
    }
    
    //Crear un ciclo para el juego
    public void cicloJuego(){
        AnimationTimer animationTimer = new AnimationTimer(){
            long tiempoInicial = System.nanoTime();
            //Este metodo se ejecuta aprox 60 veces por segundo
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicial)/ 1000000000.0;
                actualizarEstado(t);
                pintar();
            }
        };
        animationTimer.start();//empieza el ciclo de juego
        
    }
    
    //actualiza estados
    public void actualizarEstado(double t){
        enemigo.mover();
        enemigo.calcularFrame(t);
        enemigo2.mover();
        enemigo2.calcularFrame(t); 
        flecha.mover();
        enemigo.verificarColiciones(flecha);
        castillo.verificarColiciones(enemigo);
    }
    
    //carga las imagenes que vamos a necesitar
    public void cargarImagenes(){
       imagenes.put("background",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/Burbujas-Lava-87910.gif",1000,600,false,false));        
       imagenes.put("golem",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/Golem.png"));
       imagenes.put("castillo",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/Castillo.png",300,900,false,false));
       imagenes.put("robot",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/Robot.png"));
       imagenes.put("ballesta",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/Arco.png"));
       imagenes.put("flecha",new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/flecha.png"));

    }
    

    //Pinta en pantalla lo que vayamos a necesitar
    public void pintar(){
        graficos.drawImage(imagenes.get("background"), 0, 0);
        //graficos.drawImage(imagenes.get("castillo"), 700, -200);
        enemigo.pintar(graficos);
        enemigo2.pintar(graficos);
        ballesta.pintar(graficos);
        flecha.pintar(graficos);
        castillo.pintar(graficos);
        if(enemigo.getVida()!=0){
        graficos.setFill(Color.WHITE);
        graficos.fillText("            "+enemigo.getVida(),enemigo.getX()-300, enemigo.getY());            
        }
        if(castillo.getVidaCastillo()!=0){
        graficos.setFill(Color.WHITE);
        graficos.fillText("            "+castillo.getVidaCastillo(),castillo.getX()-500, 40);            
        }
        
    }
    
    public void movimiento(){
      

    }
    
    public void botones(){
        Button boton = new Button("Pausa");
        boton.setId("btnPausar");
        boton.setDefaultButton(true);
        boton.setPrefSize(70,30);
        boton.setLayoutX(105);
        boton.setLayoutY(600);
        boton.setGraphic(new ImageView());
        boton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
            }
            
        });
        root.getStylesheets().add("cr/ac/una/unaproyectokevinaemanuelv/resources/inicioview.css");
        root.getChildren().add(boton);
    }
    
    public void click() {
        
        // Detectar ratón pulsado
        lienzo.setOnMousePressed((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se pulse el ratón
            System.out.println("Ratón pulsado en (x, y): (" +
                    mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
                    flecha.setBandera(false);
                    flecha.setMouseX(mouseEvent.getX());
                    flecha.setMouseY(mouseEvent.getY());
        });
        
        // Detectar ratón soltado
        lienzo.setOnMouseReleased((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se suelte el ratón
            System.out.println("Ratón soltado en (x, y): (" +
                    mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
                flecha.setBandera(true);
  
        });
        
 //        Detectar clic en ratón (pulsado y soltado)
//        lienzo.setOnMouseClicked((MouseEvent mouseEvent) -> {
//        //     Insertar aquí el código a ejecutar cuando se haga clic en el ratón
//            System.out.println("Ratón clicado en (x, y): (" +
//                    mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
//        //     También se puede comprobar sobre qué botón se ha actuado,
//         //     válido para cualquier acción (pressed, released, clicked, etc)
//            if(mouseEvent.getButton() == MouseButton.PRIMARY) {
//                System.out.println("Botón principal");
//                
//            } else if(mouseEvent.getButton() == MouseButton.SECONDARY) {
//                System.out.println("Botón secundario");
//            }
//        });    
    }
}
