package dat102.f10.radixsortering;
import java.util.ArrayList;
import java.util.List;

public class Sorter_Positive_Heltall {

    private static int finnSiffer(int tall, int vekt) {
        return (tall / vekt) % 10;
    }

    private static int finnStorste(Integer[] data) {
        int maks = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maks) {
                maks = data[i];
            }
        }
        return maks;
    }

    private static int lengde(int tall) {
        return ("" + tall).length();
    }

    public static void radixSortering(Integer[] data) {
        // Antar at talla er gitt i 10-talssystemet om grunntall ikke er spesifisert
        radixSortering(data, 10);
    }


    public static void radixSortering(Integer[] data, int radix) {
        int n = data.length;
        int maks = finnStorste(data);
        int maksAntallSiffer = lengde(maks);

        List<Integer>[] sifferkoer = new List[radix];
        for (int i = 0; i < radix; i++) {
            sifferkoer[i] = new ArrayList<Integer>();
        }

        int vekt = 1; // starter på enerposisjon
        for (int i = 0; i < maksAntallSiffer; i++) {

            // fordeler i køer
            for (int j = 0; j < n; j++) {
                int siffer = finnSiffer(data[j], vekt);
                sifferkoer[siffer].add(data[j]);
            }

            // slår sammen køene
            int p = 0;
            for (int k = 0; k < radix; k++) {
                for (Integer e : sifferkoer[k]) {
                    data[p] = e;
                    p++;
                }
                sifferkoer[k].clear();
            }

            vekt *= 10; // flytter til neste siffer
        }
    }
}
