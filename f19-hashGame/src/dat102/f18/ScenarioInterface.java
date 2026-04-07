package dat102.f18;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ScenarioInterface {
    Map<String, Move> getMoves();
    List<String> getHeroNames();
    Map<String, ArrayList<Item>> getItems();
    Hero[] getHeroes();
    void pickHeroes(Hero[] chosenHeroes);
}
