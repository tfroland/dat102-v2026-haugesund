package dat102.f21;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T data) {
        root = new BinaryTreeNode<>(data);
    }

    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        privateSetTree(rootData, left, right);
    }

    @Override
    public int getCount() {
        return getCount(root);
    }

    private int getCount(BinaryTreeNode<T> t) {
        // Basistilfelle
        //if(!t.hasLeftChild() && !t.hasRightChild()){
        //    return 1;
        //}

        // Alternativ basis som er mer effektiv
        if (t == null){
            return 0;
        }

        // Rekursivt kall
        return 1 + getCount(t.getLeft()) + getCount(t.getRight());
    }

    @Override
    public int getCountAtLevel(int k) {
        return getCountAtLevel(root, k);
    }

    private int getCountAtLevel(BinaryTreeNode<T> t, int k) {
        // Basis: Tomt tre
        if (t == null){
            return 0;
        }

        // Basis: vi er på rett nivå, teller noden
        if (k == 1){
            return 1;
        }

        // Rekursivt kall
        return getCountAtLevel(t.getLeft(), k-1) + getCountAtLevel(t.getRight(), k-1);
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode<T> t) {
        // Basistilfelle
        if (t == null) {
            return 0;
        }

        // Rekursjon
        int leftHeight = getHeight(t.getLeft());
        int rightHeight = getHeight(t.getRight());

        //return 1+ leftHeight + rightHeight;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /*
     * Dei tre vis-metodane nedanfor er tatt med for å vise rekursiv gjennomgang av
     * tre. Bruk av iteratorar er meir generelt for det er ikkje sikkert at du
     * ønskjer å skrive ut elementa.
     */
    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(BinaryTreeNode<T> t) {
        if (t == null) {
            // basis: gjer ingenting
        } else {
            System.out.print(t.getElement() + " ");
            printPreorder(t.getLeft());
            printPreorder(t.getRight());
        }

        /*
         Alternativ
         // basis gjer ingenting
         if (t != null){
            dei tre kodelinjene
         }
         */
    }

    public void printInorder() {
        printInorder(root);
        System.out.println();
    }

    private void printInorder(BinaryTreeNode<T> t) {
        if (t == null) {
            // basis: gjer ingenting
        } else {
            printInorder(t.getLeft());
            System.out.print(t.getElement() + " ");
            printInorder(t.getRight());
        }
    }

    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(BinaryTreeNode<T> t) {
        // blir fylt inn på forelesning
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<T> {
        private Stack<BinaryTreeNode<T>> nodeStack;
        private BinaryTreeNode<T> currentNode;

        public InorderIterator() {
            nodeStack = new Stack<>();
            currentNode = root;
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        public T next() {
            BinaryTreeNode<T> nextNode = null;

            // Finn den vestlegaste noden utan venstre barn
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            // Hent den vestlegaste noden, flytt så til høgre undertre
            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.pop();
                currentNode = nextNode.getRight();
            } else {
                throw new NoSuchElementException();
            }

            return nextNode.getElement();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public T getRootData() {
        if (root == null) {
            return null;
        } else {
            return root.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    private class PreorderIterator implements Iterator<T> {
        private Stack<BinaryTreeNode<T>> nodeStack;
        private BinaryTreeNode<T> currentNode;

        public PreorderIterator() {
            nodeStack = new Stack<>();
            currentNode = root;
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        public T next() {
            BinaryTreeNode<T> nextNode = null;
            if (currentNode != null) {
                nextNode = currentNode;
                if (currentNode.getRight() != null) {
                    nodeStack.push(currentNode.getRight());
                }
                currentNode = currentNode.getLeft();
                if (currentNode == null && !nodeStack.isEmpty()) {
                    currentNode = nodeStack.pop();
                }
            } else {
                throw new NoSuchElementException();
            }
            return nextNode.getElement();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        // blir fylt inn på forelesning
        return new PostorderIterator();
    }

    private class PostorderIterator implements Iterator<T>{
        private Stack<BinaryTreeNode<T>> nodeStack;
        private BinaryTreeNode<T> currentNode;
        private BinaryTreeNode<T> lastVisited;

        public PostorderIterator(){
            nodeStack = new Stack();
            currentNode = root;
            lastVisited = null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }


    @Override
    public Iterator<T> getLevelOrderIterator() {
        // blir fylt inn på forelesning
        return null;
    }



    // Denne blir brukt i utvida for-løkker for ( : )
    @Override
    public Iterator<T> iterator() {
        return new PreorderIterator();
    }

    @Override
    public void setTree(T rootData) {
        root = new BinaryTreeNode<>(rootData);
    }

    @Override
    public void setTree(T rootData, BinaryTreeADT<T> left, BinaryTreeADT<T> right) {
        // Generelt må vi gå gjennom venstre og høgre for å lage nye nodar
        // Metoden nedanfor fungerer for vår implementasjon
    }

    public void setTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        privateSetTree(rootData, left, right);
    }

    private void privateSetTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        root = new BinaryTreeNode<>(rootData);

        if (left != null) {
            root.setLeft(left.root);
        }

        if (right != null) {
            root.setRight(right.root);
        }
    }
}