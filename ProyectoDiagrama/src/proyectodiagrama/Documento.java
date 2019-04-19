/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

/**
 *
 * @author BLANSKPC
 */
public class Documento extends Figura{
    //Constructor
    public Documento (){
        
    }
    
    public void dibujarDocumento(GraphicsContext gc){ //tiene que recibir las coordenadas x e y del mouse
        gc.strokeLine(300, 40, 500, 40);//top
        gc.strokeLine(300, 40, 300, 120);//left
        gc.strokeLine(500, 40, 500, 100);//right
        //bottom curves
        gc.strokeArc(300, 95, 133.3333, 50, 180, 160, ArcType.OPEN);//arc
        gc.strokeArc(429, 101, 131, 60, 85, 90,ArcType.OPEN);//arc
    }

    @Override
    public void dibujarFigura(GraphicsContext gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaDentro(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
