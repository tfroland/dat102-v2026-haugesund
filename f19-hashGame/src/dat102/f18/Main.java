package dat102.f18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ScenarioInterface scenario1 = new Scenario();
        ScenarioInterface scenario2 = new Scenario();
        ScenarioInterface scenario3 = new Scenario();

        Hero[] availableHeroes = scenario1.getHeroes();

        scenario1.pickHeroes(new Hero[] {availableHeroes[0], availableHeroes[1]});
        scenario2.pickHeroes(new Hero[] {availableHeroes[0]});
        scenario2.pickHeroes(new Hero[] {availableHeroes[1]});
        scenario3.pickHeroes(new Hero[] {availableHeroes[2]});

        System.out.println(scenario1.equals(scenario2));
        System.out.println(scenario2.equals(scenario3));
        System.out.println(scenario1.equals(scenario3));

        System.out.println(scenario1.hashCode());
        System.out.println(scenario2.hashCode());
        System.out.println(scenario3.hashCode());
    }


}
