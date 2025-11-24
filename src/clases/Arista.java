
package clases;

import java.awt.Graphics;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class Arista {
    private Nodo origen;
    private Nodo fin;
    
    public Arista(Nodo origen, Nodo fin){
        this.origen = origen;
        this.fin = fin;
    }
    
    public Nodo getOrigen(){
        return origen;
    }
    
    public Nodo getFin(){
        return fin;
    }
    
    public void dibujar(Graphics g){
        g.drawLine(origen.getX(), origen.getY(), fin.getX(), fin.getY());
    }
}
