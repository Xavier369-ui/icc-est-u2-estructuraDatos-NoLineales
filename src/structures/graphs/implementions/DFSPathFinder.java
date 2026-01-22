package structures.graphs.implementions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nodes.Node;
import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResult;

public class DFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> find(Graph<T> graph, Node<T> start, Node<T> end) {

        Set<Node<T>> visitados = new LinkedHashSet<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();
        List<Node<T>> orden = new ArrayList<>();

        parent.put(start, null);

        dfsRecursive(graph, start, end, visitados, parent, orden);

        List<Node<T>> path = visitados.contains(end)
                ? buildPath(parent, end)
                : List.of();

        return new PathResult<>(orden, path);
    }

    // === MISMA lógica que tu dfsRecursive ===
    private void dfsRecursive(
            Graph<T> graph,
            Node<T> current,
            Node<T> end,
            Set<Node<T>> visitados,
            Map<Node<T>, Node<T>> parent,
            List<Node<T>> orden) {

        visitados.add(current);
        orden.add(current);

        if (current.equals(end)) {
            return;
        }

        for (Node<T> conocido : graph.getNeighbors2(current)) {
            if (!visitados.contains(conocido)) {
                parent.put(conocido, current);
                dfsRecursive(graph, conocido, end, visitados, parent, orden);
            }
        }
    }

    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parent, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();
        for (Node<T> at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
    
}
