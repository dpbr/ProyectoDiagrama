package clases;

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
        this.getCoordenadas().clear();
        this.getCoordenadas().add(inicio.getCentralPoint());
        this.getCoordenadas().add(fin.getCentralPoint());
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        if(inicio instanceof Documento){
            gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY()+51,  this.getCoordenadas().get(1).getY(), this.getCoordenadas().get(1).getY()-20);
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-20, this.getCoordenadas().get(1).getX()-5, this.getCoordenadas().get(1).getY()-25); //izquierda
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-20, this.getCoordenadas().get(1).getX()+5, this.getCoordenadas().get(1).getY()-25); //derecha
        }
        else if(fin instanceof Condicion){
            gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY()+20,  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-30);
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-30, this.getCoordenadas().get(1).getX()-5, this.getCoordenadas().get(1).getY()-35); //izquierda
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-30, this.getCoordenadas().get(1).getX()+5, this.getCoordenadas().get(1).getY()-35); //derecha
        }
        else{
            gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY()+20,  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-20);
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-20, this.getCoordenadas().get(1).getX()-5, this.getCoordenadas().get(1).getY()-25); //izquierda
            gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY()-20, this.getCoordenadas().get(1).getX()+5, this.getCoordenadas().get(1).getY()-25); //derecha
        }
        
        gc.setStroke(Color.BLACK);
    }

    @Override
    public boolean estaDentro(Point2D p) {
        double m = (this.getCoordenadas().get(1).getY()-this.getCoordenadas().get(0).getY())/(this.getCoordenadas().get(1).getX()-this.getCoordenadas().get(0).getX());
        if(p.getY()-this.getCoordenadas().get(0).getY() == m*(p.getX()-this.getCoordenadas().get(0).getX())){
            return true;
        }
        return false;
    }

    @Override
    public void crear(Point2D p) {
        this.getCoordenadas().clear();
        this.getCoordenadas().add(inicio.getCentralPoint());
        this.getCoordenadas().add(fin.getCentralPoint());
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
