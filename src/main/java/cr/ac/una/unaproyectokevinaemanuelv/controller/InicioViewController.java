/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.unaproyectokevinaemanuelv.util.FlowController;
import cr.ac.una.unaproyectokevinaemanuelv.util.HiloMusica;
import cr.ac.una.unaproyectokevinaemanuelv.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class InicioViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnIniciar;
    @FXML
    private JFXButton btnAcercade;
    @FXML
    private JFXTextField txtUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
    }

    @FXML
    private void OnActionBtnCancelar(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).close();
        
    }

    @FXML
    private void OnActionBtnIniciar(ActionEvent event) {
        
        try {

            if (txtUsuario.getText() == null || txtUsuario.getText().isEmpty()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación del Usuario", getStage(), "Es necesario digitar un usuario para ingresar al juego.");
             
            }  else {
                    
                    FlowController.getInstance().goViewInWindow("LobbyView");
                    getStage().close();
                    
            }
        } catch (Exception ex) {
            Logger.getLogger(InicioViewController.class.getName()).log(Level.SEVERE, "Error ingresando.", ex);
        }

        
    }       

    @FXML
    private void OnActionBtnAcercaDe(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("AcercaView",getStage(),false);

    }
    
}
