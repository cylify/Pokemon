import java.util.ArrayList;

public abstract class Player {
	protected static ArrayList<Pokemon> pokemonBag;
	protected static Bag potionBag;

	public Player() {
		pokemonBag = new ArrayList<>();
		ArrayList<Pokemon> pokemons = Pokemon.readFile();
		Game.mix(pokemons);

		for(int i = 0; i < 4; ++i) {
			pokemonBag.add(pokemons.get(i));
		}
	}
}