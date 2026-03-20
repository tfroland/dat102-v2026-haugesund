package dat102.f18;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        TabellOrdbok<Integer, String> hm = new TabellOrdbok<>(100);
        Integer tall = 15;
        String s = new String("femten");
        hm.leggTil(tall, s);

        String gmlVerdi = hm.leggTil(tall, "Femten");
        System.out.println(gmlVerdi);

        System.out.println(hm.getVerdi(tall));


        TabellOrdbok<String, ArrayList<String>> pokemonTrenere = new TabellOrdbok<>(100);
        String trener1 = "Ash";
        ArrayList<String> trener1pokemoner = new ArrayList<>();
        trener1pokemoner.add("Pikachu");
        trener1pokemoner.add("Pidgey");
        trener1pokemoner.add("Krabby");

        String trener2 = "Gary";
        ArrayList<String> trener2pokemoner = new ArrayList<>((Arrays.asList("Rapidash", "Ninetales", "Charizard")));

        pokemonTrenere.leggTil(trener1, trener1pokemoner);
        pokemonTrenere.leggTil(trener2, trener2pokemoner);

        System.out.println(pokemonTrenere.getVerdi(trener1));
        System.out.println(pokemonTrenere.getVerdi(trener2));
    }

}
