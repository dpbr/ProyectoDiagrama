/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author BLANSKPC
 */
public interface CambioDeVentanas {
    /**
     * metodo que se encarga de emerger una ventana nueva
     * @param resource 
     */
    static void newVentana(URL resource) throws IOException{
        try{
            Stage stage= new Stage();
            FXMLLoader fxmlLoader= new FXMLLoader(resource);
            Parent root1=(Parent)fxmlLoader.load();
            stage.initStyle(StageStyle.UTILITY);//hace que no se pueda minimizar ni maximizar la nueva ventana
            stage.initModality(Modality.APPLICATION_MODAL);//hace que no se pueda clickear la ventana de fondo
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }
        catch(Exception ex){
            System.out.println("Cant load new window");
            
        }
    }
    static void newVentana2(URL resource) throws IOException{
        try{
            Stage stage= new Stage();
            FXMLLoader fxmlLoader= new FXMLLoader(resource);
            Parent root1=(Parent)fxmlLoader.load();
            stage.setTitle("Consola");
            stage.getIcons().add(new Image("imagenes/btnConsola.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }
        catch(Exception ex){
            System.out.println("Cant load new window");
            
        }
    }
}
