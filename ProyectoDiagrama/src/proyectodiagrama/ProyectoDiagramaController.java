/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ProyectoDiagramaController implements Initializable {
    
    ArrayList<Figuras> figuras = null;
    double mouseX, mouseY,mouseTranslateX,mouseTranslateY;
    
    //Constructor
    public ProyectoDiagramaController(){
        setFiguras(new ArrayList<>());
    }

    public ArrayList<Figuras> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figuras> figuras) {
        this.figuras = figuras;
    }
    
    @FXML
    private MenuBar menubar;
    
    @FXML
    private Canvas canvas;

    @FXML
    private Pane rectIdentidades;
    
    @FXML
    private Button btnLinea;

    @FXML
    private ImageView imgLinea;

    @FXML
    private ImageView imgInicio;

    @FXML
    private Button btnInicio;

    @FXML
    private ImageView imgEtapa;

    @FXML
    private Button btnEtapa;

    @FXML
    private ImageView imgEntrada;

    @FXML
    private Button btnEntrada;

    @FXML
    private ImageView imgDocumento;

    @FXML
    private Button btnDocumento;
    
    @FXML
    void crearDocumento(ActionEvent event) {
        System.out.println("Documento creado.");
        Documento documento = new Documento();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        documento.dibujarDocumento(gc);
    }

    @FXML
    void crearEntrada(ActionEvent event) {
        System.out.println("Entrada/Salida creada.");
        EntradaSalida rombo = new EntradaSalida();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        rombo.dibujarRombo(gc);
        
    }

    @FXML
    void crearEtapa(ActionEvent event) {
        System.out.println("Etapa del proceso creada.");
        EtapaProceso rectangle = new EtapaProceso();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        rectangle.dibujarRect(gc);
    }

    @FXML
    void crearInicio(ActionEvent event) {
        System.out.println("Inicio/Fin creado.");
        InicioFin iniciofin = new InicioFin();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        iniciofin.dibujarInicioFin(gc);
    }

    @FXML
    void crearLinea(ActionEvent event) {
        System.out.println("Línea creada.");
        Linea linea = new Linea();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        linea.dibujarLinea(gc);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>(){
            
            @Override 
            public void handle(MouseEvent event) {
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
                System.out.println(" mouseX: "+mouseX + " mouseY: " + mouseY);
                
            }
            
        });
    }

    public ArrayList<Figuras> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figuras> figuras) {
        this.figuras = figuras;
    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

    public double getMouseTranslateX() {
        return mouseTranslateX;
    }

    public void setMouseTranslateX(double mouseTranslateX) {
        this.mouseTranslateX = mouseTranslateX;
    }

    public double getMouseTranslateY() {
        return mouseTranslateY;
    }

    public void setMouseTranslateY(double mouseTranslateY) {
        this.mouseTranslateY = mouseTranslateY;
    }
}
