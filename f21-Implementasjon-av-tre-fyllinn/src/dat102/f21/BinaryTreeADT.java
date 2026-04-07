package dat102.f21;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
    // Boka sitt TreeInterface<T>
    int getCount();
    T getRootData();
    int getHeight();
    boolean isEmpty();
    void clear();

    // Uvanleg, men for å ha ei oppgåve
    int getCountAtLevel(int k);

    // Boka sitt TreeIteratorInterface<T>
    Iterator<T> getPreorderIterator();
    Iterator<T> getInorderIterator();
    Iterator<T> getPostorderIterator();
    Iterator<T> getLevelOrderIterator();

    // Spesielt for binære tre

    /**
     * Lagar eit binært tre med ein node
     *
     * @param rootData Objektet som er data i rota
     */
    void setTree(T rootData);

    /**
     * Konstruer eit nytt binært tre
     *
     * @param rootData  Objektet som er data i rota
     * @param left      Venstre undertre for det nye treet
     * @param right     Høgre undertre for det nye treet
     */
    void setTree(T rootData, BinaryTreeADT<T> left, BinaryTreeADT<T> right);
}