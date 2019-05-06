/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ProyectoDiagramaController implements Initializable {
    
    ArrayList<Figura> figuras = new ArrayList<>();
    static Figura fcambiar=null;
    Point2D mouse,mouseT;
    boolean dragged = false, block = false, borrando = false;
    Figura figuradrag;
    Figura inicio=null,fin=null;
    int cantIniciofin=0;
    
    @FXML
    private Button btnBorrar;
    @FXML
    private ImageView imgBorrar;
    @FXML
    private Button btnBorrartodo;
    @FXML
    private Button btnPlay;
    
    //Constructor
    public ProyectoDiagramaController(){
        
    }

    @FXML
    private MenuBar menubar;
    
    @FXML
    private MenuItem mBorrar;
    
    @FXML
    private MenuItem menuBorrartodo;
    
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
    void crearDocumento(ActionEvent event) throws IOException {
        cantIniciofin = 0;
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
         if (cantIniciofin == 0) { 
            alertBox("Requiere un INICIO antes"); 
        }else{
            System.out.println("Documento creado.");
            Documento documento = new Documento(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            fcambiar = documento;
            CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
            documento.setCentralPoint(documento.getCentralPoint());
            documento.dibujarFigura(gc);
            figuras.add(documento);
        }
        
    }

    @FXML
    void crearEntrada(ActionEvent event) throws IOException {
        cantIniciofin = 0;
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
        if (cantIniciofin == 0) { 
            alertBox("Requiere un INICIO antes"); 
        }else{
            System.out.println("Entrada/Salida creada.");
            EntradaSalida rombo = new EntradaSalida(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            fcambiar = rombo;
            CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
            rombo.setCentralPoint(rombo.getCentralPoint());
            rombo.dibujarFigura(gc);
            figuras.add(rombo);
        }
        
    }

    @FXML
    void crearEtapa(ActionEvent event) throws IOException {
        cantIniciofin = 0;
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
        if (cantIniciofin == 0) {  
            alertBox("Requiere un INICIO antes"); 
        }else{
            System.out.println("Etapa del proceso creada.");
            EtapaProceso rectangle = new EtapaProceso(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            fcambiar = rectangle;
            CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
            rectangle.setCentralPoint(rectangle.getCentralPoint());
            rectangle.dibujarFigura(gc);
            figuras.add(rectangle);
        }
    }

    @FXML
    void crearInicio(ActionEvent event) throws IOException {
        cantIniciofin = 0;
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
        if (cantIniciofin < 2){
            if (cantIniciofin == 0) { 
                System.out.println("Inicio/Fin creado.");
                InicioFin iniciofin = new InicioFin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
                iniciofin.antes = true;
                fcambiar = iniciofin;
                CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
                iniciofin.setCentralPoint(iniciofin.getCentralPoint());
                iniciofin.dibujarFigura(gc);
                figuras.add(iniciofin);
            }
            else if(cantIniciofin == 1){
                System.out.println("Inicio/Fin creado.");
                InicioFin iniciofin = new InicioFin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
                iniciofin.despues = true;
                fcambiar = iniciofin;
                CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
                iniciofin.setCentralPoint(iniciofin.getCentralPoint());
                iniciofin.dibujarFigura(gc);
                figuras.add(iniciofin);
            }
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
        }
        else{
            alertBox("Requiere mas de un proceso para crear linea");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        ProyectoDiagramaController interfaz = this;
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
    
    
    
    @FXML
    private void borrar(ActionEvent e) {
        if(figuras.size()>0){
            block = true;
            blockbtn();
            borrando = true;            
        }
    }

    @FXML
    private void borrarTodo(ActionEvent event) {
        figuras.clear();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    private void blockbtn(){
        //estoy bloqueando los botones
        btnLinea.setDisable(block);
        btnInicio.setDisable(block);
        btnEtapa.setDisable(block);
        btnDocumento.setDisable(block);
        btnEntrada.setDisable(block);
        btnBorrar.setDisable(block);
        btnBorrartodo.setDisable(block);
        btnPlay.setDisable(block);
    }

    @FXML
    private void play(ActionEvent event) {
        System.out.println("La funcion no está implementada.");
    }
    
    

    @FXML
    private void dobleclick(MouseEvent event) throws IOException {
        if(!block){
            System.out.println("entrodobleclick");
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        System.out.println("Double clicked");
                        mouse = new Point2D (event.getX(),event.getY());
                        for (Figura f: figuras) {
                            if(f.estaDentro(mouse)){
                                fcambiar = f;
                                CambioDeVentanas.newVentana(getClass().getResource("popUp.fxml"));
                                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                                f.setCentralPoint(f.getCentralPoint());
                                dibujar();
                            }
                        }
                    }
                }
        }else{
            //borrar
            if(borrando){
                System.out.println("borrando");
                mouse = new Point2D (event.getX(),event.getY());
                boolean suelta=false;

                for (int i = 0; i < figuras.size(); i++) {
                    if(figuras.get(i).estaDentro(mouse)){
                        if(figuras.get(i) instanceof InicioFin){
                            cantIniciofin--;
                        }
                        //figuras.set(i, null);
                        figuras.remove(i);
                    }
                    for (int j = 0; j < figuras.size(); j++) {
                        if(figuras.get(j) instanceof Linea){
                            for(Figura f: figuras){
                                if((((Linea) figuras.get(j)).getInicio().equals(f)) || (((Linea) figuras.get(j)).getFin().equals(f))){
                                    suelta=false;
                                }else{
                                    suelta=true;
                                }
                            }
                            if(suelta){
                                figuras.remove(j);
                                j=0;
                                suelta=false;
                            }
                        }
                    }
                }
                
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                dibujar();
                block = false;
                blockbtn();
                
            }else{
                //crearLinea
                mouse = new Point2D (event.getX(),event.getY());
                for(Figura f: figuras){
                    if(f.estaDentro(mouse)){
                        if(inicio == null){
                            if (f.despues == false) {
                                inicio = f;
                                f.despues=true;
                            }
                            else{
                                alertBox("Ya hay linea asociada");
                                block = false;
                                blockbtn();
                            }
                        }
                        else if(fin == null && f != inicio && f.antes == false){
                            fin = f;
                            f.antes=true;
                            Linea linea = new Linea(inicio, fin);
                            inicio.lineas.add(linea);
                            fin.lineas.add(linea);
                            linea.dibujarFigura(gc);
                            figuras.add(linea);
                            block = false;
                            blockbtn();
                            return;
                        }
                    }
                }
            }
            borrando = false;
        }
    }
    
    public void alertBox (String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("ADVERTENCIA");
        alert.setContentText(text);
        alert.showAndWait();
    }
}   
