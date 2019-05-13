/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author BLANSKPC
 */
public class CondicionController implements Initializable {

    @FXML
    private Button btnVerdadero;
    @FXML
    private Button btnFalso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verdadero(ActionEvent event) {
        ProyectoDiagramaController.bverdaderofalso = true;
    }

    @FXML
    private void falso(ActionEvent event) {
        ProyectoDiagramaController.bverdaderofalso = false;
    }
    
}
