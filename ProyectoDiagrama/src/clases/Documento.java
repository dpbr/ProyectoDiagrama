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
        for (int i = 0; i < (this.getCoordenadas().get(2).getY()-this.getCoordenadas().get(1).getY()-3); i++) {
            gc.strokeArc(this.getCoordenadas().get(0).getX()+1, this.getCoordenadas().get(3).getY()-12.25-i, ancho()-2, 25, 180, 180, ArcType.OPEN);//arc
            gc.strokeArc(this.getCoordenadas().get(2).getX()-(ancho()/2), this.getCoordenadas().get(2).getY()-i, ancho()-2, 40, 90, 90,ArcType.OPEN);//arc
        }
        for (int j = 0; j < (this.getCoordenadas().get(1).getX()-this.getCoordenadas().get(0).getX()); j++) {
            gc.strokeLine(this.getCoordenadas().get(1).getX()-j, this.getCoordenadas().get(1).getY(),  this.getCoordenadas().get(2).getX()-j, this.getCoordenadas().get(2).getY());
        }
        
        //Dibuja las líneas
        gc.setStroke(Color.rgb(107,55,52));//línea roja pálida más intensa
        gc.setLineWidth(1);
        gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY(),  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY());
        gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY(),  this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY());
        gc.strokeLine(this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY(),  this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY());
        gc.strokeArc(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(3).getY()-12.25, ancho(), 25, 180, 180, ArcType.OPEN);//arc
        gc.strokeArc(this.getCoordenadas().get(2).getX()-(ancho()/2), this.getCoordenadas().get(2).getY(), ancho(), 40, 90, 90,ArcType.OPEN);//arc
        
        gc.setFont(Font.font(15));
        gc.fillText(this.getNombre(), (int)this.getCentralPoint().getX(), (int)this.getCentralPoint().getY());
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > this.getCoordenadas().get(0).getX() &&
           p.getX() < this.getCoordenadas().get(1).getX() &&
           p.getY() > this.getCoordenadas().get(0).getY() &&
           p.getY() < this.getCoordenadas().get(3).getY()+13){
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
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4),p.getY()+40));
    }

}
