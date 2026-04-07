package dat102.f18;

import java.util.HashMap;

public record Hero(String name, Move[] moves, HashMap<String, Item> inventory) {
}
