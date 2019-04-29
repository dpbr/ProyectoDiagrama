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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ProyectoDiagramaController implements Initializable {
    
    ArrayList<Figura> figuras = null;
    boolean start = false, end = false;
    Point2D mouse,mouseT;
    boolean dragged = false, block = false;
    Figura figuradrag;
    Figura inicio=null,fin=null;
    
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
        if (!start) {
            alertBox("Requiere un INICIO antes");
        }
        else{
            System.out.println("Documento creado.");
            Documento documento = new Documento(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            documento.dibujarFigura(gc);
            figuras.add(documento);
        }
        
    }

    @FXML
    void crearEntrada(ActionEvent event) {
        if (!start) {
            alertBox("Requiere un INICIO antes");
        }
        else{
            System.out.println("Entrada/Salida creada.");
            EntradaSalida rombo = new EntradaSalida(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            rombo.dibujarFigura(gc);
            figuras.add(rombo);
        }
    }

    @FXML
    void crearEtapa(ActionEvent event) {
        if (!start) {
            alertBox("Requiere un INICIO antes");
        }
        else{
            System.out.println("Etapa del proceso creada.");
            EtapaProceso rectangle = new EtapaProceso(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            rectangle.dibujarFigura(gc);
            figuras.add(rectangle);
        }
    }

    @FXML
    void crearInicio(ActionEvent event) {
        
        if (!start) {
            this.start = true;
            System.out.println("Inicio/Fin creado.");
            InicioFin iniciofin = new InicioFin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2), "Inicio");
            iniciofin.dibujarFigura(gc);
            figuras.add(iniciofin);
        }
        else if(start && !end){
            this.end = true;
            System.out.println("Inicio/Fin creado.");
            InicioFin iniciofin = new InicioFin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2), "Fin");
            iniciofin.dibujarFigura(gc);
            figuras.add(iniciofin);
        }
        else{
            alertBox("YA TIENE UN INICIO Y UN FIN");
        }
    }

    @FXML
    void crearLinea(ActionEvent event) {

        if(figuras.size()>1){
            block = true;
        blockbtn();
        inicio=null;fin=null;
        
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                mouse = new Point2D (event.getX(),event.getY());
                
                for(Figura f: figuras){
                    if(f.estaDentro(mouse)){
                        if(inicio == null){
                            inicio = f;
                        }
                        else if(fin == null && f != inicio){
                            fin = f;
                            Linea linea = new Linea(inicio, fin);
                            linea.dibujarFigura(gc);
                            figuras.add(linea);
                            block = false;
                            blockbtn();
                            return;
                        }    
                    }
                }
                
            }
        });  
        }
        else{
            alertBox("Requiere DOS procesos antes");
        }
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
        if(!block){
            mouse = new Point2D(e.getX(),e.getY());
            if(figuradrag == null){
                for(Figura f: figuras){
                    if(f.estaDentro(mouse)){
                        //f.setCentralPoint(mouse);
                        figuradrag = f;
                    }
                }
            }
            try{
                figuradrag.setCentralPoint(mouse);
            }catch(Exception ex){
                //no existe figuradrag
            }
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            dibujar();
        }
    }
    
    private void dibujar(){
        for(Figura f: figuras){
            if(f instanceof Linea){
                ((Linea) f).refresh();
            }
            f.dibujarFigura(gc);
        }
    }
    
    

    @FXML
    private void soltar(MouseEvent event) {
        figuradrag = null;
        dragged = false;
    }
    
    private void blockbtn(){
        //estoy bloqueando los botones
        btnLinea.setDisable(block);
        btnInicio.setDisable(block);
        btnEtapa.setDisable(block);
        btnDocumento.setDisable(block);
        btnEntrada.setDisable(block);
    }
    
    public void alertBox (String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setHeaderText("ADVERTENCIA");
        alert.setContentText(text);
        alert.showAndWait();
    }

}   
