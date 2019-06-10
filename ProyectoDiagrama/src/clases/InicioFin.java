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
public class InicioFin extends Figura {
    
    
    public InicioFin(Point2D p){
        this.setNombre("   ");
        this.setCentralPoint(p);
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        //poner texto dentro de la figura
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(Font.font(15));
        gc.fillText(this.getNombre(), (int)this.getCentralPoint().getX(), (int)this.getCentralPoint().getY());
        
        //Dibuja fondo
        gc.setStroke(Color.rgb(247,197,147)); //naranja
        gc.setLineWidth(2);
        for (int i = 0; i < (this.getCoordenadas().get(2).getX()-this.getCentralPoint().getX())+12; i++) {
            gc.strokeArc(this.getCoordenadas().get(2).getX()-21-i, this.getCoordenadas().get(0).getY()+1, 40, 40, 270, 180, ArcType.OPEN);
            gc.strokeArc(this.getCoordenadas().get(0).getX()-19+i, this.getCoordenadas().get(0).getY()+1, 40, 40, 90, 180,ArcType.OPEN);
        }
        for (int j = 0; j < (this.getCoordenadas().get(2).getY()-this.getCoordenadas().get(0).getY()); j++) {
            gc.strokeLine(this.getCoordenadas().get(0).getX()+1, this.getCoordenadas().get(0).getY()+1+j, this.getCoordenadas().get(1).getX()-1, this.getCoordenadas().get(1).getY()+1+j);
        }
        
        //Dibuja las líneas y arcos
        gc.setStroke(Color.rgb(153,117,6));//línea naranja
        gc.setLineWidth(1);
        gc.strokeLine(this.getCoordenadas().get(0).getX(), this.getCoordenadas().get(0).getY(),  this.getCoordenadas().get(1).getX(), this.getCoordenadas().get(1).getY());
        gc.strokeArc(this.getCoordenadas().get(2).getX()-20, this.getCoordenadas().get(0).getY(), 40, 40, 270, 180, ArcType.OPEN);//right arc
        gc.strokeLine(this.getCoordenadas().get(2).getX(), this.getCoordenadas().get(2).getY(),  this.getCoordenadas().get(3).getX(), this.getCoordenadas().get(3).getY());
        gc.strokeArc(this.getCoordenadas().get(0).getX()-20, this.getCoordenadas().get(0).getY(), 40, 40, 90, 180,ArcType.OPEN);//left arc
        
        gc.setFont(Font.font(15));
        gc.fillText(this.getNombre(), (int)this.getCentralPoint().getX(), (int)this.getCentralPoint().getY());
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > this.getCoordenadas().get(0).getX()-20 &&
           p.getX() < this.getCoordenadas().get(1).getX()+20 &&
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
