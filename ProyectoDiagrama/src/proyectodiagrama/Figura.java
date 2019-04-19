package proyectodiagrama;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BLANSKPC
 */
public abstract class Figura {
    String nombre;
    Point2D centralPoint;
    ArrayList<Point2D> coordenadas = new ArrayList<>();
    
    abstract public void dibujarFigura(GraphicsContext gc);
    abstract public boolean estaDentro(Point2D p);
    abstract public void crear(Point2D p);
    
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
    
}
