package proyectodiagrama;

import clases.Condicion;
import clases.Documento;
import clases.EntradaSalida;
import clases.EtapaProceso;
import clases.Figura;
import clases.Fin;
import clases.Inicio;
import clases.InicioFin;
import clases.Linea;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ProyectoDiagramaController implements Initializable {
    LinkedList<Figura> figuras = new LinkedList<>();
    LinkedList<Figura> diagrama = new LinkedList<>();
    static Figura fcambiar=null;
    Point2D mouse,mouseT;
    public boolean esta=false;
    public static boolean baceptar=false,bentrada=false,bverdaderofalso=false;
    boolean dragged = false, block = false, borrando = false;
    Figura figuradrag,figuraaux,figuraaux2;
    Figura primeraFigura=null,segundaFigura=null;
    int cantIniciofin=0, f1=0;
    
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnBorrartodo;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnConsola;
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
    private Pane rectEntidades;
    @FXML
    private Button btnLinea;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnEtapa;
    @FXML
    private Button btnEntrada;
    @FXML
    private Button btnDocumento;
    @FXML
    private Button btnCondicion;
    //Constructor
    public ProyectoDiagramaController(){
    }
    @FXML
    public void crearDocumento(ActionEvent event) throws IOException {
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
            CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
            if(baceptar){
                documento.setCentralPoint(documento.getCentralPoint());
                documento.dibujarFigura(gc);
                figuras.add(documento);
            }
        }
        baceptar=false;
    }
    @FXML
    public void crearEntrada(ActionEvent event) throws IOException {
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
            CambioDeVentanas.newVentana(getClass().getResource("/fxmls/EntradaSalida.fxml"));
            EntradaSalida rombo = new EntradaSalida(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            fcambiar = rombo;
            if(baceptar){
                rombo.setCentralPoint(rombo.getCentralPoint());
                rombo.dibujarFigura(gc);
                figuras.add(rombo);
            }
        }
        bentrada=false;
        baceptar=false;
    }
    @FXML
    public void crearEtapa(ActionEvent event) throws IOException {
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
            CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
            if(baceptar){
                rectangle.setCentralPoint(rectangle.getCentralPoint());
                rectangle.dibujarFigura(gc);
                figuras.add(rectangle);
            }
        }
        baceptar=false;
    }
    @FXML
    public void crearInicio(ActionEvent event) throws IOException {
        cantIniciofin = 0;
        for(Figura f: figuras){
            if(f instanceof InicioFin){
                cantIniciofin++;
            }
        }
        if (cantIniciofin < 2){
            if (cantIniciofin == 0) { 
                System.out.println("Inicio creado.");
                InicioFin inicio = new Inicio(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
                fcambiar = inicio;
                CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
                inicio.setCentralPoint(inicio.getCentralPoint());
                inicio.dibujarFigura(gc);
                figuras.add(inicio);
                primeraFigura = inicio;
                diagrama.add(primeraFigura);
            }
            else if(cantIniciofin == 1){
                System.out.println("Fin creado.");
                InicioFin fin = new Fin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
                
                fcambiar = fin;
                CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
                if(baceptar){
                    fin.setCentralPoint(fin.getCentralPoint());
                    fin.dibujarFigura(gc);
                    figuras.add(fin);
                }
            }
        } 
        else{
            alertBox("YA TIENE UN INICIO Y UN FIN");
        }
        baceptar=false;
    }
    @FXML
    private void crearCondicion(ActionEvent event) throws IOException {
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
            System.out.println("Condicion creada.");
            Condicion rombo2= new Condicion(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
            fcambiar = rombo2;
            CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
            if(baceptar){
                rombo2.setCentralPoint(rombo2.getCentralPoint());
                rombo2.dibujarFigura(gc);
                figuras.add(rombo2); 
            }
         }
         baceptar=false;
    }   
    @FXML
    public void crearLinea(ActionEvent event) {
        if(figuras.size()>1){
            block = true;
            blockbtn();
        }
        else{
            alertBox("Requiere más de un proceso para crear línea");
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

    public LinkedList<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(LinkedList<Figura> figuras) {
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
        diagrama.clear();
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
        btnCondicion.setDisable(block);
        btnConsola.setDisable(block);
    }

    @FXML
    private void play(ActionEvent event) {
        System.out.println("La función no está implementada.");
    }
    
    @FXML
    private void dobleclick(MouseEvent event) throws IOException {
        if(!block){
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        System.out.println("Double click");
                        mouse = new Point2D (event.getX(),event.getY());
                        for (Figura f: figuras) {
                            if(f.estaDentro(mouse)){
                                fcambiar = f;
                                CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
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
                for (int i = 0; i < diagrama.size(); i++) {
                    if(diagrama.get(i).estaDentro(mouse)){
                        if(diagrama.get(i) instanceof InicioFin){
                            System.out.println("esta figura no maderfaker");
                        }
                        else{
                            if(diagrama.size()> (i+1)){
                                ((Linea)diagrama.get(i+1)).setInicio(diagrama.get(i-2));
                            }
                            figuraaux=diagrama.get(i);
                            figuraaux2=diagrama.get(i-1);
                            diagrama.remove(i);
                            diagrama.remove(i-1);
                            if(figuras.contains(figuraaux2)){
                                figuras.remove(figuraaux2);
                            }
                            if(figuras.contains(figuraaux)){
                                figuras.remove(figuraaux);
                            }
                            figuraaux2=null;
                            figuraaux=null;
                            primeraFigura = diagrama.getLast();
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
                        if(!(f.equals(primeraFigura)) && !(f instanceof Inicio)){
                            segundaFigura = f;
                            if (!(diagrama.contains(f))) {
                                Linea linea = new Linea(primeraFigura, segundaFigura);
                                diagrama.add(linea);
                                figuras.add(linea);
                                diagrama.add(segundaFigura);
                                linea.dibujarFigura(gc);
                                
                            }
                        }
                        primeraFigura = diagrama.getLast();
                        block = false;
                        blockbtn();
                        return;
                    }
                }
            }
            borrando = false;
        }
    }
    
    public void alertBox (String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ADVERTENCIA");
        alert.setHeaderText("ADVERTENCIA");
        alert.setContentText(text);
        alert.showAndWait();
    }

    @FXML
    private void abrirConsola(ActionEvent event) throws IOException {
        CambioDeVentanas.newVentana2(getClass().getResource("/fxmls/consola.fxml"));
    }
    
}   
