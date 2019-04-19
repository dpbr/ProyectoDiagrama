/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author BLANSKPC
 */
public class EtapaProceso extends Figura{
    
    
    //Constructor
    public EtapaProceso (Point2D p){
        this.setNombre("algo");
        this.setCentralPoint(p);
    }
    /**
     * Dibujar la figura
     * @param gc 
     */
    public void dibujarFigura(GraphicsContext gc){
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(Font.font(15));
        gc.fillText(nombre, (int)centralPoint.getX(), (int)centralPoint.getY());
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(),  coordenadas.get(2).getX(), coordenadas.get(2).getY());
        gc.strokeLine(coordenadas.get(2).getX(), coordenadas.get(2).getY(),  coordenadas.get(3).getX(), coordenadas.get(3).getY());
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(),  coordenadas.get(0).getX(), coordenadas.get(0).getY());
        
    }
    
    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > coordenadas.get(0).getX() &&
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
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()-30));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()-30));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()+30));
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()+30));
    }
    
    
    
    
}
