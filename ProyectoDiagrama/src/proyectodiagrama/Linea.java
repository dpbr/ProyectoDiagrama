/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
    
    public void refresh(){
        coordenadas.clear();
        coordenadas.add(inicio.getCentralPoint());
        coordenadas.add(fin.getCentralPoint());
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        if(inicio instanceof Documento){
            gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY()+51,  coordenadas.get(1).getX(), coordenadas.get(1).getY()-20);
        }else{
            gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY()+20,  coordenadas.get(1).getX(), coordenadas.get(1).getY()-20);
        }
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY()-20, coordenadas.get(1).getX()-5, coordenadas.get(1).getY()-25); //izquierda
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY()-20, coordenadas.get(1).getX()+5, coordenadas.get(1).getY()-25); //derecha
        gc.setStroke(Color.BLACK);
    }

    @Override
    public boolean estaDentro(Point2D p) {
        double m = (coordenadas.get(1).getY()-coordenadas.get(0).getY())/(coordenadas.get(1).getX()-coordenadas.get(0).getX());
        if(p.getY()-coordenadas.get(0).getY() == m*(p.getX()-coordenadas.get(0).getX())){
            return true;
        }
        return false;
    }

    @Override
    public void crear(Point2D p) {
        coordenadas.clear();
        coordenadas.add(inicio.getCentralPoint());
        coordenadas.add(fin.getCentralPoint());
    }

    public Figura getInicio() {
        return inicio;
    }

    public void setInicio(Figura inicio) {
        this.inicio = inicio;
    }

    public Figura getFin() {
        return fin;
    }

    public void setFin(Figura fin) {
        this.fin = fin;
    }
}
