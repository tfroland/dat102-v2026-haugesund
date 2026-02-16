package dat102.f08.sortering;

public class SorterTabell {
    /**
     * Sorter dei første n elmenta i tabellen i ikkje minkane ordning (det betyr
     * stigane ordning om der ikkje er like element).
     *
     * @param <T> Datatype på element som skal sorterast. Må vere ein referansetype
     * @param a   Tabell som skal sorterast
     * @param n   Angir kor mange (frå starten) element som skal sorterast >
     */
    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
        // Kunne brukt n i ytterste løkka, men når det er berre eit element
        // att vil dette vere det minste.
        for (int i = 0; i < n - 1; i++) {
            // finn indeks for minste element i usortert del
            T min = a[i];
            int minsteIndeks = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(min) < 0) {
                    minsteIndeks = j;
                    min = a[j];
                }
            }
            swap(a, i, minsteIndeks);
        }
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a) {
        sorterVedInnsetting(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a, int forste, int siste) {

        for (int i = forste + 1; i <= siste; i++) {

            T temp = a[i];
            int j = i - 1;

            // finn rett plass. Viktig med rekkefølge på operandeane i
            // betingelsen for whileløkka. Om vi byter, risiserer vi å
            // kome utanfor tabellen
            while (j >= forste && temp.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;
        }
    }


    /**
     * Oftast skal heile tabellen sorterast slik vi overlastar denne metoden slik at
     * dei som brukar den slepp skrive antal (a.length)
     *
     * @param <T> typeparameter
     * @param a   tabell som skal sorterast. Elkementa må vere av referansetype
     */
    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a) {
        utvalgssortering(a, a.length);
    }

    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

