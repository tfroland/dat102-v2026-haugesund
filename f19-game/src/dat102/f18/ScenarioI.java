package dat102.f18;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ScenarioI {
    /**
     * Henter navn på heltene som kan opprettes.
     *
     * @return En liste over navn på heltene, representert som tekststreng.
     */
    List<String> getHeroNames();

    Map<String, Move> getMoves();

    Map<String, ArrayList<Item>> getItems();

    Hero[] getHeroes();

    void addHeroes(Hero[] chosenHeroes);
}
