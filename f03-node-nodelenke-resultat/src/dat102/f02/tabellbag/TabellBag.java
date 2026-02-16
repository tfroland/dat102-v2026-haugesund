package dat102.f02.tabellbag;

import java.util.Arrays;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class TabellBag<T> implements BagADT<T> {

	private static final int DEFAULT_KAPASITET = 10;

	private T[] tabell;
	private int antall;

	/************************************************************/

	public TabellBag() {
		this(DEFAULT_KAPASITET);
	}

	@SuppressWarnings("unchecked")
	public TabellBag(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
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
        if (antall >= tabell.length) { //Full
            //return false;
            // Alternativt, vi flytter elementene over i en større tabell
            // før innsetting hvis den gamle er full.
            tabell = Arrays.copyOf(tabell, tabell.length * 2);
        }
        tabell[antall] = newEntry;
        antall++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) { //Tom
            return null;
        }
        T temp = tabell[antall-1];
        tabell[antall-1] = null;
        antall--;
        return temp;
    }

    @Override
    public boolean remove(T anEntry) {

        // 1. Finne ut hvor et element lik anEntry ligger.
        //    Kanskje dette bør være en hjelpemetode?
        int funnetIndeks = -1;
        int i = 0;
        while (i < antall && funnetIndeks == -1) {
            if (anEntry.equals(tabell[i])) {
                funnetIndeks = i;
            }
            i++;
        }

        // 2. Hvis ikke funnet, returner false
        if (funnetIndeks == -1) {
            return false;
        }

        // 3. Fjerner den på funnetIndeks ved å sette siste inn i hullet
        tabell[funnetIndeks] = tabell[antall - 1];
        tabell[antall - 1] = null;
        antall--;

        return true;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
        antall = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {

        int teller = 0;
        for (int i=0; i < antall; i++) {
            if (tabell[i].equals(anEntry)) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public boolean contains(T anEntry) {
        return getFrequencyOf(anEntry) > 0; //Er det noen ulempe med å gjøre det slik?
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(tabell, antall);
    }

    /************************************************************/

}
