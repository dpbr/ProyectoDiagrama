/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author BLANSKPC
 */
public class InicioFin extends Figura {
    
    
    public InicioFin(Point2D p, String text){
        this.setNombre(text);
        this.setCentralPoint(p);
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(Font.font(15));
        gc.fillText(nombre, (int)centralPoint.getX(), (int)centralPoint.getY());
        //Dibuja las líneas y arcos
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeArc(coordenadas.get(2).getX()-20, coordenadas.get(0).getY(), 40, 40, 270, 180, ArcType.OPEN);//right arc
        gc.strokeLine(coordenadas.get(2).getX(), coordenadas.get(2).getY(),  coordenadas.get(3).getX(), coordenadas.get(3).getY());
        gc.strokeArc(coordenadas.get(0).getX()-20, coordenadas.get(0).getY(), 40, 40, 90, 180,ArcType.OPEN);//left arc
        
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
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()-20));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()-20));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()+20));
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()+20));
    }

}
