import models.Persona;
import nodes.Node;
import structures.graphs.Graph;
//import trees.IntTree;
import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        
        //runIntTree();
        //runTree();
        runGraph();
    }
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
