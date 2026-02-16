package dat102.f10.radixsortering;

public class Main {
    static void main() {
        Integer[] a = {411, 214, 1, 500, 213};
        Sorter_Positive_Heltall.radixSortering(a);

        for (Integer e : a) {
            System.out.print(e + " ");
        }
    }
}
