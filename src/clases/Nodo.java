package clases;

import java.awt.Graphics;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class Nodo {
    private int x, y;
    public static final int d = 70;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void  dibujar(Graphics g){
        g.drawOval(this.x - d/2, this.y - d/2, d, x);
    }
    
    public void insertar(Object nuevoDato){
        
    }
}
