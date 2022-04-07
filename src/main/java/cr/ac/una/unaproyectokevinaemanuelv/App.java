package cr.ac.una.unaproyectokevinaemanuelv;

import cr.ac.una.unaproyectokevinaemanuelv.util.FlowController;
import cr.ac.una.unaproyectokevinaemanuelv.util.HiloMusica;
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
      FlowController.getInstance().InitializeFlow(stage, null);
        stage.getIcons().add(new Image("cr/ac/una/unaproyectokevinaemanuelv/resources/kisspng-dragon-city-wallpaper-dragon-png-pic-5a7977c70e0561.0034626715179099590574.png"));
        stage.setTitle("UNA PROYECTO");
        FlowController.getInstance().goViewInWindow("InicioView");     
        System.out.println("Después de la canción");
    }


    public static void main(String[] args) {
        launch();

    }

}