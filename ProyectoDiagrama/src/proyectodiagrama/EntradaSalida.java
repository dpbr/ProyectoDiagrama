/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author BLANSKPC
 */
public class EntradaSalida extends Figura {
    
    
    //Constructor
    public EntradaSalida (Point2D p){
        this.setCentralPoint(p);
    }
    
    public void dibujarRombo(GraphicsContext gc){
        gc.strokeLine(350, 40, 500, 40);//top
        gc.strokeLine(300, 100, 450, 100);//bottom
        gc.strokeLine(350, 40, 300, 100);//left
        gc.strokeLine(500, 40, 450, 100);//right
    }

    @Override
    public void dibujarFigura(GraphicsContext gc) {
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(),  coordenadas.get(2).getX(), coordenadas.get(2).getY());
        gc.strokeLine(coordenadas.get(2).getX(), coordenadas.get(2).getY(),  coordenadas.get(3).getX(), coordenadas.get(3).getY());
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(),  coordenadas.get(0).getX(), coordenadas.get(0).getY());
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > coordenadas.get(3).getX() &&
           p.getX() < coordenadas.get(1).getX() &&
           p.getY() > coordenadas.get(0).getY() &&
           p.getY() < coordenadas.get(2).getY()){
            return true;
        }
        return false;
    }

    @Override
    public void crear(Point2D p) {
        coordenadas.clear();
        coordenadas.add(new Point2D(p.getX()-85,p.getY()-30));
        coordenadas.add(new Point2D(p.getX()+115,p.getY()-30));
        coordenadas.add(new Point2D(p.getX()+85,p.getY()+30));
        coordenadas.add(new Point2D(p.getX()-115,p.getY()+30));
    }

    
    
}
