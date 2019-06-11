package clases;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
/**
 *
 * @author BLANSKPC
 */
public class EtapaProceso extends Figura{
    
    //Constructor
    public EtapaProceso (Point2D p){
        this.setNombre("   ");
        this.setCentralPoint(p);
    }
    /**
     * Dibujar la figura
     * @param gc 
     */
    public void dibujarFigura(GraphicsContext gc){
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        
        //Dibuja fondo
        gc.setStroke(Color.rgb(242,252,206));//amarillo
        gc.setLineWidth(3.5);
        for (int i = 0; i < (this.getCoordenadas().get(1).getX()-this.getCentralPoint().getX()); i++) {
            gc.strokeLine(this.getCoordenadas().get(1).getX()-2*i, this.getCoordenadas().get(1).getY()+1,  this.getCoordenadas().get(2).getX()-2*i, this.getCoordenadas().get(2).getY()-1);
        }
        
        //Dibuja las líneas
        gc.setStroke(Color.rgb(155,124,0));//línea amarilla
        gc.setLineWidth(1);
        gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY(),  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY());
        gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY(),  this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY());
        gc.strokeLine(this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY(),  this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY());
        gc.strokeLine(this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY(),  this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY());
        
        gc.setFont(Font.font(15));
        gc.fillText(this.getNombre(), (int)this.getCentralPoint().getX(), (int)this.getCentralPoint().getY());
    }
    
    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > this.getCoordenadas().get(0).getX() &&
           p.getX() < this.getCoordenadas().get(1).getX() &&
           p.getY() > this.getCoordenadas().get(0).getY() &&
           p.getY() < this.getCoordenadas().get(2).getY()){
            return true;
        }
        return false;
    }
    
    @Override
    public void crear(Point2D p) {
        this.getCoordenadas().clear();
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()-20));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()-20));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4),p.getY()+20));
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()+20));
    }
}
