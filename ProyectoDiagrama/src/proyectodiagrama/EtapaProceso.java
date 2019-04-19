/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author BLANSKPC
 */
public class EtapaProceso extends Figuras{
    private int x = 0, y = 0;
    
    //Constructor
    public EtapaProceso (/*int x ,int y*/){
        //setX(x);
        //setY(y);
    }
    
    public void dibujarRect(GraphicsContext gc){
        gc.strokeLine(300, 40, 500, 40);//top
        gc.strokeLine(300, 100, 500, 100);//bottom
        gc.strokeLine(300, 40, 300, 100);//left
        gc.strokeLine(500, 40, 500, 100);//right
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
