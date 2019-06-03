package proyectodiagrama;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BLANSKPC
 */
public class EntradaSalidaController implements Initializable {

    @FXML
    private Button btnEntrada;
    @FXML
    private Button btnSalida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void entrada(ActionEvent event) {
        ProyectoDiagramaController.bentrada = false;
        ProyectoDiagramaController.baceptar = true;
        Stage stage = (Stage) btnEntrada.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void salida(ActionEvent event) {
        ProyectoDiagramaController.bentrada = true;
        ProyectoDiagramaController.baceptar = true;
        Stage stage = (Stage) btnSalida.getScene().getWindow();
        stage.close();
    }
    
}
