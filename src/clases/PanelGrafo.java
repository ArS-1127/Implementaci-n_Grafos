package clases;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Ariadna Soriano Apolinar
 */
public class PanelGrafo extends JPanel implements MouseListener{
    
    private Vector<Nodo> vectorNodos;
    
    public PanelGrafo() {
        this.vectorNodos = new Vector<>();
        this.addMouseListener(this);
    }
    
    public void dibujar (Graphics g){
        for(Nodo nodos : vectorNodos){
            nodos.dibujar(g);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

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
