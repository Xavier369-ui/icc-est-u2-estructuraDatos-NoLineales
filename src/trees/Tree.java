package trees;

import models.Persona;
import nodes.Node;

public class Tree<T extends Comparable<T>> {
    
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
        
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));           
        }
        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }
    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getValue() + "  ");
            inOrderRecursive(node.getRight());
        }
    }
    public T searchByAge(int i) {
        return searchByAgeRecursive(root, i);

    }
    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) {
            return null;
        }
        Persona persona = (Persona) current.getValue();
        if (persona.getEdad() == age) {
            return current.getValue();
        }
        if(age == persona.getEdad()){
            return current.getValue();
        }else{
            T leftResult = searchByAgeRecursive(current.getLeft(), age);
            if (leftResult != null) {
                return leftResult;
            }
            return searchByAgeRecursive(current.getRight(), age);
        }
    }
    public T search(T value) {
        return searchRecursive(root, value);
    }
    private T searchRecursive(Node<T> root2, T value) {
        if (root2 == null) {
            return null;
        }
        if (value.compareTo(root2.getValue()) == 0) {
            return root2.getValue();
        }
        T leftResult = searchRecursive(root2.getLeft(), value);
        if (leftResult != null) {
            return leftResult;
        }
        return searchRecursive(root2.getRight(), value);
    }

}
