package dat102.f18;

import java.util.*;

public class Scenario implements ScenarioInterface{

    Move shoot = new Move("Shoot", 10, DamageType.PHYSICAL);
    Move fireball = new Move("Fireball", 11, DamageType.FIRE);
    Move frostbolt = new Move("Frostbolt", 12, DamageType.FROST);
    Move holyShield = new Move("Holy Shield", 13, DamageType.HOLY);
    Move deathCoils = new Move("Death Coils", 14, DamageType.UNHOLY);

    private final Map<String, Move> moves = new HashMap<>(Map.of(
            shoot.name(), shoot,
            fireball.name(), fireball,
            frostbolt.name(), frostbolt,
            holyShield.name(), holyShield,
            deathCoils.name(), deathCoils));

    private ArrayList<String> heroNames = new ArrayList<>(List.of(
            "Legolas",
            "Gimli",
            "Frodo",
            "Sam",
            "Galadriel"));

    // PHYSICAL
    Item shortbow = new Item("Shortbow", 12, 5, 2, DamageType.PHYSICAL);
    Item warhammer = new Item("Warhammer", 18, 10, 6, DamageType.PHYSICAL);
    Item dagger = new Item("Dagger", 8, 4, 1, DamageType.PHYSICAL);
    Item shield = new Item("Shield", 10, 3, 10, DamageType.PHYSICAL);

    // FIRE
    Item fireAxe = new Item("Fire Axe", 22, 14, 5, DamageType.FIRE);
    Item phoenixWand = new Item("Phoenix Wand", 18, 11, 2, DamageType.FIRE);

    // FROST
    Item iceShard = new Item("Ice Shard", 14, 7, 1, DamageType.FROST);
    Item frostHammer = new Item("Frost Hammer", 25, 16, 8, DamageType.FROST);

    // HOLY
    Item sunMace = new Item("Sun Mace", 19, 12, 4, DamageType.HOLY);

    // UNHOLY
    Item shadowDagger = new Item("Shadow Dagger", 13, 6, 1, DamageType.UNHOLY);

    // Collections of items by category
    ArrayList<Item> physicalItems = new ArrayList<>(List.of(shortbow, warhammer, dagger, shield));
    ArrayList<Item> fireItems = new ArrayList<>(List.of(fireAxe, phoenixWand));
    ArrayList<Item> frostItems = new ArrayList<>(List.of(iceShard, frostHammer));
    ArrayList<Item> holyItems = new ArrayList<>(List.of(sunMace));
    ArrayList<Item> unholyItems = new ArrayList<>(List.of(shadowDagger));

    private Map<String, ArrayList<Item>> items = new HashMap<>(Map.of(
        "Physical", physicalItems,
        "Fire", fireItems,
        "Frost", frostItems,
        "Holy", holyItems,
        "Unholy", unholyItems
    ));

    Hero hero1 = new Hero(
            "Legolas",
            new Move[] {moves.get("Shoot")},
            new HashMap<>(Map.of("Shortbow", shortbow, "Dagger", dagger)));

    Hero hero2 = new Hero(
            "Gandalf",
            new Move[] {moves.get("Fireball"), moves.get("Holy Shield")},
            new HashMap<>(Map.of("Phoenix Wand", phoenixWand, "Sun Mace", sunMace)));

    Hero hero3 = new Hero(
            "Frodo",
            new Move[] {moves.get("Shoot")},
            new HashMap<>(Map.of("Shadow Dagger", shadowDagger)));

    private Hero[] heroes = {hero1, hero2, hero3};

    private List<Hero> chosenHeroes = new ArrayList<>();

    public Scenario(Hero[] playerHeroes){
        this.chosenHeroes.addAll(Arrays.stream(playerHeroes).toList());
    }

    public Scenario(){

    };

    @Override
    public Map<String, Move> getMoves() {
        return moves;
    }

    @Override
    public ArrayList<String> getHeroNames() {
        return heroNames;
    }

    @Override
    public Map<String, ArrayList<Item>> getItems() {
        return items;
    }

    @Override
    public Hero[] getHeroes(){
        return heroes;
    }

    @Override
    public void pickHeroes(Hero[] chosenHeroes){
        this.chosenHeroes.addAll(Arrays.stream(chosenHeroes).toList());
    }

    @Override
    public boolean equals(Object o){
        // 1. Sjekk referanse (er det samme objekt i minnet?)
        if (this == o) return true;

        // 2. Sjekk type og null (bruker moderne pattern matching fra Java 16+)
        if (!(o instanceof Scenario other)) return false;

        // 3. Sammenlign de relevante feltene (chosenHeroes)
        return Objects.equals(this.chosenHeroes, other.chosenHeroes);
    }

    @Override
    public int hashCode() {
        // Genererer en hash basert på listen med valgte helter
        return Objects.hash(chosenHeroes);
    }
}
