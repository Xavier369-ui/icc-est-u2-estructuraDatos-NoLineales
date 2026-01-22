package structures.graphs;

import java.util.List;

import nodes.Node;

public class PathResult<T> {

    private final List<Node<T>> visistados;
    private final List<Node<T>> path;


    public PathResult(List<Node<T>> visistados, List<Node<T>> path) {
        this.visistados = visistados;
        this.path = path;
    }


    public List<Node<T>> getVisistados() {
        return visistados;
    }


    public List<Node<T>> getPath() {
        return path;
    }

    

    


    
}
