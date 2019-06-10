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
public class Condicion extends Figura{
    //Constructor
    public Condicion (Point2D p){
        this.setNombre("   ");
        this.setCentralPoint(p);
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        //Dibujar líneas fuera de la condicion
        gc.setStroke(Color.RED);
        gc.strokeLine(this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(1).getY(), this.getCoordenadas().get(4).getX(), this.getCoordenadas().get(1).getY());
        gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY(), this.getCoordenadas().get(5).getX(), this.getCoordenadas().get(1).getY());
        //Dibujar fondo
        gc.setStroke(Color.rgb(216,228,254));//azul cielo
        gc.setLineWidth(2);
        for (int i = 0; this.getCoordenadas().get(0).getY()+i <= this.getCoordenadas().get(2).getY(); i++) {
            gc.strokeLine(this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY(), this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY()+i);
            gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY()+i, this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY());
        }
        
        //Dibujar líneas
        gc.setStroke(Color.BLUE);//línea roja pálida más intensa
        gc.setLineWidth(1);
        gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY(),  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY());
        gc.strokeLine(this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY(),  this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY());
        gc.strokeLine(this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY(),  this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY());
        gc.strokeLine(this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY(),  this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY());
        gc.setFont(Font.font(15));
        gc.fillText(this.getNombre(), (int)this.getCentralPoint().getX(), (int)this.getCentralPoint().getY());
        
        gc.setFill(Color.RED);
        gc.setFont(Font.font(10));
        gc.fillText("F", this.getCoordenadas().get(3).getX()-15, this.getCoordenadas().get(1).getY()-10);
        gc.fillText("V", this.getCoordenadas().get(1).getX()+15, this.getCoordenadas().get(1).getY()-10);
        gc.setFill(Color.BLACK);
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > this.getCoordenadas().get(3).getX() &&
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
        this.getCoordenadas().add(new Point2D(p.getX(),p.getY()-30));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4)+30,p.getY()));
        this.getCoordenadas().add(new Point2D(p.getX(),p.getY()+30));
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4)-30,p.getY()));
        //líneas que salen de la condición que se conectarán con las otras figuras
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4)-110,p.getY()));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4)+110,p.getY()));
    }
    
}
