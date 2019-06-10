package clases;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

/**
 *
 * @author BLANSKPC
 */
public abstract class Figura{
    //atributos
    private String nombre; //Texto que irá en el centro de la figura
    private Point2D centralPoint; //Este punto va en el centro de la figura y con él se crean los demás (vértices).
    private ArrayList<Point2D> coordenadas = new ArrayList<>(); //Esta lista guardará las coordenadas de los vértices de la figura
    
    /**
     * Método abstracto que dibuja la figura a base de los puntos de referencia.
     * @param gc 
     */
    abstract public void dibujarFigura(GraphicsContext gc);
    /**
     * Método abstracto que pregunta si el cursor (coordenadas x,y) está dentro de la figura al presionar click.
     * @param p
     * @return boolean
     */
    abstract public boolean estaDentro(Point2D p);
    /**
     * Método abstracto que crear los puntos de referencia de cada figura (el método funciona distinto dependiendo de la figura).
     * @param p 
     */
    abstract public void crear(Point2D p);
    
    /**
     * Método que se encarga de capturar el ancho del texto que va dentro de la figura.
     * @return double
     */
    public double ancho(){
        Text text = new Text(this.nombre);
        if(text.getLayoutBounds().getWidth() < text.getLayoutBounds().getHeight()){
            return text.getLayoutBounds().getHeight();
        }
        return text.getLayoutBounds().getWidth();
    }
    
    public Point2D getCentralPoint() {
        return centralPoint;
    }

    public void setCentralPoint(Point2D centralPoint) {
        this.centralPoint = centralPoint;
        crear(centralPoint);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Point2D> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Point2D> coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    

}
