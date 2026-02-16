package dat102.f02.tabellbag;

import dat102.f03.noder.Node;

public class LenketBag<T> implements BagADT<T> {

    private Node<T> forste;
    private int antall;

    public LenketBag() {
        forste = null;
        antall = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return antall;
    }

    @Override
    public boolean isEmpty() {
        return antall == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> temp = new Node<>(newEntry);
        temp.neste = forste;
        forste = temp;
        antall++;
        return true;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
