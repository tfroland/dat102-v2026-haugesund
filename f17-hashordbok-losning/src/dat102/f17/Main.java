package dat102.f17;

import java.util.Iterator;

public class Main {

   void main() {

       // Oppgave: Finn ut hvor mange tilfeller det er av hvert ord.
       // Hvilke andre metoder har vi lært til nå?
       // Sortering - dyrt prosesseringsmessig
       // Tell opp underveis

        // Testdata
        String[] inventar = {"sverd", "lembasbrød", "pil", "sverd", "pil", "sverd"};

        // Lag ordbok
        Ordbok<String, Integer> frekvenser = new Ordbok<>();

        // Tell opp
        for (String s : inventar){

            Integer verdi = frekvenser.getVerdi(s);
            if(verdi == null){ // !frekvenser.inneholder(s)
                frekvenser.leggTil(s, 1);
            } else {
                frekvenser.leggTil(s, verdi+1);
            }
        }

        // Skriv frekvensoversikt
        Iterator<String> nIt = frekvenser.getNokkelIterator();
        Iterator<Integer> vIt = frekvenser.getVerdiIterator();

        while (nIt.hasNext()){
            System.out.println(nIt.next() + ": " + vIt.next());
        }
    }

}
