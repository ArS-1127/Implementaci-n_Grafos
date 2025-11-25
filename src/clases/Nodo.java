package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class Nodo {
    private int x, y;         
    public static final int d = 40;  
    private String nombre;   
    private List<Nodo> vecinos;

    public Nodo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.vecinos = new ArrayList<>();
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
    
    public List<Nodo> getVecinos() {
        return vecinos;
    }
    
    // Conectar nodos (grafo no dirigido)
    public void conectar(Nodo otro) {
        if (!vecinos.contains(otro)) {
            vecinos.add(otro);
        }
        
        if (!otro.vecinos.contains(this)) {
            otro.vecinos.add(this);
        }
    }
    
    // Desconectar nodos (necesario para eliminar aristas)
    public void desconectar(Nodo otro) {
        vecinos.remove(otro);
        otro.vecinos.remove(this);
    }
    

    public boolean contienePunto(int px, int py){
        int dx = px - x;
        int dy = py - y;
        return dx * dx + dy * dy <= (d/2) * (d/2);
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
    
    @Override
    public String toString() {
        return nombre;
    }
}