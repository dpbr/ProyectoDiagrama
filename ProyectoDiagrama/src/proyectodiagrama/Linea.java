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
public class Linea extends Figura {
    Figura inicio,fin;
    
    //Constructor
    public Linea (Figura inicio, Figura fin){
        this.inicio = inicio;
        this.fin = fin;
        this.setNombre("");
        this.setCentralPoint(inicio.getCentralPoint());
    }
    
    public void dibujarLinea(GraphicsContext gc){ //tiene que recibir las coordenadas x e y del mouse
        gc.strokeLine(400, 40, 400, 120);//linea vertical la linea tiene un largo de 80
        //punta de la linea
        gc.strokeLine(395, 115, 400, 120);//left cada punto tiene un largo de 5
        gc.strokeLine(405, 115, 400, 120);//right
    }
    
    public void refresh(){
        coordenadas.clear();
        coordenadas.add(inicio.getCentralPoint());
        coordenadas.add(fin.getCentralPoint());
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        if(inicio instanceof Documento){
            gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY()+50,  coordenadas.get(1).getX(), coordenadas.get(1).getY()-20);
        }else{
            gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY()+20,  coordenadas.get(1).getX(), coordenadas.get(1).getY()-20);
        }
        
    }

    @Override
    public boolean estaDentro(Point2D p) {
        return false;
    }

    @Override
    public void crear(Point2D p) {
        coordenadas.clear();
        coordenadas.add(inicio.getCentralPoint());
        coordenadas.add(fin.getCentralPoint());
    }
}
