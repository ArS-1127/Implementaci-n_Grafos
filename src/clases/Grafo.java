package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Ariadna Soriano Apolinar
 * @author Odrey Leonides Garcia
 * @author Jonathan Eliel Perfecto Enriquez
 */

public class Grafo {
    private Vector<Nodo> nodos;
    private Vector<Arista> aristas;

    public Grafo() {
        nodos = new Vector<>();
        aristas = new Vector<>();
    }

    public Vector<Nodo> getNodos() {
        return nodos;
    }

    public Vector<Arista> getAristas() {
        return aristas;
    }

    // INSERTAR NODO
    public void insertarNodo(int x, int y, String nombre) {
        nodos.add(new Nodo(x, y, nombre));
    }

    // INSERTAR ARISTA
    public void insertarArista(Nodo origen, Nodo fin) {
        // 1. Crear la arista
        Arista nuevaArista = new Arista(origen, fin);

        // 2. Comprobar si ya existe una arista entre estos nodos
        for (Arista a : aristas) {
            if (a.conecta(origen, fin)) {
                return; // Ya existe, no insertamos
            }
        }
        
        // 3. Agregar la arista a la lista del grafo
        aristas.add(nuevaArista);
        
        // 4. Conectar los nodos (actualiza las listas de vecinos de los nodos)
        origen.conectar(fin);
    }

    // ELIMINAR NODO (y aristas relacionadas)
    public void eliminarNodo(Nodo nodo) {
        // 1. Desconectar el nodo de sus vecinos (eliminar referencias de vecino)
        List<Nodo> vecinosCopia = new ArrayList<>(nodo.getVecinos()); 
        for (Nodo vecino : vecinosCopia) {
            nodo.desconectar(vecino); 
        }

        // 2. Borrar las aristas relacionadas
        aristas.removeIf(a -> a.getOrigen() == nodo || a.getFin() == nodo);
        
        // 3. Borrar el nodo
        nodos.remove(nodo);
    }

    // ELIMINAR ARISTA
    public void eliminarArista(Arista a) {
        // 1. Desconectar los nodos de la arista
        a.getOrigen().desconectar(a.getFin());
        
        // 2. Eliminar la arista
        aristas.remove(a);
    }

    // BUSCAR NODO POR PUNTO
    public Nodo buscarNodo(int x, int y) {
        for (Nodo n : nodos) {
            if (n.contienePunto(x,y)) {
                return n;
            }
        }
        return null;
    }
    
    // RECORRIDO EN PROFUNDIDAD DFS
    public List<Nodo> dfs() {
        List<Nodo> recorrido = new ArrayList<>();
        if (nodos.isEmpty()) return recorrido;

        Set<Nodo> visitados = new HashSet<>();
        // Iniciar desde el primer nodo
        Nodo inicio = nodos.get(0);

        dfsRec(inicio, visitados, recorrido);

        return recorrido;
    }

    private void dfsRec(Nodo n, Set<Nodo> visitados, List<Nodo> recorrido) {
        visitados.add(n);
        recorrido.add(n);
        
        for (Nodo vecino : n.getVecinos()) { 
            if (!visitados.contains(vecino)) {
                dfsRec(vecino, visitados, recorrido);
            }
        }
    }

    // RECORRIDO EN ANCHURA BFS
    public List<Nodo> bfs() {
        List<Nodo> recorrido = new ArrayList<>();
        if (nodos.isEmpty()) return recorrido;

        Queue<Nodo> cola = new LinkedList<>();
        Set<Nodo> visitados = new HashSet<>();

        Nodo inicio = nodos.get(0); 
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            recorrido.add(actual);
            
            for (Nodo vecino : actual.getVecinos()) { 
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        return recorrido;
    }
}