package clases;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import proyectodiagrama.*;

/**
 *
 * @author BLANSKPC
 */
public class EntradaSalida extends Figura {
    boolean bentrada=ProyectoDiagramaController.bentrada;
    //Constructor
    public EntradaSalida (Point2D p){
        this.setNombre("   ");
        this.setCentralPoint(p);
    }
    
    @Override
    public void dibujarFigura(GraphicsContext gc) {
        //poner texto dentro de la figura
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        //Dibuja fondo
        if(bentrada){
            //si no es salida entonces es entrada y tendrá otro color
            gc.setStroke(Color.rgb(253,229,242));//rosa
        }
        else{
            //si es salida entonces tendrá un color distinto a entrada
            gc.setStroke(Color.rgb(228,255,233));//verde
        }
        
        gc.setLineWidth(3.5);
        for (int i = 0; i < (this.getCoordenadas().get(1).getX()-this.getCoordenadas().get(0).getX()-3); i++) {
            gc.strokeLine(this.getCoordenadas().get(1).getX()-i-3, this.getCoordenadas().get(1).getY()+3,  this.getCoordenadas().get(2).getX()-i, this.getCoordenadas().get(2).getY()-3);
        }
        
        //Dibuja las líneas
        if(bentrada){
            gc.setStroke(Color.rgb(244,108,183));//dibujará las líneas con un rosa más oscuro
            
        }
        else{
            gc.setStroke(Color.rgb(79,255,101));//dibujará las líneas con un verde más oscuro
        }
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
        if(p.getX() > this.getCoordenadas().get(3).getX() &&
           p.getX() < this.getCoordenadas().get(1).getX() &&
           p.getY() > this.getCoordenadas().get(1).getY() &&
           p.getY() < this.getCoordenadas().get(3).getY()){
            return true;
        }
        return false;
    }

    @Override
    public void crear(Point2D p) {
        this.getCoordenadas().clear();
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4)+10,p.getY()-20));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4)+10,p.getY()-20));
        this.getCoordenadas().add(new Point2D(p.getX()+((ancho()*3)/4)-10,p.getY()+20));
        this.getCoordenadas().add(new Point2D(p.getX()-((ancho()*3)/4)-10,p.getY()+20));
    }
    
}
