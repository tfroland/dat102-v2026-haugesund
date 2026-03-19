package dat102.f17;

import java.util.HashMap;
import java.util.Iterator;

public class Ordbok<K, V> implements OrdbokInterface<K, V> {

    private HashMap<K, V> ordbok;

    public Ordbok() {
        this.ordbok = new HashMap<>();
    }

    @Override
    public V leggTil(K nokkel, V verdi) {
        return ordbok.put(nokkel, verdi);
    }

    @Override
    public V fjern(K nokkel) {
        return ordbok.remove(nokkel);
    }

    @Override
    public V getVerdi(K nokkel) {
        return ordbok.get(nokkel);
    }

    @Override
    public boolean inneholder(K nokkel) {
        return ordbok.containsKey(nokkel);
    }

    @Override
    public Iterator<K> getNokkelIterator() {
        return ordbok.keySet().iterator();
    }

    @Override
    public Iterator<V> getVerdiIterator() {
        return ordbok.values().iterator();
    }

    @Override
    public boolean erTom() {
        return ordbok.isEmpty();
    }

    @Override
    public int getAntall() {
        return ordbok.size();
    }

    @Override
    public void toem() {
        ordbok.clear();
    }

}
