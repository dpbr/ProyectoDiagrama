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
public class Documento extends Figura{
    //Constructor
    public Documento (Point2D p){
        this.setNombre("Documento");
        this.setCentralPoint(p);
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
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(Font.font(15));
        gc.fillText(nombre, (int)centralPoint.getX(), (int)centralPoint.getY());
        //Dibuja las líneas
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(),  coordenadas.get(2).getX(), coordenadas.get(2).getY());
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(),  coordenadas.get(0).getX(), coordenadas.get(0).getY());
        gc.strokeArc(coordenadas.get(0).getX(), coordenadas.get(3).getY()-12.25, ancho(), 25, 180, 180, ArcType.OPEN);//arc
        gc.strokeArc(coordenadas.get(2).getX()-(ancho()/2), coordenadas.get(2).getY(), ancho(), 40, 90, 90,ArcType.OPEN);//arc
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > coordenadas.get(0).getX() &&
           p.getX() < coordenadas.get(1).getX() &&
           p.getY() > coordenadas.get(0).getY() &&
           p.getY() < coordenadas.get(3).getY()){
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
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()+40));
    }

   
}
