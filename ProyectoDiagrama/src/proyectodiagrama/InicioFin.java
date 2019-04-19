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
public class InicioFin extends Figura {
    
    
    public InicioFin(){
        
    }
    
    public void dibujarInicioFin(GraphicsContext gc){
        gc.strokeLine(300, 40, 500, 40);//top
        gc.strokeLine(300, 100, 500, 100);//bottom
        gc.strokeArc(479, 40, 40, 60, 278, 165, ArcType.OPEN);//right arc
        gc.strokeArc(283, 40, 40, 60, 95, 165,ArcType.OPEN);//left arc
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
