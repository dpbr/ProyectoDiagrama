package proyectodiagrama;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BLANSKPC
 */
public class PopUpController implements Initializable {
    @FXML
    private TextField tfNombre;
    @FXML
    private Button btnAceptar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 

    @FXML
    private void aceptar(ActionEvent event) {
        ProyectoDiagramaController.baceptar = true;
        ProyectoDiagramaController.fcambiar.setNombre(tfNombre.getText());
        Stage stage = (Stage) btnAceptar.getScene().getWindow();
        stage.close();
    }
}
