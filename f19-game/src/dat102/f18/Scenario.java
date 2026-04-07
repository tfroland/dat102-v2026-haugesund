package dat102.f18;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scenario implements ScenarioI{

    private List<String> heroNames = new ArrayList<>(List.of(
            "Legolas",
            "Gimli",
            "Frodo",
            "Galadriel"
    ));


    @Override
    public List<String> getHeroNames() {
        return heroNames;
    }

    @Override
    public Map<String, Move> getMoves() {
        return Map.of();
    }

    @Override
    public Map<String, ArrayList<Item>> getItems() {
        return Map.of();
    }

    @Override
    public Hero[] getHeroes() {
        return new Hero[0];
    }

    @Override
    public void addHeroes(Hero[] chosenHeroes) {

    }
}
