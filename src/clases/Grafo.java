package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariadna Soriano Apolinar
 */

public class Grafo {
    private List<Nodo> nodos;
    private List<Arista> aristas;

    public Grafo() {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public List<Nodo> getNodos() { 
        return nodos; 
    }
    
    public List<Arista> getAristas() { 
        return aristas; 
    }

    //INSERTAR NODO
    public void insertarNodo(int x, int y, String nombre) {
        nodos.add(new Nodo(x, y, nombre));
    }


    //ELIMINAR NODO
    public void eliminarNodo(Nodo nodo) {
        // Borra primero las aristas relacionadas
        aristas.removeIf(a -> a.getOrigen() == nodo || a.getFin() == nodo);

        nodos.remove(nodo);
    }
    
    //INSERTAR ARISTA
    public void insertarArista(Nodo a, Nodo b) {
        aristas.add(new Arista(a, b));
    }

    //ELIMINAR ARISTA
    public void eliminarArista(Arista arista) {
        aristas.remove(arista);
    }
    
    //BUSCAR NODO
    public Nodo buscarNodo(String nombre) {
        for (Nodo n : nodos) {
            if (n.getNombre().equals(nombre)) return n;
        }
        return null;
    }
}
