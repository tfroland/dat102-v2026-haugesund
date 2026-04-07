package dat102.f21;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        /*
           Konstruerer eit binært tre som ser slik ut

                 5
                / \
               1   7
         */
        BinaryTree<Integer> t1 = new BinaryTree<>(1);
        BinaryTree<Integer> t2 = new BinaryTree<>(7);
        BinaryTree<Integer> t3 = new BinaryTree<>(5, t1, t2);

        /*
           Konstruerer eit binært tre som ser slik ut

                 15
                / \
               11   17
         */
        BinaryTree<Integer> t4 = new BinaryTree<>(11);
        BinaryTree<Integer> t5 = new BinaryTree<>(17);
        BinaryTree<Integer> t6 = new BinaryTree<>(15, t4, t5);

        /*
           Lag eit tre med 0 som rot og t3 som venstre undertre og t6 som høgre undertre

                 0
                / \
              t3   t6
         */
        BinaryTree<Integer> t7 = new BinaryTree<>(0, t3, t6);

        // Test inorden-iteratoren på t3 (forventa: 1 5 7)
        Iterator<Integer> it = t3.getInorderIterator();
        System.out.print("Inorden t3: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // No bruker vi rekkefølga som er gitt i iterator-metoden som vi
        // overlasta frå Iterable-interfacet (preorden)
        System.out.print("Preorden t7: ");
        for (Integer e : t7) {
            System.out.print(e + " ");
        }
        System.out.println();

        // Test getCount og getHeight
        System.out.println("Antal noder i t7: " + t7.getCount());
        System.out.println("Høgde på t7: " + t7.getHeight());
        System.out.println("Antal noder på nivå 2 i t7: " + t7.getCountAtLevel(2));

        // Test postorden og nivåorden
        System.out.print("Postorden t7: ");
        Iterator<Integer> postIt = t7.getPostorderIterator();
        while (postIt.hasNext()) {
            System.out.print(postIt.next() + " ");
        }
        System.out.println();

        System.out.print("Nivåorden t7: ");
        Iterator<Integer> levelIt = t7.getLevelOrderIterator();
        while (levelIt.hasNext()) {
            System.out.print(levelIt.next() + " ");
        }
        System.out.println();
    }
}