import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Player {
	protected static ArrayList<Pokemon> pokemonBag;
	protected static Bag potionBag;

	public Player() {
		pokemonBag = new ArrayList<>();
		ArrayList<Pokemon> pokemons = Pokemon.readFile();
		mix(pokemons);

		for(int i = 0; i < 4; ++i) {
			pokemonBag.add(pokemons.get(i));
		}
	}
	
	public static <V> void mix(ArrayList<V> arr) {
		Collections.shuffle(arr);
	}
}