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
    Figura siguientesi;
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
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(1).getY(), coordenadas.get(4).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(), coordenadas.get(5).getX(), coordenadas.get(1).getY());
        //Dibujar fondo
        gc.setStroke(Color.rgb(216,228,254));//azul cielo
        gc.setLineWidth(2);
        for (int i = 0; coordenadas.get(0).getY()+i <= coordenadas.get(2).getY() ;i++) {
                gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(), coordenadas.get(0).getX(), coordenadas.get(0).getY()+i);
                gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY()+i, coordenadas.get(1).getX(), coordenadas.get(1).getY());
        }
        
        //Dibujar líneas
        gc.setStroke(Color.BLUE);//línea roja pálida más intensa
        gc.setLineWidth(1);
        gc.strokeLine(coordenadas.get(0).getX(), coordenadas.get(0).getY(),  coordenadas.get(1).getX(), coordenadas.get(1).getY());
        gc.strokeLine(coordenadas.get(1).getX(), coordenadas.get(1).getY(),  coordenadas.get(2).getX(), coordenadas.get(2).getY());
        gc.strokeLine(coordenadas.get(2).getX(), coordenadas.get(2).getY(),  coordenadas.get(3).getX(), coordenadas.get(3).getY());
        gc.strokeLine(coordenadas.get(3).getX(), coordenadas.get(3).getY(),  coordenadas.get(0).getX(), coordenadas.get(0).getY());
        gc.setFont(Font.font(15));
        gc.fillText(nombre, (int)centralPoint.getX(), (int)centralPoint.getY());
        
        gc.setFill(Color.RED);
        gc.setFont(Font.font(10));
        gc.fillText("F", coordenadas.get(3).getX()-15, coordenadas.get(1).getY()-10);
        gc.fillText("V", coordenadas.get(1).getX()+15, coordenadas.get(1).getY()-10);
        gc.setFill(Color.BLACK);
    }

    @Override
    public boolean estaDentro(Point2D p) {
        if(p.getX() > coordenadas.get(3).getX() &&
           p.getX() < coordenadas.get(1).getX() &&
           p.getY() > coordenadas.get(0).getY() &&
           p.getY() < coordenadas.get(2).getY()){
            return true;
        }
        return false;
    }

    @Override
    public void crear(Point2D p) {
        coordenadas.clear();
        coordenadas.add(new Point2D(p.getX(),p.getY()-30));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4)+30,p.getY()));
        coordenadas.add(new Point2D(p.getX(),p.getY()+30));
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4)-30,p.getY()));
        //líneas que salen de la condición que se conectarán con las otras figuras
        coordenadas.add(new Point2D(p.getX()-((ancho()*3)/4)-110,p.getY()));
        coordenadas.add(new Point2D(p.getX()+((ancho()*3)/4)+110,p.getY()));
    }
    
}
