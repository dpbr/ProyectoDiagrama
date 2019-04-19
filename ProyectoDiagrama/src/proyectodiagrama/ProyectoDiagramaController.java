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
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ProyectoDiagramaController implements Initializable {
    
    ArrayList<Figura> figuras = null;
    
    Point2D mouse,mouseT;
    boolean dragged = false;
    Figura figuradrag;
    
    //Constructor
    public ProyectoDiagramaController(){
        setFiguras(new ArrayList<>());
    }

    @FXML
    private MenuBar menubar;
    
    @FXML
    private Canvas canvas;
    GraphicsContext gc;

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
        documento.dibujarFigura(gc);
        figuras.add(documento);
    }

    @FXML
    void crearEntrada(ActionEvent event) {
        System.out.println("Entrada/Salida creada.");
        EntradaSalida rombo = new EntradaSalida(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
        rombo.dibujarFigura(gc);
        figuras.add(rombo);
    }

    @FXML
    void crearEtapa(ActionEvent event) {
        System.out.println("Etapa del proceso creada.");
        EtapaProceso rectangle = new EtapaProceso(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
        rectangle.dibujarFigura(gc);
        figuras.add(rectangle);
    }

    @FXML
    void crearInicio(ActionEvent event) {
        System.out.println("Inicio/Fin creado.");
        InicioFin iniciofin = new InicioFin();
        iniciofin.dibujarFigura(gc);
        figuras.add(iniciofin);
    }

    @FXML
    void crearLinea(ActionEvent event) {
        System.out.println("Línea creada.");
        Linea linea = new Linea();
        
        linea.dibujarFigura(gc);
        figuras.add(linea);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
    }
    
    public void addFigura(Figura f){
        figuras.add(f);
    }
    
    public void removeFigura(Figura f){
        figuras.remove(f);
    }
    
    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figura> figuras) {
        this.figuras = figuras;
    }

    public Point2D getMouse() {
        return mouse;
    }

    public void setMouse(Point2D mouse) {
        this.mouse = mouse;
    }

    public Point2D getMouseT() {
        return mouseT;
    }

    public void setMouseT(Point2D mouseT) {
        this.mouseT = mouseT;
    }

    @FXML
    private void mover(MouseEvent e) {
        mouse = new Point2D(e.getX(),e.getY());
        if(figuradrag == null){
            for(Figura f: figuras){
                if(f.estaDentro(mouse)){
                    //f.setCentralPoint(mouse);
                    figuradrag = f;

                }
            }
        }
        
        figuradrag.setCentralPoint(mouse);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        dibujar();
        
    }
    
    private void dibujar(){
        
        for(Figura f: figuras){
            f.dibujarFigura(gc);
        }
    }

    @FXML
    private void soltar(MouseEvent event) {
        figuradrag = null;
        dragged = false;
    }

    
    
}   
