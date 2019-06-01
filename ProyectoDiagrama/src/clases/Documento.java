/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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
        this.setNombre("   ");
        this.setCentralPoint(p);
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        
        //Dibujar fondo
        gc.setStroke(Color.rgb(202,148,145));//rojo pálido
        gc.setLineWidth(2);
        for (int i = 0; i < (coordenadas.get(2).getY()-coordenadas.get(1).getY()-3); i++) {
            gc.strokeArc(coordenadas.get(0).getX()+1, coordenadas.get(3).getY()-12.25-i, ancho()-2, 25, 180, 180, ArcType.OPEN);//arc
            gc.strokeArc(coordenadas.get(2).getX()-(ancho()/2), coordenadas.get(2).getY()-i, ancho()-2, 40, 90, 90,ArcType.OPEN);//arc
            
        }
        for (int j = 0; j < (coordenadas.get(1).getX()-coordenadas.get(0).getX()); j++) {
            gc.strokeLine(coordenadas.get(1).getX()-j, coordenadas.get(1).getY(),  coordenadas.get(2).getX()-j, coordenadas.get(2).getY());
        }
        
        //Dibuja las líneas
        gc.setStroke(Color.rgb(107,55,52));//línea roja pálida más intensa
        gc.setLineWidth(1);
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(),  coordenadas.get(2).getX(), coordenadas.get(2).getY());
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(),  coordenadas.get(0).getX(), coordenadas.get(0).getY());
        gc.strokeArc(coordenadas.get(0).getX(), coordenadas.get(3).getY()-12.25, ancho(), 25, 180, 180, ArcType.OPEN);//arc
        gc.strokeArc(coordenadas.get(2).getX()-(ancho()/2), coordenadas.get(2).getY(), ancho(), 40, 90, 90,ArcType.OPEN);//arc
        
        gc.setFont(Font.font(15));
        gc.fillText(nombre, (int)centralPoint.getX(), (int)centralPoint.getY());
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > coordenadas.get(0).getX() &&
           p.getX() < coordenadas.get(1).getX() &&
           p.getY() > coordenadas.get(0).getY() &&
           p.getY() < coordenadas.get(3).getY()+13){
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
