/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiagrama;

/**
 *
 * @author BLANSKPC
 */
public class Linea extends Figuras {
    //Constructor
    public Linea (){
        
    }
    
    public void dibujarLinea(GraphicsContext gc){ //tiene que recibir las coordenadas x e y del mouse
        gc.strokeLine(400, 40, 400, 120);//linea vertical la linea tiene un largo de 80
        //punta de la linea
        gc.strokeLine(395, 115, 400, 120);//left cada punto tiene un largo de 5
        gc.strokeLine(405, 115, 400, 120);//right
    }
}
