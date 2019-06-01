/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    static Figura fcambiar=null;
    Point2D mouse,mouseT;
    public static boolean baceptar=false,bentrada=false,bverdaderofalso=false;
    boolean dragged = false, block = false, borrando = false;
    Figura figuradrag;
    Figura primeraFigura=null,segundaFigura=null;
    int cantIniciofin=0;
    
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnBorrartodo;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnConsola;
    
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
    void crearInicio(ActionEvent event) throws IOException {
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
                //inicio.antes = true;
                fcambiar = inicio;
                CambioDeVentanas.newVentana(getClass().getResource("/fxmls/popUp.fxml"));
                inicio.setCentralPoint(inicio.getCentralPoint());
                inicio.dibujarFigura(gc);
                figuras.add(inicio);
            }
            else if(cantIniciofin == 1){
                System.out.println("Fin creado.");
                InicioFin fin = new Fin(new Point2D(canvas.getWidth()/2, canvas.getHeight()/2));
                //fin.despues = true;
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
    void crearLinea(ActionEvent event) {
        if(figuras.size()>1){
            block = true;
            blockbtn();
            primeraFigura=null;segundaFigura=null;
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
                //boolean suelta=false;

                for (int i = 0; i < figuras.size(); i++) {
                    if(figuras.get(i).estaDentro(mouse)){
                        if(figuras.get(i) instanceof InicioFin){
                            cantIniciofin--;
                        }
                        //figuras.set(i, null);
                        //figuras.get(i).antes = false;
                        figuras.remove(i);
                    }
                    for (int j = 0; j < figuras.size(); j++) {
                        if(figuras.get(j) instanceof Linea){
                            if(figuras.get(j).anterior == null || figuras.get(j).siguiente == null){
                                figuras.remove(j);
                            }
//                            for(Figura f: figuras){
//                                if((((Linea) figuras.get(j)).getInicio().equals(f)) || (((Linea) figuras.get(j)).getFin().equals(f))){
//                                    suelta=false;
//                                }else{
//                                    suelta=true;
//                                }
//                            }
//                            if(suelta){
//                                figuras.remove(j);
//                                j=0;
//                                suelta=false;
//                            }
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
                        
                        if(primeraFigura == null){
                            if (f.siguiente == null) {
                                primeraFigura = f;
                                //f.siguiente = true;
                            }else{
                                alertBox("Ya hay linea asociada");
                                block = false;
                                blockbtn();
                            }
                        }
                        else if(segundaFigura == null && f != primeraFigura ){//&& f.antes == false
                            segundaFigura = f;
                            //f.antes=true;
                            Linea linea = new Linea(primeraFigura, segundaFigura);
                            linea.dibujarFigura(gc);
                            figuras.add(linea);
                            block = false;
                            blockbtn();
                            return;
                        }
                    }
                }
            }
//            for(Figura f: figuras){
//                if(inicio.equals(f)){
//                    for(Figura f2: figuras){
//                        if(fin.equals(f2)){
//                            f.setSiguiente(f2);
//                            f2.setAnterior(f);
//                        }
//                    }
//                }
//            }
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
    
    public void ordenarFiguras(){
        LinkedList<Figura> figurasOrdenadas = new LinkedList<>();
        for(Figura f: figuras){
            if(f instanceof Inicio){
                figurasOrdenadas.addFirst(f);
            }
            
//            if(f instanceof Condicion || f instanceof Documento || f instanceof EntradaSalida || f instanceof EtapaProceso){
//                
//            }
//            if(f instanceof Fin){
//                figurasOrdenadas.addLast(f);
//            }
        }
        int i = 0;
        Figura fagregada;
        while (i < figuras.size()){
            if(figurasOrdenadas.size() == 1){
                fagregada = figurasOrdenadas.get(i).siguiente;
                figurasOrdenadas.add(fagregada);
            }
            i++;
        }
        
    }
}   
