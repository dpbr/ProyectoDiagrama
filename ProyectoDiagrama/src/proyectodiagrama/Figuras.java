package proyectodiagrama;

import java.util.ArrayList;
import javafx.geometry.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BLANSKPC
 */
public abstract class Figuras {
    Point2D centralPoint;
    ArrayList<Point2D> coordenadas = new ArrayList<>();
    
    public Point2D getCentralPoint() {
        return centralPoint;
    }

    public void setCentralPoint(Point2D centralPoint) {
        this.centralPoint = centralPoint;
    }
}
