package dat102.f08.brukseksempel;

import dat102.f08.sortering.SorterTabell;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        List<Person> personer = new ArrayList<>();
        personer.add(new Person("Sven-Olai", "Høyland"));
        personer.add(new Person("Dag Toppe", "Larsen"));
        personer.add(new Person("Lars-Petter", "Helland"));
        personer.add(new Person("Ole", "Høyland"));

        Person[] tab = personer.toArray(new Person[0]);

        // Fungerer ikke før vi har laget utvalgssortering
        SorterTabell.utvalgssortering(tab);

        for (Person p : tab) {
            System.out.println(p);
        }

        Integer[] a = {7, 0, 2, 9, 11, 6};

        // Fungerer ikke før vi har laget sorteringVedInnsetting
        SorterTabell.sorterVedInnsetting(a);

        for (Integer e : a) {
            System.out.print(e + " ");
        }

        System.out.println();
    }

}

