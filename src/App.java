import models.Persona;
//import trees.IntTree;
import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Xavier Fajardo");
        //runIntTree();
        runTree();
    }
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
