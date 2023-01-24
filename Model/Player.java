import java.util.ArrayList;
import java.util.Collections;

public abstract class Player {
	protected ArrayList<Pokemon> pokemonBag;
	protected ArrayList<Items> potionBag;
	public Pokemon currentPokemon;
	private String name;

	public Player() {
		pokemonBag = new ArrayList<>();
		potionBag = new ArrayList<>();
		ArrayList<Pokemon> pokemons = Pokemon.readFile();
		ArrayList<Items> items = Items.readFile();
		mix(pokemons);
		mix(items);

		for(int i = 0; i < 4; ++i) {
			pokemonBag.add(pokemons.get(i));
		}

		for(int i = 0; i < 4; ++i) {
			potionBag.add(items.get(i));
		}

		this.currentPokemon = pokemonBag.get(0);
	}
	
	public static <V> void mix(ArrayList<V> arr) {
		Collections.shuffle(arr); 
	}

	abstract public void switchPokemon(int index);

	abstract public void useItems(Items item);
}