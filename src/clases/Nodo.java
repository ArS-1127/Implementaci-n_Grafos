package clases;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class Nodo {
    private int x, y;         
    public static final int d = 40;  
    private String nombre;    

    public Nodo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }

    public int getX() { 
        return x; 
    }
    
    public int getY() { 
        return y; 
    }
    
    public String getNombre() { 
        return nombre; 
    }

    public void dibujar(Graphics g){
        // nodo
        g.setColor(Color.WHITE);
        g.fillOval(x - d/2, y - d/2, d, d);

        g.setColor(Color.BLACK);
        g.drawOval(x - d/2, y - d/2, d, d);

        // texto centrado
        g.drawString(nombre, x - 6, y + 4);
    }
}
