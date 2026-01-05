import trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Xavier Fajardo");
        runIntTree();
    }
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
}
