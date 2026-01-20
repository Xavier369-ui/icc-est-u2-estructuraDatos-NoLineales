import models.Persona;
import nodes.Node;
import structures.graphs.Graph;
//import trees.IntTree;

//import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        
        //runIntTree();
        //runTree();
        //runGraph();
        runGraphRecorridos();
    }
    public static void runGraphRecorridos(){
        Graph<Persona> grafo = new Graph<>();
        Persona pC23 = new Persona("Carlos", 23);
        Persona pL18 = new Persona("Luis", 18);
        Persona pA23 = new Persona("Andres", 23);
        Persona pA30 = new Persona("Ana", 30);
        Persona pJ25 = new Persona("Juan", 25);
        Persona pA20 = new Persona("Ana", 20);
        grafo.addEdge(new Node<Persona>(pC23), new Node<Persona>(pA30));
        grafo.addConocido(pC23, pL18);
        grafo.addConocido(pC23, pA23);
        grafo.addConocido(pA30, pJ25);
        grafo.addConocido(pA23, pA20);
        // imprimimos todo el grafo
        grafo.printGraph();
        //imprimimos el recorrido bfs
        System.out.println("\nRecorrido BFS:");
        grafo.bfs(new Node<Persona>(pC23));
        
        // imprimimos el recorrido dfs
        System.out.println("\nRecorrido DFS:");
        grafo.dfs(new Node<Persona>(pC23));
        


    }
    /* 
    public static void runGraph(){

        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");

        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);
        graph.printGraph();

        //Conectados de A
        Node<String>[] neigtbors = graph.getNeighbors(nA);
        System.out.print("Nodos conectados a A: ");
        for(Node<String> neighbor : neigtbors){
            System.out.print(neighbor + " ");
        }

       
        
        
    }
    */
    /* 
    public static void runTree(){
        Tree<Persona> tree = new Tree<Persona>();
        tree.insert(new Persona("Pablo", 21));
        tree.insert(new Persona("Maria", 23));
        tree.insert(new Persona("Ana", 25));
        tree.insert(new Persona("Pedro", 23));
        tree.insert(new Persona("Luis", 19));
        tree.inOrder();
        Persona findPerson = tree.searchByAge(23);
        if(findPerson != null){
            System.out.println("Persona encontrada: " + findPerson);
        } else {
            System.out.println("Persona no encontrada");
        }
        

        
        
    }
    */
    /* 
    private static void runIntTree(){
        IntTree intTree = new IntTree();
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(15);

        System.out.print("Pre Order: ");
        intTree.preOrder();
        System.out.println();

        System.out.print("Pos Order: ");
        intTree.posOrder();
        System.out.println();

        System.out.print("In Order: ");
        intTree.inOrder();
        System.out.println();

        System.out.println("Size: " + intTree.size());

    }
    */
}
