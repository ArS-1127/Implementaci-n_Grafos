package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class PanelGrafo extends JPanel implements MouseListener{
    private Grafo grafo;
    private Nodo seleccionado = null;   // Nodo seleccionado para aristas

    public PanelGrafo() {
        grafo = new Grafo();
        addMouseListener(this);

        // Eliminar usando SUPR (la lógica era correcta)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE && seleccionado != null) {
                    grafo.eliminarNodo(seleccionado);
                    seleccionado = null;
                    repaint();
                }
            }
        });

        setFocusable(true);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar aristas
        for (Arista a : grafo.getAristas()) {
            g.setColor(Color.BLACK); // Dibujar aristas en negro
            a.dibujar(g);
        }

        // Dibujar nodos
        for (Nodo n : grafo.getNodos()) {
            n.dibujar(g);
        }
        
        // Resaltar nodo seleccionado
        if (seleccionado != null) {
            g.setColor(Color.RED);
            // El óvalo de selección debe ser un poco más grande
            g.drawOval(seleccionado.getX() - Nodo.d/2 - 2, seleccionado.getY() - Nodo.d/2 - 2, Nodo.d + 4, Nodo.d + 4);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
        
        int x = e.getX();
        int y = e.getY();
        
        Nodo n = grafo.buscarNodo(x, y);
        
        // CLICK DERECHO = crear arista
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (n != null) {
                if (seleccionado == null) {
                    seleccionado = n; // primer nodo
                } else {
                    // Solo crear arista si el nodo seleccionado no es el mismo
                    if (seleccionado != n) { 
                        grafo.insertarArista(seleccionado, n);
                        seleccionado = null; // reset
                    }
                }
                repaint();
                return;
            } else {
                // Si el click derecho es en un área vacía, deseleccionar
                seleccionado = null;
                repaint();
            }
        }

        // CLICK IZQUIERDO = crear nodo o seleccionar/deseleccionar
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (n == null) {
                // Crear nodo nuevo
                String nombre = javax.swing.JOptionPane.showInputDialog("Nombre del nodo:");
                if (nombre != null && !nombre.trim().isEmpty()) {
                    grafo.insertarNodo(x, y, nombre.trim());
                    seleccionado = null;
                    repaint();
                }
            } else {
                // CLICK IZQUIERDO en nodo existente: Seleccionar para posible eliminación
                if (seleccionado == n) {
                    seleccionado = null;
                } else {
                    seleccionado = n; 
                }
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
