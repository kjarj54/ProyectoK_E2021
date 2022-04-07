/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.unaproyectokevinaemanuelv.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class LobbyViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnIniciarNuevaPartida;
    @FXML
    private JFXButton btnCargarPartida;
    @FXML
    private JFXButton btnTutoria;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private BorderPane root;

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
    private void onActionBtnIniciarNuevaPartida(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("NuevaPartidaView");
        getStage().close();
    }

    @FXML
    private void onActionBtnCargarPartida(ActionEvent event) {
    }

    @FXML
    private void onActionBtnTutorial(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("TutorialView", getStage(), false);
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
        getStage().close();
    }
    
}
