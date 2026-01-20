package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import nodes.Node;

public class Graph<T> {
    // primera forma
    /// Trabaja con Listado de Adyaciencia
    //List<Node<T>> nodes;

    // segunda forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        //this.nodes = new ArrayList<Node<T>>();
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }

    public void addNode(Node<T> node) {
        mapa.putIfAbsent(node, new ArrayList<>());
    }

    // grafo no dirigido
    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);

        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
        
        //List<Node<T>> listadoNodo1 =  mapa.get(n1);
        //listadoNodo1.add(n2);
    }

    public void addConocido(T val1, T val2){
        Node<T> n1 = new Node<T>(val1);
        Node<T> n2 = new Node<T>(val2);
        addEdge(n1, n2);
    }

    public void printGraph() {
        for(Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for(Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }   
    }
    public Node<T>[] getNeighbors(Node<T> node) {
        List<Node<T>> neighbors = mapa.get(node);
        if (neighbors != null) {
            return neighbors.toArray(new Node[0]);
        } else {
            return new Node[0];
        }
    }

    public List<Node<T>> getNeighbors2(Node<T> n){
        return mapa.getOrDefault(n, List.of());
    }

    public void bfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();
        visitados.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.println(current.getValue() + " ");

            for(Node<T> conocido : getNeighbors2(current)){
                if(!visitados.contains(conocido)){
                    visitados.add(conocido);
                    queue.add(conocido);
                }
            }
   
        }
    }
    public void dfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }

    private void dfsRecursive(Node<T> current, Set<Node<T>> visitados) {
        visitados.add(current);
        System.out.println(current.getValue() + "");

        for(Node<T> conocido : getNeighbors2(current)){
            if(!visitados.contains((conocido))){
                dfsRecursive(conocido, visitados);
            }
        }

    }

}
